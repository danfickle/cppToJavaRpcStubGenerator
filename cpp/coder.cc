/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */

#include "coder.h"

using namespace cppToJavaRpc;

/* The variable sized integer protocol is taken from Google Protobuffers. */
bool Coder::ReadVarint64(uint64_t * value)
{
  uint64_t result = 0;
  int32_t count = 0;
  uint32_t b;

  do { 
    while (m_in->is_empty())
    {
      if (!m_in->refresh()) return false;
    }
    b = m_in->next_byte();
    result |= static_cast<uint64_t>(b & 0x7F) << (7 * count);
    m_in->advance(1);
    ++count;
  } while (b & 0x80);

  *value = result;
  return true;
}


/* Note: Strings are read and written in UTF-8 format. */
bool Coder::ReadString(std::string* buffer, int size)
{
  if (!buffer->empty()) {
    buffer->clear();
  }

  int current_buffer_size;
  while ((current_buffer_size = m_in->size()) < size)
  {
    // Some STL implementations "helpfully" crash on buffer->append(NULL, 0).
    if (current_buffer_size != 0)
    {
      buffer->append(reinterpret_cast<const char*>(m_in->char_ptr()),
                     current_buffer_size);
    }
    size -= current_buffer_size;
    m_in->advance(current_buffer_size);
    if (!m_in->refresh()) return false;
  }

  buffer->append(reinterpret_cast<const char*>(m_in->char_ptr()), size);
  m_in->advance(size);

  return true;
}

bool Coder::ReadVarint32(uint32_t * val)
{
	uint64_t val2;
	bool ret = ReadVarint64(&val2);
	*val = static_cast<uint32_t>(val2);
	return ret;
}

/* The variable sized integer protocol is taken from Google Protobuffers. */
bool Coder::WriteVarint64(uint64_t value)
{
    uint8_t bytes[64];
    int size = 0;
    while (value > 0x7F) {
      bytes[size++] = (static_cast<uint8_t>(value) & 0x7F) | 0x80;
      value >>= 7;
    }
    bytes[size++] = static_cast<uint8_t>(value) & 0x7F;
    return m_out->write(reinterpret_cast<char*>(bytes), size);
}

int Coder::VarintSize32(uint32_t value)
{
	return VarintSize64(value);
}

int Coder::VarintSize64(uint64_t value)
{
    int size = 0;
    while (value > 0x7F) {
      size++;
      value >>= 7;
    }
    size++;
    return size;
}

/* Note: Strings are read and written in UTF-8 format. */
bool Coder::WriteString(const std::string & str)
{
    return m_out->write(str.data(), str.size());
}

void Coder::flush()
{
    m_out->flush();
}

Coder::Coder(RpcInputStream * in, RpcOutputStream * out)
	: m_in(in), m_out(out)
{}

