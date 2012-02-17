/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle. */
#include "java_lang_object.h"
#include "conn.h"
#include "types_head.h"

	using namespace java;
	void java_lang_Object::wait(int64_t var0) {
		m_o->m_conn->start_method(1, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_long(var0);
		m_o->m_conn->end_method_void();
	}

	void java_lang_Object::wait(int64_t var0, int32_t var1) {
		m_o->m_conn->start_method(2, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_long(var0);
		m_o->m_conn->write_int(var1);
		m_o->m_conn->end_method_void();
	}

	void java_lang_Object::wait() {
		m_o->m_conn->start_method(3, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->end_method_void();
	}

	bool java_lang_Object::equals(java_lang_Object & var0) {
		m_o->m_conn->start_method(4, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_Object(var0.m_o);
		return m_o->m_conn->end_method_boolean();
	}

	std::string java_lang_Object::toString() {
		m_o->m_conn->start_method(5, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_String();
	}

	int32_t java_lang_Object::hashCode() {
		m_o->m_conn->start_method(6, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_int();
	}

	java_lang_Class java_lang_Object::getClass() {
		m_o->m_conn->start_method(7, m_o->m_id, JAVA_TYPE_ID);
		return java_lang_Class(m_o->m_conn->end_method_Object());
	}

	void java_lang_Object::notify() {
		m_o->m_conn->start_method(8, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->end_method_void();
	}

	void java_lang_Object::notifyAll() {
		m_o->m_conn->start_method(9, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->end_method_void();
	}

	bool java_lang_Object::instanceOf(cppToJavaRpc::Connection * conn, const java_object & o) {
		conn->start_method(0, 0, JAVA_TYPE_ID);
		conn->write_Object(o.m_o);
		return conn->end_method_boolean();
	}

	java_lang_Object::java_lang_Object() {}

	java_lang_Object::java_lang_Object(cppToJavaRpc::SafeJavaObjectIdPtr id) { m_o = (id); }

	java_lang_Object::java_lang_Object(java_object & o) { m_o = o.m_o; }

	java_lang_Object::java_lang_Object(cppToJavaRpc::Connection * conn) {
		conn->start_method(1, 0, JAVA_TYPE_ID);
		m_o = conn->end_method_Object();
	}

