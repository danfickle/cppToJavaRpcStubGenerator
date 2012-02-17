/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
#include "conn.h"
#include "types_head.h"
#include <iostream>
#include <cfloat>
#include <cassert>
#ifndef INT8_MIN
#define INT8_MIN    (-128)
#define INT16_MIN   (-32767-1)
#define INT32_MIN   (-2147483647-1)
#define INT8_MAX    (127)
#define INT16_MAX   (32767)
#define INT32_MAX   (2147483647)
#define UINT8_MAX   (255U)
#define UINT16_MAX  (65535U)
#define UINT32_MAX  (4294967295U)
#define INT64_MAX   (0x7fffffffffffffffLL)
#define INT64_MIN   (-INT64_MAX - 1LL)
#endif

using namespace cppToJavaRpc;

void testcppToJavaRpcStubGenerator(Connection & conn);
void sample(Connection &conn);

int main(int argc, char * argv[])
{
	RpcSocketService service;
	RpcSocketPtr sock = service.connect("127.0.0.1", 14000);
	if (sock == NULL)
	{
		std::cout << "Failed to make connection." << std::endl;
		return -1;
	}
	RpcInputStream in(sock);
	RpcOutputStream out(sock);
	Coder coder(&in, &out);
	Connection conn(&coder);

	sample(conn);
	testcppToJavaRpcStubGenerator(conn);

	return 0;
}

void sample(Connection & conn)
{
    java::java_lang_StringBuilder o(&conn);

    o.append(std::string("Hello World!\n"));
    o.append(256);
    o.append(1.0345f);
    o.append(203456.678);
    o.append(-1000);
    o.append(0);

    std::vector<uint16_t> chars;
    chars.push_back('g');
    chars.push_back('i');
    chars.push_back('t');

    o.append(chars, 1, 2);

    try
    {
        o.append(chars, 5, 3);
    }
    catch(java::java_lang_Exception& e)
    {
        e.printStackTrace();
        if (java::java_lang_Throwable::instanceOf(&conn, e))
        {
            java::java_lang_Throwable throwable(e);
            std::cout << throwable.getMessage() << std::endl;
        }
    }

    std::cout << o.toString() << std::endl;
    std::cout << o.reverse().toString() << std::endl;
}

