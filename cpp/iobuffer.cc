/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */

#include "iobuffer.h"

using namespace cppToJavaRpc;

RpcInputStream::RpcInputStream(RpcSocketPtr socket)
    : m_in_buffer(0), m_position(0), m_buffer_size(10000), m_socket(socket)
{
	m_bytes = new uint8_t[m_buffer_size];
}

RpcInputStream::~RpcInputStream()
{
	delete [] m_bytes;
}

bool RpcInputStream::is_empty()
{
	return size() == 0;
}

/* Warning: Destroys any data in the buffer, should only be called when
 * the buffer is empty. */
bool RpcInputStream::read_some()
{
#ifdef RPC_USE_QT
	m_socket->waitForReadyRead(2000000000);
	size_t sz = m_socket->read(reinterpret_cast<char*>(m_bytes), m_buffer_size);
#else
	size_t sz = m_socket->read_some(boost::asio::buffer(m_bytes, m_buffer_size));
#endif
	m_in_buffer = sz;
	m_position = 0;
	return true;
}

/* Warning: It the caller's responsibility to NOT read past the end of the buffer.
 */
uint8_t RpcInputStream::next_byte()
{
	return m_bytes[m_position];
}

/* Warning: It the caller's responsibility to NOT advance past the end of the buffer.
 */
void RpcInputStream::advance(int count)
{
	m_position += count;
}

int RpcInputStream::size()
{
	return m_in_buffer - m_position;
}

/* Warning: It is the caller's responsibility to NOT read past the end of
 * the buffer. */
char* RpcInputStream::char_ptr()
{
	return reinterpret_cast<char*>(&m_bytes[m_position]);
}

/* If the buffer is empty tries to read some more. */
bool RpcInputStream::refresh()
{
	if ((m_in_buffer - m_position) == 0)
		return read_some();
	return true;
}

RpcOutputStream::RpcOutputStream(RpcSocketPtr sock)
 :  m_socket(sock)
{}

RpcOutputStream::~RpcOutputStream()
{
}

bool RpcOutputStream::write(const char * data, size_t size) {
  if (size == 0) return true;
#ifdef RPC_USE_QT
  if (m_socket->write(data, size) != -1) {
#else
  if (boost::asio::write(*m_socket, boost::asio::buffer(data, size))) {
#endif
    return true;
  } else {
    return false;
  }
}

void RpcOutputStream::flush() {}

RpcSocketService::RpcSocketService()
#ifdef RPC_USE_QT
#else
	: m_io_service()
#endif
{ }

RpcSocketPtr RpcSocketService::connect(std::string address, int port)
{
#ifdef RPC_USE_QT
	QTcpSocket * socket;
	socket = new QTcpSocket;
	socket->connectToHost(address.c_str(), port);
	socket->waitForConnected(2000000000);
	return socket;
#else
	std::stringstream ss;
	ss << port;

	boost::asio::ip::tcp::socket * socket;
	socket = new boost::asio::ip::tcp::socket(m_io_service);

	boost::asio::ip::tcp::resolver resolver( m_io_service );
	boost::asio::ip::tcp::resolver::query query( address, ss.str() );
	boost::asio::ip::tcp::resolver::iterator endpoint_iterator = resolver.resolve( query );
	boost::asio::ip::tcp::resolver::iterator end;
	boost::system::error_code error = boost::asio::error::host_not_found;

	while (error && endpoint_iterator != end)
	{
		socket->close();
		socket->connect(*endpoint_iterator++, error);
	}
	if (error)
		return NULL;

	return socket;
#endif
}



