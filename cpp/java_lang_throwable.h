/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
#ifndef JAVA_LANG_THROWABLE
#define JAVA_LANG_THROWABLE
#include "types_fwds.h"
#include "java_lang_object.h"
namespace java {
class java_lang_Throwable : public java_lang_Object {
public:
/***** Methods *****/
	void printStackTrace();
	void printStackTrace(java_io_PrintStream & var0);
	void printStackTrace(java_io_PrintWriter & var0);
	java_lang_Throwable fillInStackTrace();
	java_lang_Throwable getCause();
	java_lang_Throwable initCause(java_lang_Throwable & var0);
	std::string toString();
	std::string getMessage();
	std::string getLocalizedMessage();
	std::vector<java_object> getStackTrace();
	void setStackTrace(const std::vector<java_object> & var0);
/***** Static Methods *****/
	static bool instanceOf(cppToJavaRpc::Connection * conn, const java_object & o);
/***** Constructors *****/
	explicit java_lang_Throwable(cppToJavaRpc::Connection * conn);
	explicit java_lang_Throwable(cppToJavaRpc::Connection * conn, const std::string & var0);
	explicit java_lang_Throwable(cppToJavaRpc::Connection * conn, const std::string & var0, java_lang_Throwable & var1);
	explicit java_lang_Throwable(cppToJavaRpc::Connection * conn, java_lang_Throwable & var0);
	explicit java_lang_Throwable(cppToJavaRpc::SafeJavaObjectIdPtr id);
	explicit java_lang_Throwable();
	explicit java_lang_Throwable(java_object & o);
/***** Fields *****/
/***** Static Fields *****/
	static int32_t JAVA_TYPE_ID;
};
}
#endif
