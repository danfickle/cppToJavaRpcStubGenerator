package com.github.danfickle.cppToJavaRpcSvrLibrary;
/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
import java.io.IOException;
import java.util.HashMap;
import java.util.IdentityHashMap;

public class Wire
{
	private Coder m_coder;
	private HashMap<Long, Object> m_idToObject = new HashMap<Long, Object>();
	private IdentityHashMap<Object, Long> m_objectToId = new IdentityHashMap<Object, Long>();
	private long m_currentObjectId = 1;
	
	public void deleteObject(Object o)
	{
		if (m_objectToId.containsKey(o))
		{
			long id = m_objectToId.get(o);
			m_objectToId.remove(o);
			m_idToObject.remove(id);
		}
	}
	
	public void deleteObject(long id)
	{
		if (m_idToObject.containsKey(id))
		{
			Object o = m_idToObject.get(id);
			m_idToObject.remove(id);
			m_objectToId.remove(o);
		}
	}
	
	public Wire(Coder coder)
	{
		m_coder = coder;
	}
	
	public void close()
	{
		m_coder.close();
	}
	
	public void writeSuccess() throws IOException
	{
		writeboolean(true);
	}
	
	public void writeFailure() throws IOException
	{
		writeboolean(false);
	}
	
	public boolean [] read1DbooleanArray() throws IOException
	{
		int elemLimit = readint();
		boolean [] ret = new boolean[elemLimit];
		for (int i = 0; i < elemLimit; i++)
		{
			ret[i] = readboolean();
		}
		return ret;
	}
	
	public byte[] read1DbyteArray() throws IOException
	{
		int elemLimit = readint();
		byte [] ret = new byte[elemLimit];
		for (int i = 0; i < elemLimit; i++)
		{
			ret[i] = readbyte();
		}
		return ret;
	}
	
	public char[] read1DcharArray() throws IOException
	{
		int elemLimit = readint();
		char [] ret = new char[elemLimit];
		for (int i = 0; i < elemLimit; i++)
		{
			ret[i] = readchar();
		}
		return ret;
	}
	
	public short [] read1DshortArray() throws IOException
	{
		int elemLimit = readint();
		short [] ret = new short[elemLimit];
		for (int i = 0; i < elemLimit; i++)
		{
			ret[i] = readshort();
		}
		return ret;
	}

	public int [] read1DintArray() throws IOException
	{
		int elemLimit = readint();
		int [] ret = new int[elemLimit];
		for (int i = 0; i < elemLimit; i++)
		{
			ret[i] = readint();
		}
		return ret;
	}
	
	public long [] read1DlongArray() throws IOException
	{
		int elemLimit = readint();
		long [] ret = new long[elemLimit];
		for (int i = 0; i < elemLimit; i++)
		{
			ret[i] = readlong();
		}
		return ret;
	}
	
	public float [] read1DfloatArray() throws IOException
	{
		int elemLimit = readint();
		float [] ret = new float[elemLimit];
		for (int i = 0; i < elemLimit; i++)
		{
			ret[i] = readfloat();
		}
		return ret;
	}
	
	public double [] read1DdoubleArray() throws IOException
	{
		int elemLimit = readint();
		double [] ret = new double[elemLimit];
		for (int i = 0; i < elemLimit; i++)
		{
			ret[i] = readdouble();
		}
		return ret;
	}
	
	public String [] read1DStringArray() throws IOException
	{
		int elemLimit = readint();
		String [] ret = new String[elemLimit];
		for (int i = 0; i < elemLimit; i++)
		{
			ret[i] = readString();
		}
		return ret;
	}

	public Object [] read1DObjectArray() throws IOException
	{
		int elemLimit = readint();
		Object [] ret = new Object[elemLimit];
		for (int i = 0; i < elemLimit; i++)
		{
			ret[i] = readObject();
		}
		return ret;
	}
	
	public void write1DbooleanArray(boolean [] in) throws IOException
	{
		writeint(in.length);
		for (int i = 0; i < in.length; i++)
			writeboolean(in[i]);
	}

