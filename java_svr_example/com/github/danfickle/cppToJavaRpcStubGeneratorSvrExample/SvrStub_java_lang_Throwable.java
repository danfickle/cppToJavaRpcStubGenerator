package com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample;
/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
public class SvrStub_java_lang_Throwable {
static public void startMethod(int methodNumber, Object o, com.github.danfickle.cppToJavaRpcSvrLibrary.Connection conn) throws Exception {
	java.lang.Throwable internal = (java.lang.Throwable) o;
	switch (methodNumber) {
		case 1: { /* public void java.lang.Throwable.printStackTrace() */
			internal.printStackTrace();
			conn.wire.writeSuccess();
			break;
		}

		case 2: { /* public void java.lang.Throwable.printStackTrace(java.io.PrintStream) */
			java.io.PrintStream var0 = (java.io.PrintStream) conn.wire.readObject();
			internal.printStackTrace(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 3: { /* public void java.lang.Throwable.printStackTrace(java.io.PrintWriter) */
			java.io.PrintWriter var0 = (java.io.PrintWriter) conn.wire.readObject();
			internal.printStackTrace(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 4: { /* public synchronized native java.lang.Throwable java.lang.Throwable.fillInStackTrace() */
			java.lang.Throwable ret = internal.fillInStackTrace();
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 5: { /* public java.lang.Throwable java.lang.Throwable.getCause() */
			java.lang.Throwable ret = internal.getCause();
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 6: { /* public synchronized java.lang.Throwable java.lang.Throwable.initCause(java.lang.Throwable) */
			java.lang.Throwable var0 = (java.lang.Throwable) conn.wire.readObject();
			java.lang.Throwable ret = internal.initCause(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 7: { /* public java.lang.String java.lang.Throwable.toString() */
			java.lang.String ret = internal.toString();
			conn.wire.writeSuccess();
			conn.wire.writeString(ret);
			break;
		}

		case 8: { /* public java.lang.String java.lang.Throwable.getMessage() */
			java.lang.String ret = internal.getMessage();
			conn.wire.writeSuccess();
			conn.wire.writeString(ret);
			break;
		}

		case 9: { /* public java.lang.String java.lang.Throwable.getLocalizedMessage() */
			java.lang.String ret = internal.getLocalizedMessage();
			conn.wire.writeSuccess();
			conn.wire.writeString(ret);
			break;
		}

		case 10: { /* public java.lang.StackTraceElement[] java.lang.Throwable.getStackTrace() */
			java.lang.StackTraceElement[] ret = internal.getStackTrace();
			conn.wire.writeSuccess();
			conn.wire.write1DObjectArray(ret);
			break;
		}

		case 11: { /* public void java.lang.Throwable.setStackTrace(java.lang.StackTraceElement[]) */
			java.lang.StackTraceElement[] var0 = (java.lang.StackTraceElement[]) conn.wire.read1DObjectArray();
			internal.setStackTrace(var0);
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
			boolean ret = (var0 instanceof java.lang.Throwable);
			conn.wire.writeSuccess();
			conn.wire.writeboolean(ret);
			break;
		}

		case 1: { /* ctor: public java.lang.Throwable() */
			java.lang.Throwable internal = new java.lang.Throwable();
			conn.wire.writeSuccess();
			conn.wire.writeObject(internal);
			break;
		}

		case 2: { /* ctor: public java.lang.Throwable(java.lang.String) */
			String var0 = conn.wire.readString();
			java.lang.Throwable internal = new java.lang.Throwable(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(internal);
			break;
		}

		case 3: { /* ctor: public java.lang.Throwable(java.lang.String,java.lang.Throwable) */
			String var0 = conn.wire.readString();
			java.lang.Throwable var1 = (java.lang.Throwable) conn.wire.readObject();
			java.lang.Throwable internal = new java.lang.Throwable(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(internal);
			break;
		}

		case 4: { /* ctor: public java.lang.Throwable(java.lang.Throwable) */
			java.lang.Throwable var0 = (java.lang.Throwable) conn.wire.readObject();
			java.lang.Throwable internal = new java.lang.Throwable(var0);
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