void testcppToJavaRpcStubGenerator(Connection & conn)
{
    java::com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest rpcTest(&conn);

    rpcTest.stringTest(std::string("test"), std::string(""), std::string(""));
    rpcTest.byteTest(0, INT8_MAX, INT8_MIN);
    rpcTest.charTest(0, UINT16_MAX, 0);
    rpcTest.shortTest(0, INT16_MAX, INT16_MIN);
    rpcTest.intTest(0, INT32_MAX, INT32_MIN);
    rpcTest.longTest(0, INT64_MAX, INT64_MIN);
    rpcTest.floatTest(0, FLT_MAX, -1);
    rpcTest.doubleTest(0, DBL_MAX, -1.0);
    rpcTest.emptyArrayTest(std::vector<int8_t>());

    std::vector<int8_t> a;
    a.push_back(0);
    a.push_back(INT8_MAX);
    a.push_back(INT8_MIN);
    rpcTest.byteArrayTest(a);

    std::vector<uint16_t> b;
    b.push_back(0);
    b.push_back(UINT16_MAX);
    b.push_back(0);
    rpcTest.charArrayTest(b);

    std::vector<int16_t> c;
    c.push_back(0);
    c.push_back(INT16_MAX);
    c.push_back(INT16_MIN);
    rpcTest.shortArrayTest(c);

    std::vector<int32_t> d;
    d.push_back(0);
    d.push_back(INT32_MAX);
    d.push_back(INT32_MIN);
    rpcTest.intArrayTest(d);

    std::vector<int64_t> e;
    e.push_back(0);
    e.push_back(INT64_MAX);
    e.push_back(INT64_MIN);
    rpcTest.longArrayTest(e);

    std::vector<float> f;
    f.push_back(0);
    f.push_back(FLT_MAX);
    f.push_back(-1);
    rpcTest.floatArrayTest(f);

    std::vector<double> g;
    g.push_back(0);
    g.push_back(DBL_MAX);
    g.push_back(-1.0);
    rpcTest.doubleArrayTest(g);

    assert(rpcTest.returnStringEmptyTest().empty());
    assert(rpcTest.returnStringNullTest().empty());
    assert(rpcTest.returnStringTest() == std::string("test"));
    assert(rpcTest.returnByteZeroTest() == 0);
    assert(rpcTest.returnByteMaxTest() == INT8_MAX);
    assert(rpcTest.returnByteMinTest() == INT8_MIN);
    assert(rpcTest.returnCharZeroTest() == 0);
    assert(rpcTest.returnCharMaxTest() == UINT16_MAX);
    assert(rpcTest.returnCharMinTest() == 0);
    assert(rpcTest.returnShortZeroTest() == 0);
    assert(rpcTest.returnShortMaxTest() == INT16_MAX);
    assert(rpcTest.returnShortMinTest() == INT16_MIN);
    assert(rpcTest.returnIntZeroTest() == 0);
    assert(rpcTest.returnIntMaxTest() == INT32_MAX);
    assert(rpcTest.returnIntMinTest() == INT32_MIN);
    assert(rpcTest.returnLongZeroTest() == 0);
    assert(rpcTest.returnLongMaxTest() == INT64_MAX);
    assert(rpcTest.returnLongMinTest() == INT64_MIN);
    assert(rpcTest.returnFloatZeroTest() == 0);
    assert(rpcTest.returnFloatMaxTest() == FLT_MAX);
    assert(rpcTest.returnFloatMinTest() == -1);
    assert(rpcTest.returnDoubleZeroTest() == 0);
    assert(rpcTest.returnDoubleMaxTest() == DBL_MAX);
    assert(rpcTest.returnDoubleMinTest() == -1.0);

    std::vector<int8_t> h = rpcTest.returnByteArrayTest();
    assert(h.size() == 3);
    assert(h.at(0) == 0);
    assert(h.at(1) == INT8_MAX);
    assert(h.at(2) == INT8_MIN);

    std::vector<uint16_t> i = rpcTest.returnCharArrayTest();
    assert(i.size() == 3);
    assert(i.at(0) == 0);
    assert(i.at(1) == UINT16_MAX);
    assert(i.at(2) == 0);

    std::vector<int16_t> j = rpcTest.returnShortArrayTest();
    assert(j.size() == 3);
    assert(j.at(0) == 0);
    assert(j.at(1) == INT16_MAX);
    assert(j.at(2) == INT16_MIN);

    std::vector<int32_t> k = rpcTest.returnIntArrayTest();
    assert(k.size() == 3);
    assert(k.at(0) == 0);
    assert(k.at(1) == INT32_MAX);
    assert(k.at(2) == INT32_MIN);

    std::vector<int64_t> l = rpcTest.returnLongArrayTest();
    assert(l.size() == 3);
    assert(l.at(0) == 0);
    assert(l.at(1) == INT64_MAX);
    assert(l.at(2) == INT64_MIN);

    std::vector<float> m = rpcTest.returnFloatArrayTest();
    assert(m.size() == 3);
    assert(m.at(0) == 0);
    assert(m.at(1) == FLT_MAX);
    assert(m.at(2) == -1);

    std::vector<double> n = rpcTest.returnDoubleArrayTest();
    assert(n.size() == 3);
    assert(n.at(0) == 0);
    assert(n.at(1) == DBL_MAX);
    assert(n.at(2) == -1.0);

    java::java_lang_Object o(&conn);
    java::java_lang_Object p(&conn);
    rpcTest.objectTest(o, p);

    java::java_lang_Object q = rpcTest.returnObjectTest();
    assert(java::java_lang_Exception::instanceOf(&conn, q));
    assert(!conn.isObjectNull(q));

    java::java_lang_Exception r = rpcTest.returnExceptionTest();
    assert(r.getMessage() == std::string("test"));

    try{
        rpcTest.throwExceptionTest();
        assert(false);
    }catch (java::java_lang_Exception & e1) { }

    try {
        rpcTest.throwExceptionWithArgsTest(100, 100);
        assert(false);
    } catch (java::java_lang_Exception & e1) { }

    try {
        rpcTest.throwExceptionWithReturnTest();
        assert(false);
    } catch (java::java_lang_Exception & e1) { }


    java::java_lang_Object v = rpcTest.returnObjectNullTest();
    assert(conn.isObjectNull(v));
    try
    {
        v.toString();
        assert(false);
    }catch (java::java_lang_Exception & e1) { e1.printStackTrace(); }

    std::vector<java::java_object> s = rpcTest.returnObjectArrayTest();
    assert(s.size() == 3);
    assert(conn.isObjectNull(s.at(0)));
    assert(java::java_lang_Exception::instanceOf(&conn, s.at(1)));
    assert(java::java_lang_Object::instanceOf(&conn, s.at(2)));

    std::vector<java::java_object> t = rpcTest.returnExceptionArrayTest();
    assert(t.size() == 2);
    assert(conn.isObjectNull(t.at(0)));
    assert(java::java_lang_Exception::instanceOf(&conn, s.at(1)));

    java::java_lang_Exception u(s.at(1));
    assert(u.getMessage() == std::string("test"));
}

