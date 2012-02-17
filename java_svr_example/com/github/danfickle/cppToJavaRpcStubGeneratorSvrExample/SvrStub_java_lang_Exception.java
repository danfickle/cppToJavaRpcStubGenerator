package com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample;
/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
public class SvrStub_java_lang_Exception {
static public void startMethod(int methodNumber, Object o, com.github.danfickle.cppToJavaRpcSvrLibrary.Connection conn) throws Exception {
	java.lang.Exception internal = (java.lang.Exception) o;
	switch (methodNumber) {
		default: {
			throw new NoSuchMethodException("Method " + methodNumber + " does not exist");
		}
	}
}

static public void startStaticMethod(int methodNumber, com.github.danfickle.cppToJavaRpcSvrLibrary.Connection conn) throws Exception {
	switch (methodNumber) {
		case 0: { /* instanceOf */
			java.lang.Object var0 = (java.lang.Object) conn.wire.readObject();
			boolean ret = (var0 instanceof java.lang.Exception);
			conn.wire.writeSuccess();
			conn.wire.writeboolean(ret);
			break;
		}

		case 1: { /* ctor: public java.lang.Exception() */
			java.lang.Exception internal = new java.lang.Exception();
			conn.wire.writeSuccess();
			conn.wire.writeObject(internal);
			break;
		}

		case 2: { /* ctor: public java.lang.Exception(java.lang.String) */
			String var0 = conn.wire.readString();
			java.lang.Exception internal = new java.lang.Exception(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(internal);
			break;
		}

		case 3: { /* ctor: public java.lang.Exception(java.lang.String,java.lang.Throwable) */
			String var0 = conn.wire.readString();
			java.lang.Throwable var1 = (java.lang.Throwable) conn.wire.readObject();
			java.lang.Exception internal = new java.lang.Exception(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(internal);
			break;
		}

		case 4: { /* ctor: public java.lang.Exception(java.lang.Throwable) */
			java.lang.Throwable var0 = (java.lang.Throwable) conn.wire.readObject();
			java.lang.Exception internal = new java.lang.Exception(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(internal);
			break;
		}

		default: {
			throw new NoSuchMethodException("Static method " + methodNumber + " does not exist");
		}
	}
}
}
