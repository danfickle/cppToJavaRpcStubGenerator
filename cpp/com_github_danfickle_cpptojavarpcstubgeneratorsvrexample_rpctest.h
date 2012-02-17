/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
#ifndef COM_GITHUB_DANFICKLE_CPPTOJAVARPCSTUBGENERATORSVREXAMPLE_RPCTEST
#define COM_GITHUB_DANFICKLE_CPPTOJAVARPCSTUBGENERATORSVREXAMPLE_RPCTEST
#include "types_fwds.h"
#include "java_lang_object.h"
namespace java {
class com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest : public java_lang_Object {
public:
/***** Methods *****/
	void stringTest(const std::string & var0, const std::string & var1, const std::string & var2);
	void byteTest(int8_t var0, int8_t var1, int8_t var2);
	void charTest(uint16_t var0, uint16_t var1, uint16_t var2);
	void shortTest(int16_t var0, int16_t var1, int16_t var2);
	void intTest(int32_t var0, int32_t var1, int32_t var2);
	void longTest(int64_t var0, int64_t var1, int64_t var2);
	void floatTest(float var0, float var1, float var2);
	void doubleTest(double var0, double var1, double var2);
	void emptyArrayTest(const std::vector<int8_t> & var0);
	void byteArrayTest(const std::vector<int8_t> & var0);
	void charArrayTest(const std::vector<uint16_t> & var0);
	void shortArrayTest(const std::vector<int16_t> & var0);
	void intArrayTest(const std::vector<int32_t> & var0);
	void longArrayTest(const std::vector<int64_t> & var0);
	void floatArrayTest(const std::vector<float> & var0);
	void doubleArrayTest(const std::vector<double> & var0);
	void objectTest(java_lang_Object & var0, java_lang_Object & var1);
	std::string returnStringTest();
	std::string returnStringNullTest();
	std::string returnStringEmptyTest();
	java_lang_Object returnObjectNullTest();
	java_lang_Object returnObjectTest();
	java_lang_Exception returnExceptionTest();
	java_lang_Exception returnExceptionNullTest();
	int8_t returnByteZeroTest();
	int8_t returnByteMaxTest();
	int8_t returnByteMinTest();
	uint16_t returnCharZeroTest();
	uint16_t returnCharMaxTest();
	uint16_t returnCharMinTest();
	int16_t returnShortZeroTest();
	int16_t returnShortMaxTest();
	int16_t returnShortMinTest();
	int32_t returnIntZeroTest();
	int32_t returnIntMaxTest();
	int32_t returnIntMinTest();
	int64_t returnLongZeroTest();
	int64_t returnLongMaxTest();
	int64_t returnLongMinTest();
	float returnFloatZeroTest();
	float returnFloatMaxTest();
	float returnFloatMinTest();
	double returnDoubleZeroTest();
	double returnDoubleMaxTest();
	double returnDoubleMinTest();
	std::vector<int8_t> returnByteArrayTest();
	std::vector<uint16_t> returnCharArrayTest();
	std::vector<int16_t> returnShortArrayTest();
	std::vector<int32_t> returnIntArrayTest();
	std::vector<int64_t> returnLongArrayTest();
	std::vector<float> returnFloatArrayTest();
	std::vector<double> returnDoubleArrayTest();
	std::vector<java_object> returnObjectArrayTest();
	std::vector<java_object> returnExceptionArrayTest();
	void throwExceptionTest();
	int32_t throwExceptionWithReturnTest();
	void throwExceptionWithArgsTest(int32_t var0, int8_t var1);
/***** Static Methods *****/
	static bool instanceOf(cppToJavaRpc::Connection * conn, const java_object & o);
/***** Constructors *****/
	explicit com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest(cppToJavaRpc::Connection * conn);
	explicit com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest(cppToJavaRpc::SafeJavaObjectIdPtr id);
	explicit com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest();
	explicit com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest(java_object & o);
/***** Fields *****/
/***** Static Fields *****/
	static int32_t JAVA_TYPE_ID;
};
}
#endif
