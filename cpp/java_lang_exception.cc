/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle. */
#include "java_lang_exception.h"
#include "conn.h"
#include "types_head.h"

	using namespace java;
	bool java_lang_Exception::instanceOf(cppToJavaRpc::Connection * conn, const java_object & o) {
		conn->start_method(0, 0, JAVA_TYPE_ID);
		conn->write_Object(o.m_o);
		return conn->end_method_boolean();
	}

	java_lang_Exception::java_lang_Exception() {}

	java_lang_Exception::java_lang_Exception(cppToJavaRpc::SafeJavaObjectIdPtr id) { m_o = (id); }

	java_lang_Exception::java_lang_Exception(java_object & o) { m_o = o.m_o; }

	java_lang_Exception::java_lang_Exception(cppToJavaRpc::Connection * conn) {
		conn->start_method(1, 0, JAVA_TYPE_ID);
		m_o = conn->end_method_Object();
	}

	java_lang_Exception::java_lang_Exception(cppToJavaRpc::Connection * conn, const std::string & var0) {
		conn->start_method(2, 0, JAVA_TYPE_ID);
		conn->write_String(var0);
		m_o = conn->end_method_Object();
	}

	java_lang_Exception::java_lang_Exception(cppToJavaRpc::Connection * conn, const std::string & var0, java_lang_Throwable & var1) {
		conn->start_method(3, 0, JAVA_TYPE_ID);
		conn->write_String(var0);
		conn->write_Object(var1.m_o);
		m_o = conn->end_method_Object();
	}

	java_lang_Exception::java_lang_Exception(cppToJavaRpc::Connection * conn, java_lang_Throwable & var0) {
		conn->start_method(4, 0, JAVA_TYPE_ID);
		conn->write_Object(var0.m_o);
		m_o = conn->end_method_Object();
	}

