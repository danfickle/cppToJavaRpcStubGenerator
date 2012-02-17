package com.github.danfickle.cppToJavaRpcSvrLibrary;
/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class RpcInputStream 
{
	private BufferedInputStream m_is;
	
	private void throwRpcIOException(Exception cause) throws RpcIOException
	{
		RpcIOException rpc = new RpcIOException();
		rpc.initCause(cause);
		throw rpc;
	}
	
	public RpcInputStream(Socket sock) throws RpcIOException
	{
		try {
			m_is = new BufferedInputStream(sock.getInputStream());
		} catch (IOException e) {
			throwRpcIOException(e);
		}
	}

	public byte nextByte() throws RpcIOException
	{
		int abyte = 0;
		try {
			abyte = m_is.read();
		}
		catch(IOException e) {
			throwRpcIOException(e);
		}
		if (abyte == -1)
			throwRpcIOException(new EOFException());
		return (byte) abyte;
	}

	public int getBytes(byte[] bytes, int pos, int len) throws RpcIOException
	{
		int ret = 0;
		try {
			ret = m_is.read(bytes, pos, len);
		} catch (IOException e) {
			throwRpcIOException(e);
		}
		if (ret == -1)
			throwRpcIOException(new EOFException());
		
		return ret;
	}
	
	public void close()
	{
		try {
			m_is.close();
		} catch (IOException e) {
			// Do nothing...
		}
	}
}
