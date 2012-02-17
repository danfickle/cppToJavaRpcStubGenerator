package com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample;
/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
public class SvrStub_java_lang_Object {
static public void startMethod(int methodNumber, Object o, com.github.danfickle.cppToJavaRpcSvrLibrary.Connection conn) throws Exception {
	java.lang.Object internal = (java.lang.Object) o;
	switch (methodNumber) {
		case 1: { /* public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException */
			long var0 = conn.wire.readlong();
			internal.wait(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 2: { /* public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException */
			long var0 = conn.wire.readlong();
			int var1 = conn.wire.readint();
			internal.wait(var0, var1);
			conn.wire.writeSuccess();
			break;
		}

		case 3: { /* public final void java.lang.Object.wait() throws java.lang.InterruptedException */
			internal.wait();
			conn.wire.writeSuccess();
			break;
		}

		case 4: { /* public boolean java.lang.Object.equals(java.lang.Object) */
			java.lang.Object var0 = (java.lang.Object) conn.wire.readObject();
			boolean ret = internal.equals(var0);
			conn.wire.writeSuccess();
			conn.wire.writeboolean(ret);
			break;
		}

		case 5: { /* public java.lang.String java.lang.Object.toString() */
			java.lang.String ret = internal.toString();
			conn.wire.writeSuccess();
			conn.wire.writeString(ret);
			break;
		}

		case 6: { /* public native int java.lang.Object.hashCode() */
			int ret = internal.hashCode();
			conn.wire.writeSuccess();
			conn.wire.writeint(ret);
			break;
		}

		case 7: { /* public final native java.lang.Class<?> java.lang.Object.getClass() */
			java.lang.Class ret = internal.getClass();
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 8: { /* public final native void java.lang.Object.notify() */
			internal.notify();
			conn.wire.writeSuccess();
			break;
		}

		case 9: { /* public final native void java.lang.Object.notifyAll() */
			internal.notifyAll();
			conn.wire.writeSuccess();
			break;
		}

		default: {
			throw new NoSuchMethodException("Method " + methodNumber + " does not exist");
		}
	}
}

static public void startStaticMethod(int methodNumber, com.github.danfickle.cppToJavaRpcSvrLibrary.Connection conn) throws Exception {
	switch (methodNumber) {
		case 0: { /* instanceOf */
			java.lang.Object var0 = (java.lang.Object) conn.wire.readObject();
			boolean ret = (var0 instanceof java.lang.Object);
			conn.wire.writeSuccess();
			conn.wire.writeboolean(ret);
			break;
		}

		case 1: { /* ctor: public java.lang.Object() */
			java.lang.Object internal = new java.lang.Object();
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
