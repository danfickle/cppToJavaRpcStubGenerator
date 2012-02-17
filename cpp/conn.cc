/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */

#include "conn.h"
#include "types_fwds.h"
#include "java_lang_exception.h"
#include <iostream>

using namespace cppToJavaRpc;

JavaObjectId::JavaObjectId(int64_t id, Connection * conn) : m_id(id), m_conn(conn) {}
JavaObjectId::~JavaObjectId()
{
	// std::cout << "destructing now" << std::endl;

	if (m_id != 0) {
		m_conn->start_method(0, m_id, 0);
		m_conn->end_method_void();
		m_id = 0;
	}
}

int32_t Connection::read_int()
{
	uint32_t sz;
	m_coder->ReadVarint32(&sz);
	return (int32_t) sz;
}

int64_t Connection::read_long()
{
	uint64_t sz;
	m_coder->ReadVarint64(&sz);
	return (int64_t) sz;
}

void Connection::read_success()
{
	m_coder->flush();
	uint32_t sz;
	m_coder->ReadVarint32( &sz );

	if (sz == 0)
	{
		SafeJavaObjectIdPtr o = read_Object();
		throw java::java_lang_Exception(o);
	}
}

void Connection::end_method_void()
{
	read_success();
}

bool Connection::end_method_boolean()
{
	read_success();
	return (read_int() != 0);
}

int8_t Connection::end_method_byte()
{
	read_success();
	return (int8_t) read_int();
}

int16_t Connection::end_method_short()
{
	read_success();
	return (int16_t) read_int();
}

uint16_t Connection::end_method_char()
{	
	read_success();
	return (uint16_t) read_int();
}

int32_t Connection::end_method_int()
{
	read_success();
	return (int32_t) read_int();
}

int64_t Connection::end_method_long()
{
	read_success();
	return (int64_t) read_long();
}

float Connection::end_method_float()
{
	read_success();
	return DecodeFloat(read_int());
}

double Connection::end_method_double()
{
	read_success();
	return DecodeDouble(read_long());
}

std::string Connection::end_method_String()
{
	read_success();
	uint32_t sz = read_int();
	std::string s;
	if (sz != 0)
		m_coder->ReadString(&s, sz);
	return s;
}
#ifdef RPC_USE_QT
SafeJavaObjectIdPtr Connection::read_Object()
{
	int64_t id = read_long();
	std::map<int64_t, WeakJavaObjectIdPtr>::iterator it;
	it = id_to_object.find(id);
	if (it != id_to_object.end())
	{
		SafeJavaObjectIdPtr safe = it->second.toStrongRef();
		if (!safe.isNull())
			return safe;
	}
	SafeJavaObjectIdPtr safe_id(new JavaObjectId(id, this));
	WeakJavaObjectIdPtr weak_id(safe_id);
	id_to_object[id] = weak_id;
	return safe_id;
}
#else
SafeJavaObjectIdPtr Connection::read_Object()
{
	int64_t id = read_long();
	std::map<int64_t, WeakJavaObjectIdPtr>::iterator it;
	it = id_to_object.find(id);
	if (it != id_to_object.end())
	{
		SafeJavaObjectIdPtr safe = it->second.lock();
		if (safe.get() != NULL)
			return safe;
	}
	SafeJavaObjectIdPtr safe_id(new JavaObjectId(id, this));
	WeakJavaObjectIdPtr weak_id(safe_id);
	id_to_object[id] = weak_id;
	return safe_id;
}
#endif
SafeJavaObjectIdPtr Connection::end_method_Object()
{
	read_success();
	return read_Object();
}

std::vector<std::string> Connection::end_method_1D_String_array()
{
	read_success();
	size_t elem_sz = read_int();
	std::vector<std::string> out;
	out.resize(elem_sz);
	for (size_t i = 0; i < elem_sz; i++)
	{
		uint32_t sz = read_int();
		m_coder->ReadString(&out[i], sz);
	}
	return out;
}

std::vector<java::java_object> Connection::end_method_1D_Object_array()
{
	read_success();
	size_t elem_sz = read_int();
	std::vector<java::java_object> out;
	out.resize(elem_sz);
	for (size_t i = 0; i < elem_sz; i++)
	{
		out[i] = read_Object();
	}
	return out;
}

std::vector<bool> Connection::end_method_1D_boolean_array()
{
	read_success();
	size_t elem_sz = read_int();
	std::vector<bool> out;
	out.resize(elem_sz);
	for (size_t i = 0; i < elem_sz; i++)
	{
		out[i] = (read_int() != 0);
	}
	return out;
}

std::vector<int8_t> Connection::end_method_1D_byte_array()
{
	read_success();
	size_t elem_sz = read_int();
	std::vector<int8_t> out;
	out.resize(elem_sz);
	for (size_t i = 0; i < elem_sz; i++)
	{
		out[i] = (int8_t) read_int();
	}
	return out;
}

