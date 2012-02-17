/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */

#ifndef CPP_TO_JAVA_RPC_CONN_H
#define CPP_TO_JAVA_RPC_CONN_H
#include <map>
#include <stdint.h>
#include "java_object.h"
#include "iobuffer.h"
#include "coder.h"

namespace cppToJavaRpc {

class Connection;

class JavaObjectId
{
public:
	int64_t m_id;
	Connection * m_conn;
	explicit JavaObjectId(int64_t id, Connection * conn);
	~JavaObjectId();
};

class Connection
{
private:
	inline uint32_t EncodeFloat(float value) {
	  union {float f; uint32_t i;};
  	  f = value;
	  return i;
	}

	inline float DecodeFloat(uint32_t value) {
	  union {float f; uint32_t i;};
	  i = value;
	  return f;
	}

	inline uint64_t EncodeDouble(double value) {
	  union {double f; uint64_t i;};
	  f = value;
	  return i;
	}

	inline double DecodeDouble(uint64_t value) {
	  union {double f; uint64_t i;};
	  i = value;
	  return f;
	}

	int32_t read_int();
	int64_t read_long();
	void read_success();

public:
	void end_method_void();
	bool end_method_boolean();
	int8_t end_method_byte();
	int16_t end_method_short();
	uint16_t end_method_char();
	int32_t end_method_int();
	int64_t end_method_long();
	float end_method_float();
	double end_method_double();
	std::string end_method_String();
	SafeJavaObjectIdPtr end_method_Object();
	std::vector<bool> end_method_1D_boolean_array();
	std::vector<int8_t> end_method_1D_byte_array();
	std::vector<int16_t> end_method_1D_short_array();
	std::vector<uint16_t> end_method_1D_char_array();
	std::vector<int32_t> end_method_1D_int_array();
	std::vector<int64_t> end_method_1D_long_array();
	std::vector<float> end_method_1D_float_array();
	std::vector<double> end_method_1D_double_array();
	std::vector<std::string> end_method_1D_String_array();
	std::vector<java::java_object> end_method_1D_Object_array();
	void start_method(int method_number, int64_t id, int type_id);
	void write_1D_boolean_array(const std::vector<bool> & in);
	void write_1D_byte_array(const std::vector<int8_t> & in);
	void write_1D_short_array(const std::vector<int16_t> & in);
	void write_1D_char_array(const std::vector<uint16_t> & in);
	void write_1D_int_array(const std::vector<int32_t> & in);
	void write_1D_long_array(const std::vector<int64_t> & in);
	void write_1D_float_array(const std::vector<float> & in);
	void write_1D_double_array(const std::vector<double> & in);
	void write_1D_Object_array(const std::vector<java::java_object> & in);
	void write_1D_String_array(const std::vector<std::string> & in);
	void write_Object(SafeJavaObjectIdPtr obj);
	void write_double(double d);
	void write_float(float f);
	void write_String(const std::string & s);
	void write_boolean(bool b);
	void write_byte(int8_t b);
	void write_char(uint16_t c);
	void write_short(int16_t i);
	void write_int(int32_t i);
	void write_long(int64_t l);
	Connection(Coder* coder);
	inline bool isObjectNull(java::java_object & o) { return o.m_o->m_id == -1; }
private:
	SafeJavaObjectIdPtr read_Object();
	Coder * m_coder;
	std::map<int64_t, WeakJavaObjectIdPtr> id_to_object;
};


}
#endif
