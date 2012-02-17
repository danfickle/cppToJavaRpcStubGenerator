/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
#ifndef JAVA_LANG_EXCEPTION
#define JAVA_LANG_EXCEPTION
#include "types_fwds.h"
#include "java_lang_throwable.h"
namespace java {
class java_lang_Exception : public java_lang_Throwable {
public:
/***** Methods *****/
/***** Static Methods *****/
	static bool instanceOf(cppToJavaRpc::Connection * conn, const java_object & o);
/***** Constructors *****/
	explicit java_lang_Exception(cppToJavaRpc::Connection * conn);
	explicit java_lang_Exception(cppToJavaRpc::Connection * conn, const std::string & var0);
	explicit java_lang_Exception(cppToJavaRpc::Connection * conn, const std::string & var0, java_lang_Throwable & var1);
	explicit java_lang_Exception(cppToJavaRpc::Connection * conn, java_lang_Throwable & var0);
	explicit java_lang_Exception(cppToJavaRpc::SafeJavaObjectIdPtr id);
	explicit java_lang_Exception();
	explicit java_lang_Exception(java_object & o);
/***** Fields *****/
/***** Static Fields *****/
	static int32_t JAVA_TYPE_ID;
};
}
#endif
