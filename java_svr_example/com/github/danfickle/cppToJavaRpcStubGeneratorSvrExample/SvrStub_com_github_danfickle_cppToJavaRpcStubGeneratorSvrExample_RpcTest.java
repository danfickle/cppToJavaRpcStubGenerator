package com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample;
/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */
public class SvrStub_com_github_danfickle_cppToJavaRpcStubGeneratorSvrExample_RpcTest {
static public void startMethod(int methodNumber, Object o, com.github.danfickle.cppToJavaRpcSvrLibrary.Connection conn) throws Exception {
	com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest internal = (com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest) o;
	switch (methodNumber) {
		case 1: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.stringTest(java.lang.String,java.lang.String,java.lang.String) */
			String var0 = conn.wire.readString();
			String var1 = conn.wire.readString();
			String var2 = conn.wire.readString();
			internal.stringTest(var0, var1, var2);
			conn.wire.writeSuccess();
			break;
		}

		case 2: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.byteTest(byte,byte,byte) */
			byte var0 = conn.wire.readbyte();
			byte var1 = conn.wire.readbyte();
			byte var2 = conn.wire.readbyte();
			internal.byteTest(var0, var1, var2);
			conn.wire.writeSuccess();
			break;
		}

		case 3: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.charTest(char,char,char) */
			char var0 = conn.wire.readchar();
			char var1 = conn.wire.readchar();
			char var2 = conn.wire.readchar();
			internal.charTest(var0, var1, var2);
			conn.wire.writeSuccess();
			break;
		}

		case 4: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.shortTest(short,short,short) */
			short var0 = conn.wire.readshort();
			short var1 = conn.wire.readshort();
			short var2 = conn.wire.readshort();
			internal.shortTest(var0, var1, var2);
			conn.wire.writeSuccess();
			break;
		}

		case 5: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.intTest(int,int,int) */
			int var0 = conn.wire.readint();
			int var1 = conn.wire.readint();
			int var2 = conn.wire.readint();
			internal.intTest(var0, var1, var2);
			conn.wire.writeSuccess();
			break;
		}

		case 6: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.longTest(long,long,long) */
			long var0 = conn.wire.readlong();
			long var1 = conn.wire.readlong();
			long var2 = conn.wire.readlong();
			internal.longTest(var0, var1, var2);
			conn.wire.writeSuccess();
			break;
		}

		case 7: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.floatTest(float,float,float) */
			float var0 = conn.wire.readfloat();
			float var1 = conn.wire.readfloat();
			float var2 = conn.wire.readfloat();
			internal.floatTest(var0, var1, var2);
			conn.wire.writeSuccess();
			break;
		}

		case 8: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.doubleTest(double,double,double) */
			double var0 = conn.wire.readdouble();
			double var1 = conn.wire.readdouble();
			double var2 = conn.wire.readdouble();
			internal.doubleTest(var0, var1, var2);
			conn.wire.writeSuccess();
			break;
		}

		case 9: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.emptyArrayTest(byte[]) */
			byte[] var0 = (byte[]) conn.wire.read1DbyteArray();
			internal.emptyArrayTest(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 10: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.byteArrayTest(byte[]) */
			byte[] var0 = (byte[]) conn.wire.read1DbyteArray();
			internal.byteArrayTest(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 11: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.charArrayTest(char[]) */
			char[] var0 = (char[]) conn.wire.read1DcharArray();
			internal.charArrayTest(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 12: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.shortArrayTest(short[]) */
			short[] var0 = (short[]) conn.wire.read1DshortArray();
			internal.shortArrayTest(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 13: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.intArrayTest(int[]) */
			int[] var0 = (int[]) conn.wire.read1DintArray();
			internal.intArrayTest(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 14: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.longArrayTest(long[]) */
			long[] var0 = (long[]) conn.wire.read1DlongArray();
			internal.longArrayTest(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 15: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.floatArrayTest(float[]) */
			float[] var0 = (float[]) conn.wire.read1DfloatArray();
			internal.floatArrayTest(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 16: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.doubleArrayTest(double[]) */
			double[] var0 = (double[]) conn.wire.read1DdoubleArray();
			internal.doubleArrayTest(var0);
			conn.wire.writeSuccess();
			break;
		}

		case 17: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.objectTest(java.lang.Object,java.lang.Object) */
			java.lang.Object var0 = (java.lang.Object) conn.wire.readObject();
			java.lang.Object var1 = (java.lang.Object) conn.wire.readObject();
			internal.objectTest(var0, var1);
			conn.wire.writeSuccess();
			break;
		}

		case 18: { /* public java.lang.String com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnStringTest() */
			java.lang.String ret = internal.returnStringTest();
			conn.wire.writeSuccess();
			conn.wire.writeString(ret);
			break;
		}

		case 19: { /* public java.lang.String com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnStringNullTest() */
			java.lang.String ret = internal.returnStringNullTest();
			conn.wire.writeSuccess();
			conn.wire.writeString(ret);
			break;
		}

		case 20: { /* public java.lang.String com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnStringEmptyTest() */
			java.lang.String ret = internal.returnStringEmptyTest();
			conn.wire.writeSuccess();
			conn.wire.writeString(ret);
			break;
		}

		case 21: { /* public java.lang.Object com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnObjectNullTest() */
			java.lang.Object ret = internal.returnObjectNullTest();
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 22: { /* public java.lang.Object com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnObjectTest() */
			java.lang.Object ret = internal.returnObjectTest();
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 23: { /* public java.lang.Exception com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnExceptionTest() */
			java.lang.Exception ret = internal.returnExceptionTest();
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 24: { /* public java.lang.Exception com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnExceptionNullTest() */
			java.lang.Exception ret = internal.returnExceptionNullTest();
			conn.wire.writeSuccess();
			conn.wire.writeObject(ret);
			break;
		}

		case 25: { /* public byte com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnByteZeroTest() */
			byte ret = internal.returnByteZeroTest();
			conn.wire.writeSuccess();
			conn.wire.writebyte(ret);
			break;
		}

		case 26: { /* public byte com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnByteMaxTest() */
			byte ret = internal.returnByteMaxTest();
			conn.wire.writeSuccess();
			conn.wire.writebyte(ret);
			break;
		}

		case 27: { /* public byte com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnByteMinTest() */
			byte ret = internal.returnByteMinTest();
			conn.wire.writeSuccess();
			conn.wire.writebyte(ret);
			break;
		}

		case 28: { /* public char com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnCharZeroTest() */
			char ret = internal.returnCharZeroTest();
			conn.wire.writeSuccess();
			conn.wire.writechar(ret);
			break;
		}

		case 29: { /* public char com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnCharMaxTest() */
			char ret = internal.returnCharMaxTest();
			conn.wire.writeSuccess();
			conn.wire.writechar(ret);
			break;
		}

		case 30: { /* public char com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnCharMinTest() */
			char ret = internal.returnCharMinTest();
			conn.wire.writeSuccess();
			conn.wire.writechar(ret);
			break;
		}

		case 31: { /* public short com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnShortZeroTest() */
			short ret = internal.returnShortZeroTest();
			conn.wire.writeSuccess();
			conn.wire.writeshort(ret);
			break;
		}

		case 32: { /* public short com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnShortMaxTest() */
			short ret = internal.returnShortMaxTest();
			conn.wire.writeSuccess();
			conn.wire.writeshort(ret);
			break;
		}

		case 33: { /* public short com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnShortMinTest() */
			short ret = internal.returnShortMinTest();
			conn.wire.writeSuccess();
			conn.wire.writeshort(ret);
			break;
		}

		case 34: { /* public int com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnIntZeroTest() */
			int ret = internal.returnIntZeroTest();
			conn.wire.writeSuccess();
			conn.wire.writeint(ret);
			break;
		}

		case 35: { /* public int com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnIntMaxTest() */
			int ret = internal.returnIntMaxTest();
			conn.wire.writeSuccess();
			conn.wire.writeint(ret);
			break;
		}

		case 36: { /* public int com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnIntMinTest() */
			int ret = internal.returnIntMinTest();
			conn.wire.writeSuccess();
			conn.wire.writeint(ret);
			break;
		}

		case 37: { /* public long com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnLongZeroTest() */
			long ret = internal.returnLongZeroTest();
			conn.wire.writeSuccess();
			conn.wire.writelong(ret);
			break;
		}

		case 38: { /* public long com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnLongMaxTest() */
			long ret = internal.returnLongMaxTest();
			conn.wire.writeSuccess();
			conn.wire.writelong(ret);
			break;
		}

		case 39: { /* public long com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnLongMinTest() */
			long ret = internal.returnLongMinTest();
			conn.wire.writeSuccess();
			conn.wire.writelong(ret);
			break;
		}

		case 40: { /* public float com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnFloatZeroTest() */
			float ret = internal.returnFloatZeroTest();
			conn.wire.writeSuccess();
			conn.wire.writefloat(ret);
			break;
		}

		case 41: { /* public float com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnFloatMaxTest() */
			float ret = internal.returnFloatMaxTest();
			conn.wire.writeSuccess();
			conn.wire.writefloat(ret);
			break;
		}

		case 42: { /* public float com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnFloatMinTest() */
			float ret = internal.returnFloatMinTest();
			conn.wire.writeSuccess();
			conn.wire.writefloat(ret);
			break;
		}

		case 43: { /* public double com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnDoubleZeroTest() */
			double ret = internal.returnDoubleZeroTest();
			conn.wire.writeSuccess();
			conn.wire.writedouble(ret);
			break;
		}

		case 44: { /* public double com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnDoubleMaxTest() */
			double ret = internal.returnDoubleMaxTest();
			conn.wire.writeSuccess();
			conn.wire.writedouble(ret);
			break;
		}

		case 45: { /* public double com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnDoubleMinTest() */
			double ret = internal.returnDoubleMinTest();
			conn.wire.writeSuccess();
			conn.wire.writedouble(ret);
			break;
		}

		case 46: { /* public byte[] com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnByteArrayTest() */
			byte[] ret = internal.returnByteArrayTest();
			conn.wire.writeSuccess();
			conn.wire.write1DbyteArray(ret);
			break;
		}

		case 47: { /* public char[] com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnCharArrayTest() */
			char[] ret = internal.returnCharArrayTest();
			conn.wire.writeSuccess();
			conn.wire.write1DcharArray(ret);
			break;
		}

		case 48: { /* public short[] com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnShortArrayTest() */
			short[] ret = internal.returnShortArrayTest();
			conn.wire.writeSuccess();
			conn.wire.write1DshortArray(ret);
			break;
		}

		case 49: { /* public int[] com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnIntArrayTest() */
			int[] ret = internal.returnIntArrayTest();
			conn.wire.writeSuccess();
			conn.wire.write1DintArray(ret);
			break;
		}

		case 50: { /* public long[] com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnLongArrayTest() */
			long[] ret = internal.returnLongArrayTest();
			conn.wire.writeSuccess();
			conn.wire.write1DlongArray(ret);
			break;
		}

		case 51: { /* public float[] com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnFloatArrayTest() */
			float[] ret = internal.returnFloatArrayTest();
			conn.wire.writeSuccess();
			conn.wire.write1DfloatArray(ret);
			break;
		}

		case 52: { /* public double[] com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnDoubleArrayTest() */
			double[] ret = internal.returnDoubleArrayTest();
			conn.wire.writeSuccess();
			conn.wire.write1DdoubleArray(ret);
			break;
		}

		case 53: { /* public java.lang.Object[] com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnObjectArrayTest() */
			java.lang.Object[] ret = internal.returnObjectArrayTest();
			conn.wire.writeSuccess();
			conn.wire.write1DObjectArray(ret);
			break;
		}

		case 54: { /* public java.lang.Exception[] com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.returnExceptionArrayTest() */
			java.lang.Exception[] ret = internal.returnExceptionArrayTest();
			conn.wire.writeSuccess();
			conn.wire.write1DObjectArray(ret);
			break;
		}

		case 55: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.throwExceptionTest() throws java.lang.Exception */
			internal.throwExceptionTest();
			conn.wire.writeSuccess();
			break;
		}

		case 56: { /* public int com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.throwExceptionWithReturnTest() throws java.lang.Exception */
			int ret = internal.throwExceptionWithReturnTest();
			conn.wire.writeSuccess();
			conn.wire.writeint(ret);
			break;
		}

		case 57: { /* public void com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest.throwExceptionWithArgsTest(int,byte) throws java.lang.Exception */
			int var0 = conn.wire.readint();
			byte var1 = conn.wire.readbyte();
			internal.throwExceptionWithArgsTest(var0, var1);
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
			boolean ret = (var0 instanceof com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest);
			conn.wire.writeSuccess();
			conn.wire.writeboolean(ret);
			break;
		}

		case 1: { /* ctor: public com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest() */
			com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest internal = new com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest();
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
