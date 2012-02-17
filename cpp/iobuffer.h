/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */

#ifndef CPP_TO_JAVA_RPC_IOBUFFER_H
#define CPP_TO_JAVA_RPC_IOBUFFER_H
#include <stdint.h>
#ifdef RPC_USE_QT
#include <QTcpSocket>
typedef QTcpSocket * RpcSocketPtr;
#else
#include <boost/asio.hpp>
typedef boost::asio::ip::tcp::socket * RpcSocketPtr;
#endif

namespace cppToJavaRpc {

class RpcInputStream
{
 public:
  explicit RpcInputStream(RpcSocketPtr socket);
  ~RpcInputStream();

  bool is_empty();
  bool read_some();
  uint8_t next_byte();
  void advance(int count);
  int size();
  char* char_ptr();
  bool refresh();

 private:
  uint8_t*  m_bytes;
  size_t    m_in_buffer;
  size_t    m_position;
  size_t    m_buffer_size;
  RpcSocketPtr m_socket;
};

class RpcOutputStream {
 public:
  explicit RpcOutputStream(RpcSocketPtr sock);
  ~RpcOutputStream();

  bool write(const char * data, size_t size);
  void flush();

 private:
  RpcSocketPtr m_socket;
};

class RpcSocketService {
  public:
    explicit RpcSocketService();
    RpcSocketPtr connect(std::string address, int port);
  private:
#ifdef RPC_USE_QT
#else
	boost::asio::io_service m_io_service;
#endif
    RpcSocketPtr m_socket;
};

};
#endif