std::vector<int16_t> Connection::end_method_1D_short_array()
{
	read_success();
	size_t elem_sz = read_int();
	std::vector<int16_t> out;
	out.resize(elem_sz);
	for (size_t i = 0; i < elem_sz; i++)
	{
		out[i] = (int16_t) read_int();
	}
	return out;
}

std::vector<uint16_t> Connection::end_method_1D_char_array()
{
	read_success();
	size_t elem_sz = read_int();
	std::vector<uint16_t> out;
	out.resize(elem_sz);
	for (size_t i = 0; i < elem_sz; i++)
	{
		out[i] = (uint16_t) read_int();
	}
	return out;
}

std::vector<int32_t> Connection::end_method_1D_int_array()
{
	read_success();
	size_t elem_sz = read_int();
	std::vector<int32_t> out;
	out.resize(elem_sz);
	for (size_t i = 0; i < elem_sz; i++)
	{
		out[i] = (int32_t) read_int();
	}
	return out;
}

std::vector<int64_t> Connection::end_method_1D_long_array()
{
	read_success();
	size_t elem_sz = read_int();
	std::vector<int64_t> out;
	out.resize(elem_sz);
	for (size_t i = 0; i < elem_sz; i++)
	{
		out[i] = (int64_t) read_long();
	}
	return out;
}

std::vector<float> Connection::end_method_1D_float_array()
{
	read_success();
	size_t elem_sz = read_int();
	std::vector<float> out;
	out.resize(elem_sz);
	for (size_t i = 0; i < elem_sz; i++)
	{
		out[i] = (float) DecodeFloat(read_int());
	}
	return out;
}

std::vector<double> Connection::end_method_1D_double_array()
{
	read_success();
	size_t elem_sz = read_int();
	std::vector<double> out;
	out.resize(elem_sz);
	for (size_t i = 0; i < elem_sz; i++)
	{
		out[i] = (double) DecodeDouble(read_long());
	}
	return out;
}

void Connection::start_method(int32_t method_number, int64_t id, int32_t type_id)
{
	// std::cout << "Starting method:" << method_number << "\nobject id: " << id << "\ntype id:" << type_id << std::endl << std::endl;
	write_long(id);	
	write_int(method_number);
	write_int(type_id);
}

void Connection::write_1D_boolean_array(const std::vector<bool> & in)
{
	write_int(in.size());
	for (size_t i = 0; i < in.size(); i++)
		write_boolean(in.at(i));
}

void Connection::write_1D_byte_array(const std::vector<int8_t> & in)
{
	write_int(in.size());
	for (size_t i = 0; i < in.size(); i++)
		write_byte(in.at(i));
}

void Connection::write_1D_short_array(const std::vector<int16_t> & in)
{
	write_int(in.size());
	for (size_t i = 0; i < in.size(); i++)
		write_short(in.at(i));
}

void Connection::write_1D_char_array(const std::vector<uint16_t> & in)
{
	write_int(in.size());
	for (size_t i = 0; i < in.size(); i++)
		write_char(in.at(i));
}

void Connection::write_1D_int_array(const std::vector<int32_t> & in)
{
	write_int(in.size());
	for (size_t i = 0; i < in.size(); i++)
		write_int(in.at(i));
}

void Connection::write_1D_long_array(const std::vector<int64_t> & in)
{
	write_int(in.size());
	for (size_t i = 0; i < in.size(); i++)
		write_long(in.at(i));
}

void Connection::write_1D_float_array(const std::vector<float> & in)
{
	write_int(in.size());
	for (size_t i = 0; i < in.size(); i++)
		write_float(in.at(i));
}

void Connection::write_1D_double_array(const std::vector<double> & in)
{
	write_int(in.size());
	for (size_t i = 0; i < in.size(); i++)
		write_double(in.at(i));
}

void Connection::write_1D_Object_array(const std::vector<java::java_object> & in)
{
	write_int(in.size());
	for (size_t i = 0; i < in.size(); i++)
		write_Object(in.at(i).m_o);
}

void Connection::write_1D_String_array(const std::vector<std::string> & in)
{
	write_int(in.size());
	for (size_t i = 0; i < in.size(); i++)
		write_String(in.at(i));
}

void Connection::write_Object(SafeJavaObjectIdPtr o)
{
	write_long(o->m_id);
}

void Connection::write_double(double d)
{
	uint64_t l = EncodeDouble(d);
	write_long(l);
}

void Connection::write_float(float f)
{
	uint32_t l = EncodeFloat(f);
	write_long(l);
}

void Connection::write_String(const std::string & s)
{
	write_long(s.size());
	m_coder->WriteString(s);
}

void Connection::write_boolean(bool b)
{
	write_long(b ? 1 : 0);
}

void Connection::write_byte(int8_t b)
{
	write_long(b);
}

void Connection::write_char(uint16_t c)
{
	write_long(c);
}

void Connection::write_short(int16_t i)
{
	write_long(i);
}

void Connection::write_int(int32_t i)
{
	write_long(i);
}

void Connection::write_long(int64_t l)
{
	m_coder->WriteVarint64(l);
}

Connection::Connection(Coder* coder) : m_coder(coder) {}
