package com.github.danfickle.cppToJavaRpcSvrLibrary;
/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
import java.io.UnsupportedEncodingException;

public class Coder
{
	private RpcOutputStream m_os;
	private RpcInputStream m_is;

	public Coder(RpcOutputStream os, RpcInputStream is) throws RpcIOException
	{
		m_os = os;
		m_is = is;
	}

	public int readRawVarint32() throws RpcIOException
	{
		return (int) readRawVarint64();
	}

	/* The protocol for variable sized ints is borrowed from Google Protobuffers. */
	public long readRawVarint64() throws RpcIOException
	{
		long result = 0;
		int count = 0;
		int b;
		do { 
			b = m_is.nextByte();
			result |= ((long)(b & 0x7F)) << (7 * count);
			++count;
		} while ((b & 0x80) != 0);

		return result;
	}


	public float readFloat() throws RpcIOException
	{
		return Float.intBitsToFloat(readRawVarint32());
	}

	public double readDouble() throws RpcIOException 
	{
		return Double.longBitsToDouble(readRawVarint64());
	}

	/* Strings are sent and received over the wire in UTF-8 format. */
	public String readString() throws RpcIOException
	{
		int size = readRawVarint32();
		byte[] bytes = new byte[size];
		int pos = 0;
		
		while (size > 0)
		{
			int read = m_is.getBytes(bytes, pos, size);
			pos += read;
			size -= read;
		}
		
		try {
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			RpcIOException rpc = new RpcIOException();
			rpc.initCause(e);
			throw rpc;
		}
	}

	/* The protocol for variable sized ints is borrowed from Google Protobuffers. */
	public void writeRawVarint64(long value) throws RpcIOException {
	    byte [] bytes = new byte[64];
	    int pos = 0;
		
		while (true)
		{
	        if ((value & ~0x7FL) == 0)
	        {
	          bytes[pos++] = (byte) value;
	          break;
	        } else
	        {
	          bytes[pos++] = (byte) (((int)value & 0x7F) | 0x80);
	          value >>>= 7;
	        }
	    }
		m_os.write(bytes, 0, pos);
	}

	public void writeFloat(float value) throws RpcIOException
	{
		writeRawVarint64(Float.floatToRawIntBits(value));
	}

	public void writeDouble(double d) throws RpcIOException
	{
		writeRawVarint64(Double.doubleToRawLongBits(d));
	}

	/* Strings are sent and received over the wire in UTF-8 format. */
	public void writeString(String s) throws RpcIOException
	{
		if (s == null || s.isEmpty())
		{
			writeRawVarint64(0);
		}
		else
		{
			byte[] bytes;
			try {
				bytes = s.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				RpcIOException rpc = new RpcIOException();
				rpc.initCause(e);
				throw rpc;
			}
			writeRawVarint64(bytes.length);
			m_os.write(bytes);
		}
	}

	public void flush() throws RpcIOException 
	{
		m_os.flush();
	}
	
	public void close()
	{
		m_os.close();
		m_is.close();
	}
}
