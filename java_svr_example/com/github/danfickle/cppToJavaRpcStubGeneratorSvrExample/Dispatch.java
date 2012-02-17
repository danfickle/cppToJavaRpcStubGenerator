package com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample;
/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
class Dispatch implements com.github.danfickle.cppToJavaRpcSvrLibrary.CppToJavaRpcDispatch{
public void startMethod(int methodNumber, long id, int typeid, com.github.danfickle.cppToJavaRpcSvrLibrary.Connection conn) throws Exception {
	if (id != 0) {
		switch (typeid) {
			case 1: { SvrStub_com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest.startMethod(methodNumber, conn.wire.getObject(id), conn); break; }
			case 4: { SvrStub_java_lang_Object.startMethod(methodNumber, conn.wire.getObject(id), conn); break; }
			case 3: { SvrStub_java_lang_Exception.startMethod(methodNumber, conn.wire.getObject(id), conn); break; }
			case 2: { SvrStub_java_lang_Throwable.startMethod(methodNumber, conn.wire.getObject(id), conn); break; }
			case 5: { SvrStub_java_lang_StringBuilder.startMethod(methodNumber, conn.wire.getObject(id), conn); break; }
			default: { throw new ClassNotFoundException("Type id " + typeid + " not found"); }
		}
	} else {
		switch (typeid) {
			case 1: { SvrStub_com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest.startStaticMethod(methodNumber, conn); break; }
			case 4: { SvrStub_java_lang_Object.startStaticMethod(methodNumber, conn); break; }
			case 3: { SvrStub_java_lang_Exception.startStaticMethod(methodNumber, conn); break; }
			case 2: { SvrStub_java_lang_Throwable.startStaticMethod(methodNumber, conn); break; }
			case 5: { SvrStub_java_lang_StringBuilder.startStaticMethod(methodNumber, conn); break; }
			default: { throw new ClassNotFoundException("Type id " + typeid + " not found"); }
		}
	}
}
}
