/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle. */
#include "java_lang_stringbuilder.h"
#include "conn.h"
#include "types_head.h"

	using namespace java;
	std::string java_lang_StringBuilder::toString() {
		m_o->m_conn->start_method(1, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_String();
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(java_lang_Object & var0) {
		m_o->m_conn->start_method(2, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_Object(var0.m_o);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(const std::string & var0) {
		m_o->m_conn->start_method(3, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_String(var0);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(java_lang_StringBuffer & var0) {
		m_o->m_conn->start_method(4, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_Object(var0.m_o);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(java_lang_CharSequence & var0) {
		m_o->m_conn->start_method(5, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_Object(var0.m_o);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(java_lang_CharSequence & var0, int32_t var1, int32_t var2) {
		m_o->m_conn->start_method(6, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_Object(var0.m_o);
		m_o->m_conn->write_int(var1);
		m_o->m_conn->write_int(var2);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(const std::vector<uint16_t> & var0) {
		m_o->m_conn->start_method(7, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_char_array(var0);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(const std::vector<uint16_t> & var0, int32_t var1, int32_t var2) {
		m_o->m_conn->start_method(8, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_char_array(var0);
		m_o->m_conn->write_int(var1);
		m_o->m_conn->write_int(var2);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(bool var0) {
		m_o->m_conn->start_method(9, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_boolean(var0);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(uint16_t var0) {
		m_o->m_conn->start_method(10, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_char(var0);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(int32_t var0) {
		m_o->m_conn->start_method(11, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(int64_t var0) {
		m_o->m_conn->start_method(12, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_long(var0);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(float var0) {
		m_o->m_conn->start_method(13, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_float(var0);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::append(double var0) {
		m_o->m_conn->start_method(14, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_double(var0);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	int32_t java_lang_StringBuilder::indexOf(const std::string & var0) {
		m_o->m_conn->start_method(15, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_String(var0);
		return m_o->m_conn->end_method_int();
	}

	int32_t java_lang_StringBuilder::indexOf(const std::string & var0, int32_t var1) {
		m_o->m_conn->start_method(16, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_String(var0);
		m_o->m_conn->write_int(var1);
		return m_o->m_conn->end_method_int();
	}

	int32_t java_lang_StringBuilder::lastIndexOf(const std::string & var0) {
		m_o->m_conn->start_method(17, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_String(var0);
		return m_o->m_conn->end_method_int();
	}

	int32_t java_lang_StringBuilder::lastIndexOf(const std::string & var0, int32_t var1) {
		m_o->m_conn->start_method(18, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_String(var0);
		m_o->m_conn->write_int(var1);
		return m_o->m_conn->end_method_int();
	}

	java_lang_StringBuilder java_lang_StringBuilder::replace(int32_t var0, int32_t var1, const std::string & var2) {
		m_o->m_conn->start_method(19, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_int(var1);
		m_o->m_conn->write_String(var2);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::appendCodePoint(int32_t var0) {
		m_o->m_conn->start_method(20, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::delete1(int32_t var0, int32_t var1) {
		m_o->m_conn->start_method(21, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_int(var1);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::deleteCharAt(int32_t var0) {
		m_o->m_conn->start_method(22, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, const std::vector<uint16_t> & var1, int32_t var2, int32_t var3) {
		m_o->m_conn->start_method(23, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_1D_char_array(var1);
		m_o->m_conn->write_int(var2);
		m_o->m_conn->write_int(var3);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, java_lang_Object & var1) {
		m_o->m_conn->start_method(24, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_Object(var1.m_o);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, const std::string & var1) {
		m_o->m_conn->start_method(25, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_String(var1);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, const std::vector<uint16_t> & var1) {
		m_o->m_conn->start_method(26, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_1D_char_array(var1);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, java_lang_CharSequence & var1) {
		m_o->m_conn->start_method(27, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_Object(var1.m_o);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, java_lang_CharSequence & var1, int32_t var2, int32_t var3) {
		m_o->m_conn->start_method(28, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_Object(var1.m_o);
		m_o->m_conn->write_int(var2);
		m_o->m_conn->write_int(var3);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, bool var1) {
		m_o->m_conn->start_method(29, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_boolean(var1);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, uint16_t var1) {
		m_o->m_conn->start_method(30, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_char(var1);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, int32_t var1) {
		m_o->m_conn->start_method(31, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_int(var1);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, int64_t var1) {
		m_o->m_conn->start_method(32, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_long(var1);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, float var1) {
		m_o->m_conn->start_method(33, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_float(var1);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::insert(int32_t var0, double var1) {
		m_o->m_conn->start_method(34, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_int(var0);
		m_o->m_conn->write_double(var1);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	java_lang_StringBuilder java_lang_StringBuilder::reverse() {
		m_o->m_conn->start_method(35, m_o->m_id, JAVA_TYPE_ID);
		return java_lang_StringBuilder(m_o->m_conn->end_method_Object());
	}

	bool java_lang_StringBuilder::instanceOf(cppToJavaRpc::Connection * conn, const java_object & o) {
		conn->start_method(0, 0, JAVA_TYPE_ID);
		conn->write_Object(o.m_o);
		return conn->end_method_boolean();
	}

	java_lang_StringBuilder::java_lang_StringBuilder() {}

	java_lang_StringBuilder::java_lang_StringBuilder(cppToJavaRpc::SafeJavaObjectIdPtr id) { m_o = (id); }

	java_lang_StringBuilder::java_lang_StringBuilder(java_object & o) { m_o = o.m_o; }

	java_lang_StringBuilder::java_lang_StringBuilder(cppToJavaRpc::Connection * conn) {
		conn->start_method(1, 0, JAVA_TYPE_ID);
		m_o = conn->end_method_Object();
	}

	java_lang_StringBuilder::java_lang_StringBuilder(cppToJavaRpc::Connection * conn, int32_t var0) {
		conn->start_method(2, 0, JAVA_TYPE_ID);
		conn->write_int(var0);
		m_o = conn->end_method_Object();
	}

	java_lang_StringBuilder::java_lang_StringBuilder(cppToJavaRpc::Connection * conn, const std::string & var0) {
		conn->start_method(3, 0, JAVA_TYPE_ID);
		conn->write_String(var0);
		m_o = conn->end_method_Object();
	}

	java_lang_StringBuilder::java_lang_StringBuilder(cppToJavaRpc::Connection * conn, java_lang_CharSequence & var0) {
		conn->start_method(4, 0, JAVA_TYPE_ID);
		conn->write_Object(var0.m_o);
		m_o = conn->end_method_Object();
	}

