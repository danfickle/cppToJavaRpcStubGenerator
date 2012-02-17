/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
#ifndef JAVA_LANG_STRINGBUILDER
#define JAVA_LANG_STRINGBUILDER
#include "types_fwds.h"
#include "java_lang_object.h"
namespace java {
class java_lang_StringBuilder : public java_lang_Object {
public:
/***** Methods *****/
	std::string toString();
	java_lang_StringBuilder append(java_lang_Object & var0);
	java_lang_StringBuilder append(const std::string & var0);
	java_lang_StringBuilder append(java_lang_StringBuffer & var0);
	java_lang_StringBuilder append(java_lang_CharSequence & var0);
	java_lang_StringBuilder append(java_lang_CharSequence & var0, int32_t var1, int32_t var2);
	java_lang_StringBuilder append(const std::vector<uint16_t> & var0);
	java_lang_StringBuilder append(const std::vector<uint16_t> & var0, int32_t var1, int32_t var2);
	java_lang_StringBuilder append(bool var0);
	java_lang_StringBuilder append(uint16_t var0);
	java_lang_StringBuilder append(int32_t var0);
	java_lang_StringBuilder append(int64_t var0);
	java_lang_StringBuilder append(float var0);
	java_lang_StringBuilder append(double var0);
	int32_t indexOf(const std::string & var0);
	int32_t indexOf(const std::string & var0, int32_t var1);
	int32_t lastIndexOf(const std::string & var0);
	int32_t lastIndexOf(const std::string & var0, int32_t var1);
	java_lang_StringBuilder replace(int32_t var0, int32_t var1, const std::string & var2);
	java_lang_StringBuilder appendCodePoint(int32_t var0);
	java_lang_StringBuilder delete1(int32_t var0, int32_t var1);
	java_lang_StringBuilder deleteCharAt(int32_t var0);
	java_lang_StringBuilder insert(int32_t var0, const std::vector<uint16_t> & var1, int32_t var2, int32_t var3);
	java_lang_StringBuilder insert(int32_t var0, java_lang_Object & var1);
	java_lang_StringBuilder insert(int32_t var0, const std::string & var1);
	java_lang_StringBuilder insert(int32_t var0, const std::vector<uint16_t> & var1);
	java_lang_StringBuilder insert(int32_t var0, java_lang_CharSequence & var1);
	java_lang_StringBuilder insert(int32_t var0, java_lang_CharSequence & var1, int32_t var2, int32_t var3);
	java_lang_StringBuilder insert(int32_t var0, bool var1);
	java_lang_StringBuilder insert(int32_t var0, uint16_t var1);
	java_lang_StringBuilder insert(int32_t var0, int32_t var1);
	java_lang_StringBuilder insert(int32_t var0, int64_t var1);
	java_lang_StringBuilder insert(int32_t var0, float var1);
	java_lang_StringBuilder insert(int32_t var0, double var1);
	java_lang_StringBuilder reverse();
/***** Static Methods *****/
	static bool instanceOf(cppToJavaRpc::Connection * conn, const java_object & o);
/***** Constructors *****/
	explicit java_lang_StringBuilder(cppToJavaRpc::Connection * conn);
	explicit java_lang_StringBuilder(cppToJavaRpc::Connection * conn, int32_t var0);
	explicit java_lang_StringBuilder(cppToJavaRpc::Connection * conn, const std::string & var0);
	explicit java_lang_StringBuilder(cppToJavaRpc::Connection * conn, java_lang_CharSequence & var0);
	explicit java_lang_StringBuilder(cppToJavaRpc::SafeJavaObjectIdPtr id);
	explicit java_lang_StringBuilder();
	explicit java_lang_StringBuilder(java_object & o);
/***** Fields *****/
/***** Static Fields *****/
	static int32_t JAVA_TYPE_ID;
};
}
#endif
