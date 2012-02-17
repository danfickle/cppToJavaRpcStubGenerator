/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
#ifndef JAVA_LANG_OBJECT
#define JAVA_LANG_OBJECT
#include "types_fwds.h"
namespace java {
class java_lang_Object : public java_object {
public:
/***** Methods *****/
	void wait(int64_t var0);
	void wait(int64_t var0, int32_t var1);
	void wait();
	bool equals(java_lang_Object & var0);
	std::string toString();
	int32_t hashCode();
	java_lang_Class getClass();
	void notify();
	void notifyAll();
/***** Static Methods *****/
	static bool instanceOf(cppToJavaRpc::Connection * conn, const java_object & o);
/***** Constructors *****/
	explicit java_lang_Object(cppToJavaRpc::Connection * conn);
	explicit java_lang_Object(cppToJavaRpc::SafeJavaObjectIdPtr id);
	explicit java_lang_Object();
	explicit java_lang_Object(java_object & o);
/***** Fields *****/
/***** Static Fields *****/
	static int32_t JAVA_TYPE_ID;
};
}
#endif
