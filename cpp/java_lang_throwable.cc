/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle. */
#include "java_lang_throwable.h"
#include "conn.h"
#include "types_head.h"

	using namespace java;
	void java_lang_Throwable::printStackTrace() {
		m_o->m_conn->start_method(1, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->end_method_void();
	}

	void java_lang_Throwable::printStackTrace(java_io_PrintStream & var0) {
		m_o->m_conn->start_method(2, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_Object(var0.m_o);
		m_o->m_conn->end_method_void();
	}

	void java_lang_Throwable::printStackTrace(java_io_PrintWriter & var0) {
		m_o->m_conn->start_method(3, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_Object(var0.m_o);
		m_o->m_conn->end_method_void();
	}

	java_lang_Throwable java_lang_Throwable::fillInStackTrace() {
		m_o->m_conn->start_method(4, m_o->m_id, JAVA_TYPE_ID);
		return java_lang_Throwable(m_o->m_conn->end_method_Object());
	}

	java_lang_Throwable java_lang_Throwable::getCause() {
		m_o->m_conn->start_method(5, m_o->m_id, JAVA_TYPE_ID);
		return java_lang_Throwable(m_o->m_conn->end_method_Object());
	}

	java_lang_Throwable java_lang_Throwable::initCause(java_lang_Throwable & var0) {
		m_o->m_conn->start_method(6, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_Object(var0.m_o);
		return java_lang_Throwable(m_o->m_conn->end_method_Object());
	}

	std::string java_lang_Throwable::toString() {
		m_o->m_conn->start_method(7, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_String();
	}

	std::string java_lang_Throwable::getMessage() {
		m_o->m_conn->start_method(8, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_String();
	}

	std::string java_lang_Throwable::getLocalizedMessage() {
		m_o->m_conn->start_method(9, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_String();
	}

	std::vector<java_object> java_lang_Throwable::getStackTrace() {
		m_o->m_conn->start_method(10, m_o->m_id, JAVA_TYPE_ID);
		return m_o->m_conn->end_method_1D_Object_array();
	}

	void java_lang_Throwable::setStackTrace(const std::vector<java_object> & var0) {
		m_o->m_conn->start_method(11, m_o->m_id, JAVA_TYPE_ID);
		m_o->m_conn->write_1D_Object_array(var0);
		m_o->m_conn->end_method_void();
	}

	bool java_lang_Throwable::instanceOf(cppToJavaRpc::Connection * conn, const java_object & o) {
		conn->start_method(0, 0, JAVA_TYPE_ID);
		conn->write_Object(o.m_o);
		return conn->end_method_boolean();
	}

	java_lang_Throwable::java_lang_Throwable() {}

	java_lang_Throwable::java_lang_Throwable(cppToJavaRpc::SafeJavaObjectIdPtr id) { m_o = (id); }

	java_lang_Throwable::java_lang_Throwable(java_object & o) { m_o = o.m_o; }

	java_lang_Throwable::java_lang_Throwable(cppToJavaRpc::Connection * conn) {
		conn->start_method(1, 0, JAVA_TYPE_ID);
		m_o = conn->end_method_Object();
	}

	java_lang_Throwable::java_lang_Throwable(cppToJavaRpc::Connection * conn, const std::string & var0) {
		conn->start_method(2, 0, JAVA_TYPE_ID);
		conn->write_String(var0);
		m_o = conn->end_method_Object();
	}

	java_lang_Throwable::java_lang_Throwable(cppToJavaRpc::Connection * conn, const std::string & var0, java_lang_Throwable & var1) {
		conn->start_method(3, 0, JAVA_TYPE_ID);
		conn->write_String(var0);
		conn->write_Object(var1.m_o);
		m_o = conn->end_method_Object();
	}

	java_lang_Throwable::java_lang_Throwable(cppToJavaRpc::Connection * conn, java_lang_Throwable & var0) {
		conn->start_method(4, 0, JAVA_TYPE_ID);
		conn->write_Object(var0.m_o);
		m_o = conn->end_method_Object();
	}