	public void write1DbyteArray(byte [] in) throws IOException
	{
		writeint(in.length);
		for (int i = 0; i < in.length; i++)
			writebyte(in[i]);
	}

	public void write1DcharArray(char [] in) throws IOException
	{
		writeint(in.length);
		for (int i = 0; i < in.length; i++)
			writechar(in[i]);
	}
	
	public void write1DshortArray(short [] in) throws IOException
	{
		writeint(in.length);
		for (int i = 0; i < in.length; i++)
			writeshort(in[i]);
	}

	public void write1DintArray(int [] in) throws IOException
	{
		writeint(in.length);
		for (int i = 0; i < in.length; i++)
			writeint(in[i]);
	}
	
	public void write1DlongArray(long [] in) throws IOException
	{
		writeint(in.length);
		for (int i = 0; i < in.length; i++)
			writelong(in[i]);
	}
	
	public void write1DfloatArray(float [] in) throws IOException
	{
		writeint(in.length);
		for (int i = 0; i < in.length; i++)
			writefloat(in[i]);
	}
	
	public void write1DdoubleArray(double [] in) throws IOException
	{
		writeint(in.length);
		for (int i = 0; i < in.length; i++)
			writedouble(in[i]);
	}
	
	public void write1DStringArray(String [] in) throws IOException
	{
		writeint(in.length);
		for (int i = 0; i < in.length; i++)
			writeString(in[i]);
	}
	
	public void write1DObjectArray(Object [] in) throws IOException
	{
		writeint(in.length);
		for (int i = 0; i < in.length; i++)
			writeObject(in[i]);
	}
	
	public boolean readboolean() throws IOException
	{
		return (readint() != 0 ? true : false);
	}

	public byte readbyte() throws IOException
	{
		return (byte) readint();
	}
	
	public char readchar() throws IOException
	{
		return (char) readint();
	}
	
	public short readshort() throws IOException
	{
		return (short) readint();
	}
	
	public int readint() throws IOException
	{
		return m_coder.readRawVarint32();
	}

	public long readlong() throws IOException
	{
		return m_coder.readRawVarint64();
	}
	
	public float readfloat() throws IOException
	{
		return m_coder.readFloat();
	}
	
	public double readdouble() throws IOException
	{
		return m_coder.readDouble();
	}

	public String readString() throws IOException
	{
		return m_coder.readString();
	}

	public Object readObject() throws IOException
	{
		// read id from wire and turn into object with HashMap.
		long id = readlong();
		return m_idToObject.get(id);
	}
	
	
	public void writeObject(Object o) throws IOException
	{
		if (o == null)
		{
			writelong(-1);
		}
		// if in IdentityHashMap return that id, otherwise add to IdentityHashMap.
		else if (m_objectToId.containsKey(o))
		{
			Long id = m_objectToId.get(o);
			writelong(id);
		}
		else
		{
			m_objectToId.put(o, m_currentObjectId);
			m_idToObject.put(m_currentObjectId, o);
			writelong(m_currentObjectId);
			m_currentObjectId++;
		}
	}
	
	public void writeboolean(boolean b) throws IOException
	{
		writelong(b ? 1 : 0);
	}

	public void writebyte(byte b) throws IOException
	{
		writelong(b);
	}
	
	public void writechar(char c) throws IOException
	{
		writelong(c);
	}
	
	public void writeshort(short s) throws IOException
	{
		writelong(s);
	}
	
	public void writeint(int i) throws IOException
	{
		writelong(i);
	}

	public void writelong(long l) throws IOException
	{
		m_coder.writeRawVarint64(l);
	}

	public void writefloat(float f) throws IOException
	{
		m_coder.writeFloat(f);
	}
	
	public void writedouble(double d) throws IOException
	{
		m_coder.writeDouble(d);
	}

	public void writeString(String s) throws IOException
	{
		m_coder.writeString(s);
	}
	
	public void flush() throws IOException
	{
		m_coder.flush();
	}

	public Object getObject(long id)
	{
		return m_idToObject.get(id);
	}
}
