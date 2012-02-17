/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle. */
#include "com_github_danfickle_cpptojavarpcstubgeneratorsvrexample_rpctest.h"
#include "conn.h"
#include "types_head.h"

	using namespace java;
	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::stringTest(const std::string & var0, const std::string & var1, const std::string & var2) {
		m_o->m_conn->start_method(1, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_String(var0);
		m_o->m_conn->write_String(var1);
		m_o->m_conn->write_String(var2);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::byteTest(int8_t var0, int8_t var1, int8_t var2) {
		m_o->m_conn->start_method(2, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_byte(var0);
		m_o->m_conn->write_byte(var1);
		m_o->m_conn->write_byte(var2);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::charTest(uint16_t var0, uint16_t var1, uint16_t var2) {
		m_o->m_conn->start_method(3, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_char(var0);
		m_o->m_conn->write_char(var1);
		m_o->m_conn->write_char(var2);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::shortTest(int16_t var0, int16_t var1, int16_t var2) {
		m_o->m_conn->start_method(4, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_short(var0);
		m_o->m_conn->write_short(var1);
		m_o->m_conn->write_short(var2);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::intTest(int32_t var0, int32_t var1, int32_t var2) {
		m_o->m_conn->start_method(5, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_int(var1);
		m_o->m_conn->write_int(var2);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::longTest(int64_t var0, int64_t var1, int64_t var2) {
		m_o->m_conn->start_method(6, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_long(var0);
		m_o->m_conn->write_long(var1);
		m_o->m_conn->write_long(var2);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::floatTest(float var0, float var1, float var2) {
		m_o->m_conn->start_method(7, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_float(var0);
		m_o->m_conn->write_float(var1);
		m_o->m_conn->write_float(var2);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::doubleTest(double var0, double var1, double var2) {
		m_o->m_conn->start_method(8, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_double(var0);
		m_o->m_conn->write_double(var1);
		m_o->m_conn->write_double(var2);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::emptyArrayTest(const std::vector<int8_t> & var0) {
		m_o->m_conn->start_method(9, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_byte_array(var0);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::byteArrayTest(const std::vector<int8_t> & var0) {
		m_o->m_conn->start_method(10, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_byte_array(var0);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::charArrayTest(const std::vector<uint16_t> & var0) {
		m_o->m_conn->start_method(11, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_char_array(var0);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::shortArrayTest(const std::vector<int16_t> & var0) {
		m_o->m_conn->start_method(12, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_short_array(var0);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::intArrayTest(const std::vector<int32_t> & var0) {
		m_o->m_conn->start_method(13, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_int_array(var0);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::longArrayTest(const std::vector<int64_t> & var0) {
		m_o->m_conn->start_method(14, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_long_array(var0);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::floatArrayTest(const std::vector<float> & var0) {
		m_o->m_conn->start_method(15, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_float_array(var0);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::doubleArrayTest(const std::vector<double> & var0) {
		m_o->m_conn->start_method(16, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_double_array(var0);
		m_o->m_conn->end_method_void();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::objectTest(java_lang_Object & var0, java_lang_Object & var1) {
		m_o->m_conn->start_method(17, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_Object(var0.m_o);
		m_o->m_conn->write_Object(var1.m_o);
		m_o->m_conn->end_method_void();
	}

	std::string com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnStringTest() {
		m_o->m_conn->start_method(18, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_String();
	}

	std::string com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnStringNullTest() {
		m_o->m_conn->start_method(19, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_String();
	}

	std::string com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnStringEmptyTest() {
		m_o->m_conn->start_method(20, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_String();
	}

	java_lang_Object com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnObjectNullTest() {
		m_o->m_conn->start_method(21, m_o->m_id, JAVA_TYPE_ID);
		return java_lang_Object(m_o->m_conn->end_method_Object());
	}

	java_lang_Object com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnObjectTest() {
		m_o->m_conn->start_method(22, m_o->m_id, JAVA_TYPE_ID);
		return java_lang_Object(m_o->m_conn->end_method_Object());
	}

	java_lang_Exception com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnExceptionTest() {
		m_o->m_conn->start_method(23, m_o->m_id, JAVA_TYPE_ID);
		return java_lang_Exception(m_o->m_conn->end_method_Object());
	}

	java_lang_Exception com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnExceptionNullTest() {
		m_o->m_conn->start_method(24, m_o->m_id, JAVA_TYPE_ID);
		return java_lang_Exception(m_o->m_conn->end_method_Object());
	}

	int8_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnByteZeroTest() {
		m_o->m_conn->start_method(25, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_byte();
	}

	int8_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnByteMaxTest() {
		m_o->m_conn->start_method(26, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_byte();
	}

	int8_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnByteMinTest() {
		m_o->m_conn->start_method(27, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_byte();
	}

	uint16_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnCharZeroTest() {
		m_o->m_conn->start_method(28, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_char();
	}

	uint16_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnCharMaxTest() {
		m_o->m_conn->start_method(29, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_char();
	}

	uint16_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnCharMinTest() {
		m_o->m_conn->start_method(30, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_char();
	}

	int16_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnShortZeroTest() {
		m_o->m_conn->start_method(31, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_short();
	}

	int16_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnShortMaxTest() {
		m_o->m_conn->start_method(32, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_short();
	}

	int16_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnShortMinTest() {
		m_o->m_conn->start_method(33, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_short();
	}

	int32_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnIntZeroTest() {
		m_o->m_conn->start_method(34, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_int();
	}

	int32_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnIntMaxTest() {
		m_o->m_conn->start_method(35, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_int();
	}

	int32_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnIntMinTest() {
		m_o->m_conn->start_method(36, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_int();
	}

	int64_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnLongZeroTest() {
		m_o->m_conn->start_method(37, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_long();
	}

	int64_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnLongMaxTest() {
		m_o->m_conn->start_method(38, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_long();
	}

	int64_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnLongMinTest() {
		m_o->m_conn->start_method(39, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_long();
	}

	float com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnFloatZeroTest() {
		m_o->m_conn->start_method(40, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_float();
	}

	float com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnFloatMaxTest() {
		m_o->m_conn->start_method(41, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_float();
	}

	float com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnFloatMinTest() {
		m_o->m_conn->start_method(42, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_float();
	}

	double com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnDoubleZeroTest() {
		m_o->m_conn->start_method(43, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_double();
	}

	double com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnDoubleMaxTest() {
		m_o->m_conn->start_method(44, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_double();
	}

	double com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnDoubleMinTest() {
		m_o->m_conn->start_method(45, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_double();
	}

	std::vector<int8_t> com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnByteArrayTest() {
		m_o->m_conn->start_method(46, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_1D_byte_array();
	}

	std::vector<uint16_t> com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnCharArrayTest() {
		m_o->m_conn->start_method(47, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_1D_char_array();
	}

	std::vector<int16_t> com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnShortArrayTest() {
		m_o->m_conn->start_method(48, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_1D_short_array();
	}

	std::vector<int32_t> com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnIntArrayTest() {
		m_o->m_conn->start_method(49, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_1D_int_array();
	}

	std::vector<int64_t> com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnLongArrayTest() {
		m_o->m_conn->start_method(50, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_1D_long_array();
	}

	std::vector<float> com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnFloatArrayTest() {
		m_o->m_conn->start_method(51, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_1D_float_array();
	}

	std::vector<double> com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnDoubleArrayTest() {
		m_o->m_conn->start_method(52, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_1D_double_array();
	}

	std::vector<java_object> com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnObjectArrayTest() {
		m_o->m_conn->start_method(53, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_1D_Object_array();
	}

	std::vector<java_object> com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::returnExceptionArrayTest() {
		m_o->m_conn->start_method(54, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_1D_Object_array();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::throwExceptionTest() {
		m_o->m_conn->start_method(55, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->end_method_void();
	}

	int32_t com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::throwExceptionWithReturnTest() {
		m_o->m_conn->start_method(56, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_int();
	}

	void com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::throwExceptionWithArgsTest(int32_t var0, int8_t var1) {
		m_o->m_conn->start_method(57, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_byte(var1);
		m_o->m_conn->end_method_void();
	}

	bool com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::instanceOf(cppToJavaRpc::Connection * conn, const java_object & o) {
		conn->start_method(0, 0, JAVA_TYPE_ID);
		conn->write_Object(o.m_o);
		return conn->end_method_boolean();
	}

	com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest() {}

	com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest(cppToJavaRpc::SafeJavaObjectIdPtr id) { m_o = (id); }

	com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest(java_object & o) { m_o = o.m_o; }

	com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest::com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest(cppToJavaRpc::Connection * conn) {
		conn->start_method(1, 0, JAVA_TYPE_ID);
		m_o = conn->end_method_Object();
	}

