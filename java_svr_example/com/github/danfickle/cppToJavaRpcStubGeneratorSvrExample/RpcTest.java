package com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample;

public class RpcTest
{
	public void stringTest(String a, String b, String c)
	{
		assert(a != null && a.equals("test"));
		/* Empty and null strings are passed as empty strings. */
		assert(b != null && b.isEmpty());
		assert(c != null && c.isEmpty());
	}
	
	/* For the numeric types test 0, high and low values. */
	public void byteTest(byte a, byte b, byte c)
	{
		assert(a == 0);
		assert(b == Byte.MAX_VALUE);
		assert(c == Byte.MIN_VALUE);
	}

	public void charTest(char a, char b, char c)
	{
		assert(a == 0);
		assert(b == Character.MAX_VALUE);
		assert(c == Character.MIN_VALUE);
	}	
	
	public void shortTest(short a, short b, short c)
	{
		assert(a == 0);
		assert(b == Short.MAX_VALUE);
		assert(c == Short.MIN_VALUE);
	}
	
	public void intTest(int a, int b, int c)
	{
		assert(a == 0);
		assert(b == Integer.MAX_VALUE);
		assert(c == Integer.MIN_VALUE);
	}
	
	public void longTest(long a, long b, long c)
	{
		assert(a == 0);
		assert(b == Long.MAX_VALUE);
		assert(c == Long.MIN_VALUE);
	}

	public void floatTest(float a, float b, float c)
	{
		assert(a == 0);
		assert(b == Float.MAX_VALUE);
		assert(c == -1f);
	}
	
	public void doubleTest(double a, double b, double c)
	{
		assert(a == 0);
		assert(b == Double.MAX_VALUE);
		assert(c == -1.0);
	}

	public void emptyArrayTest(byte[] in)
	{
		assert(in != null && in.length == 0);
	}
	
	public void byteArrayTest(byte[] in)
	{
		assert(in.length == 3);
		assert(in[0] == 0);
		assert(in[1] == Byte.MAX_VALUE);
		assert(in[2] == Byte.MIN_VALUE);
	}
	
	public void charArrayTest(char[] in)
	{
		assert(in.length == 3);
		assert(in[0] == 0);
		assert(in[1] == Character.MAX_VALUE);
		assert(in[2] == Character.MIN_VALUE);
	}
	
	public void shortArrayTest(short[] in)
	{
		assert(in.length == 3);
		assert(in[0] == 0);
		assert(in[1] == Short.MAX_VALUE);
		assert(in[2] == Short.MIN_VALUE);
	}
	
	public void intArrayTest(int[] in)
	{
		assert(in.length == 3);
		assert(in[0] == 0);
		assert(in[1] == Integer.MAX_VALUE);
		assert(in[2] == Integer.MIN_VALUE);
	}
	
	public void longArrayTest(long[] in)
	{
		assert(in.length == 3);
		assert(in[0] == 0);
		assert(in[1] == Long.MAX_VALUE);
		assert(in[2] == Long.MIN_VALUE);
	}
	
	public void floatArrayTest(float[] in)
	{
		assert(in.length == 3);
		assert(in[0] == 0);
		assert(in[1] == Float.MAX_VALUE);
		assert(in[2] == -1f);
	}
	
	public void doubleArrayTest(double[] in)
	{
		assert(in.length == 3);
		assert(in[0] == 0);
		assert(in[1] == Double.MAX_VALUE);
		assert(in[2] == -1.0);
	}
	
	public void objectTest(Object a, Object b)
	{
		assert(a != null);
		assert(b != null);
		assert(a != b);
	}
	
	public String returnStringTest()
	{
		return "test";
	}

	public String returnStringNullTest()
	{
		return null;
	}

	public String returnStringEmptyTest()
	{
		return "";
	}
	
	public Object returnObjectNullTest()
	{
		return null;
	}
	
	public Object returnObjectTest()
	{
		return new Exception("test");
	}
	
	public Exception returnExceptionTest()
	{
		return new Exception("test");
	}

