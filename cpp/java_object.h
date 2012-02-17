/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
#ifndef JAVA_OBJECT
#define JAVA_OBJECT
#include "java_rpc_fwds.h"
namespace java {
class java_object {
public:
	cppToJavaRpc::SafeJavaObjectIdPtr m_o;
	inline java_object(cppToJavaRpc::SafeJavaObjectIdPtr o) : m_o(o) {}
	inline java_object() : m_o() {}
};
}
#endif



