package com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample;
/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
public class SvrStub_java_lang_StringBuilder {
static public void startMethod(int methodNumber, Object o, com.github.danfickle.cppToJavaRpcSvrLibrary.Connection conn) throws Exception {
	java.lang.StringBuilder internal = (java.lang.StringBuilder) o;
	switch (methodNumber) {
		case 1: { /* public java.lang.String java.lang.StringBuilder.toString() */
			java.lang.String ret = internal.toString();
			conn.wire.writeSuccess();
			conn.wire.writeString(ret);
			break;
		}

		case 2: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(java.lang.Object) */
			java.lang.Object var0 = (java.lang.Object) conn.wire.readObject();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 3: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(java.lang.String) */
			String var0 = conn.wire.readString();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 4: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(java.lang.StringBuffer) */
			java.lang.StringBuffer var0 = (java.lang.StringBuffer) conn.wire.readObject();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 5: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(java.lang.CharSequence) */
			java.lang.CharSequence var0 = (java.lang.CharSequence) conn.wire.readObject();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 6: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(java.lang.CharSequence,int,int) */
			java.lang.CharSequence var0 = (java.lang.CharSequence) conn.wire.readObject();
			int var1 = conn.wire.readint();
			int var2 = conn.wire.readint();
			java.lang.StringBuilder ret = internal.append(var0, var1, var2);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 7: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(char[]) */
			char[] var0 = (char[]) conn.wire.read1DcharArray();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 8: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(char[],int,int) */
			char[] var0 = (char[]) conn.wire.read1DcharArray();
			int var1 = conn.wire.readint();
			int var2 = conn.wire.readint();
			java.lang.StringBuilder ret = internal.append(var0, var1, var2);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 9: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(boolean) */
			boolean var0 = conn.wire.readboolean();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 10: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(char) */
			char var0 = conn.wire.readchar();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 11: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(int) */
			int var0 = conn.wire.readint();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 12: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(long) */
			long var0 = conn.wire.readlong();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 13: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(float) */
			float var0 = conn.wire.readfloat();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 14: { /* public java.lang.StringBuilder java.lang.StringBuilder.append(double) */
			double var0 = conn.wire.readdouble();
			java.lang.StringBuilder ret = internal.append(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 15: { /* public int java.lang.StringBuilder.indexOf(java.lang.String) */
			String var0 = conn.wire.readString();
			int ret = internal.indexOf(var0);
			conn.wire.writeSuccess();
			conn.wire.writeint(ret);
			break;
		}

		case 16: { /* public int java.lang.StringBuilder.indexOf(java.lang.String,int) */
			String var0 = conn.wire.readString();
			int var1 = conn.wire.readint();
			int ret = internal.indexOf(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeint(ret);
			break;
		}

		case 17: { /* public int java.lang.StringBuilder.lastIndexOf(java.lang.String) */
			String var0 = conn.wire.readString();
			int ret = internal.lastIndexOf(var0);
			conn.wire.writeSuccess();
			conn.wire.writeint(ret);
			break;
		}

		case 18: { /* public int java.lang.StringBuilder.lastIndexOf(java.lang.String,int) */
			String var0 = conn.wire.readString();
			int var1 = conn.wire.readint();
			int ret = internal.lastIndexOf(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeint(ret);
			break;
		}

		case 19: { /* public java.lang.StringBuilder java.lang.StringBuilder.replace(int,int,java.lang.String) */
			int var0 = conn.wire.readint();
			int var1 = conn.wire.readint();
			String var2 = conn.wire.readString();
			java.lang.StringBuilder ret = internal.replace(var0, var1, var2);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 20: { /* public java.lang.StringBuilder java.lang.StringBuilder.appendCodePoint(int) */
			int var0 = conn.wire.readint();
			java.lang.StringBuilder ret = internal.appendCodePoint(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 21: { /* public java.lang.StringBuilder java.lang.StringBuilder.delete(int,int) */
			int var0 = conn.wire.readint();
			int var1 = conn.wire.readint();
			java.lang.StringBuilder ret = internal.delete(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 22: { /* public java.lang.StringBuilder java.lang.StringBuilder.deleteCharAt(int) */
			int var0 = conn.wire.readint();
			java.lang.StringBuilder ret = internal.deleteCharAt(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 23: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,char[],int,int) */
			int var0 = conn.wire.readint();
			char[] var1 = (char[]) conn.wire.read1DcharArray();
			int var2 = conn.wire.readint();
			int var3 = conn.wire.readint();
			java.lang.StringBuilder ret = internal.insert(var0, var1, var2, var3);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 24: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,java.lang.Object) */
			int var0 = conn.wire.readint();
			java.lang.Object var1 = (java.lang.Object) conn.wire.readObject();
			java.lang.StringBuilder ret = internal.insert(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 25: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,java.lang.String) */
			int var0 = conn.wire.readint();
			String var1 = conn.wire.readString();
			java.lang.StringBuilder ret = internal.insert(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 26: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,char[]) */
			int var0 = conn.wire.readint();
			char[] var1 = (char[]) conn.wire.read1DcharArray();
			java.lang.StringBuilder ret = internal.insert(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 27: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,java.lang.CharSequence) */
			int var0 = conn.wire.readint();
			java.lang.CharSequence var1 = (java.lang.CharSequence) conn.wire.readObject();
			java.lang.StringBuilder ret = internal.insert(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 28: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,java.lang.CharSequence,int,int) */
			int var0 = conn.wire.readint();
			java.lang.CharSequence var1 = (java.lang.CharSequence) conn.wire.readObject();
			int var2 = conn.wire.readint();
			int var3 = conn.wire.readint();
			java.lang.StringBuilder ret = internal.insert(var0, var1, var2, var3);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 29: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,boolean) */
			int var0 = conn.wire.readint();
			boolean var1 = conn.wire.readboolean();
			java.lang.StringBuilder ret = internal.insert(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 30: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,char) */
			int var0 = conn.wire.readint();
			char var1 = conn.wire.readchar();
			java.lang.StringBuilder ret = internal.insert(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 31: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,int) */
			int var0 = conn.wire.readint();
			int var1 = conn.wire.readint();
			java.lang.StringBuilder ret = internal.insert(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 32: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,long) */
			int var0 = conn.wire.readint();
			long var1 = conn.wire.readlong();
			java.lang.StringBuilder ret = internal.insert(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 33: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,float) */
			int var0 = conn.wire.readint();
			float var1 = conn.wire.readfloat();
			java.lang.StringBuilder ret = internal.insert(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 34: { /* public java.lang.StringBuilder java.lang.StringBuilder.insert(int,double) */
			int var0 = conn.wire.readint();
			double var1 = conn.wire.readdouble();
			java.lang.StringBuilder ret = internal.insert(var0, var1);
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 35: { /* public java.lang.StringBuilder java.lang.StringBuilder.reverse() */
			java.lang.StringBuilder ret = internal.reverse();
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
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
			boolean ret = (var0 instanceof java.lang.StringBuilder);
			conn.wire.writeSuccess();
			conn.wire.writeboolean(ret);
			break;
		}

		case 1: { /* ctor: public java.lang.StringBuilder() */
			java.lang.StringBuilder internal = new java.lang.StringBuilder();
			conn.wire.writeSuccess();
			conn.wire.writeObject(internal);
			break;
		}

		case 2: { /* ctor: public java.lang.StringBuilder(int) */
			int var0 = conn.wire.readint();
			java.lang.StringBuilder internal = new java.lang.StringBuilder(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(internal);
			break;
		}

		case 3: { /* ctor: public java.lang.StringBuilder(java.lang.String) */
			String var0 = conn.wire.readString();
			java.lang.StringBuilder internal = new java.lang.StringBuilder(var0);
			conn.wire.writeSuccess();
			conn.wire.writeObject(internal);
			break;
		}

		case 4: { /* ctor: public java.lang.StringBuilder(java.lang.CharSequence) */
			java.lang.CharSequence var0 = (java.lang.CharSequence) conn.wire.readObject();
			java.lang.StringBuilder internal = new java.lang.StringBuilder(var0);
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