	public Exception returnExceptionNullTest()
	{
		return null;
	}
	
	public byte returnByteZeroTest()
	{
		return 0;
	}

	public byte returnByteMaxTest()
	{
		return Byte.MAX_VALUE;
	}
	
	public byte returnByteMinTest()
	{
		return Byte.MIN_VALUE;
	}
	
	public char returnCharZeroTest()
	{
		return 0;
	}

	public char returnCharMaxTest()
	{
		return Character.MAX_VALUE;
	}
	
	public char returnCharMinTest()
	{
		return Character.MIN_VALUE;
	}
	
	public short returnShortZeroTest()
	{
		return 0;
	}

	public short returnShortMaxTest()
	{
		return Short.MAX_VALUE;
	}
	
	public short returnShortMinTest()
	{
		return Short.MIN_VALUE;
	}
	
	public int returnIntZeroTest()
	{
		return 0;
	}

	public int returnIntMaxTest()
	{
		return Integer.MAX_VALUE;
	}
	
	public int returnIntMinTest()
	{
		return Integer.MIN_VALUE;
	}
	
	public long returnLongZeroTest()
	{
		return 0L;
	}

	public long returnLongMaxTest()
	{
		return Long.MAX_VALUE;
	}
	
	public long returnLongMinTest()
	{
		return Long.MIN_VALUE;
	}
	
	public float returnFloatZeroTest()
	{
		return 0f;
	}

	public float returnFloatMaxTest()
	{
		return Float.MAX_VALUE;
	}
	
	public float returnFloatMinTest()
	{
		return -1f;
	}
	
	public double returnDoubleZeroTest()
	{
		return 0.0;
	}

	public double returnDoubleMaxTest()
	{
		return Double.MAX_VALUE;
	}
	
	public double returnDoubleMinTest()
	{
		return -1.0;
	}
	
	public byte[] returnByteArrayTest()
	{
		byte[] a = new byte[3];
		a[0] = 0;
		a[1] = Byte.MAX_VALUE;
		a[2] = Byte.MIN_VALUE;
		return a;
	}
	
	public char[] returnCharArrayTest()
	{
		char[] a = new char[3];
		a[0] = 0;
		a[1] = Character.MAX_VALUE;
		a[2] = Character.MIN_VALUE;
		return a;
	}
	
	public short[] returnShortArrayTest()
	{
		short[] a = new short[3];
		a[0] = 0;
		a[1] = Short.MAX_VALUE;
		a[2] = Short.MIN_VALUE;
		return a;
	}

	public int[] returnIntArrayTest()
	{
		int[] a = new int[3];
		a[0] = 0;
		a[1] = Integer.MAX_VALUE;
		a[2] = Integer.MIN_VALUE;
		return a;
	}

	public long[] returnLongArrayTest()
	{
		long[] a = new long[3];
		a[0] = 0L;
		a[1] = Long.MAX_VALUE;
		a[2] = Long.MIN_VALUE;
		return a;
	}

	public float[] returnFloatArrayTest()
	{
		float[] a = new float[3];
		a[0] = 0f;
		a[1] = Float.MAX_VALUE;
		a[2] = -1f;
		return a;
	}
	
	public double[] returnDoubleArrayTest()
	{
		double[] a = new double[3];
		a[0] = 0.0;
		a[1] = Double.MAX_VALUE;
		a[2] = -1.0;
		return a;
	}

	public Object[] returnObjectArrayTest()
	{
		Object[] a = new Object[3];
		a[0] = null;
		a[1] = new Exception("test");
		a[2] = new Object();
		return a;
	}

	public Exception[] returnExceptionArrayTest()
	{
		Exception[] a = new Exception[2];
		a[0] = null;
		a[1] = new Exception("test");
		return a;
	}

	public void throwExceptionTest() throws Exception
	{
		throw new Exception("test");
	}
	
	public int throwExceptionWithReturnTest() throws Exception
	{
		throw new Exception("test");
	}

	public void throwExceptionWithArgsTest(int a, byte b) throws Exception
	{
		throw new Exception("test");
	}
}