/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */

#ifndef CPP_TO_JAVA_RPC_CODER_H
#define CPP_TO_JAVA_RPC_CODER_H

#include "iobuffer.h"

namespace cppToJavaRpc {
class Coder
{
public:
	Coder(RpcInputStream * in, RpcOutputStream * out);

	bool ReadVarint32(uint32_t * val);
	bool ReadVarint64(uint64_t * value);
	bool ReadString(std::string* buffer, int size);
	bool WriteVarint64(uint64_t value);
	int VarintSize32(uint32_t value);
	int VarintSize64(uint64_t value);
	bool WriteString(const std::string & buffer);
	void flush();
private:
	RpcInputStream* m_in;
	RpcOutputStream* m_out;
};
};
#endif
