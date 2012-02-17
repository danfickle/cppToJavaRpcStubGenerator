package com.github.danfickle.cppToJavaRpcSvrLibrary;
/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RpcOutputStream
{
	private BufferedOutputStream m_os;

	public RpcOutputStream(Socket sock) throws RpcIOException
	{
		try {
			m_os = new BufferedOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			RpcIOException rpc = new RpcIOException();
			rpc.initCause(e);
			throw rpc;
		}
	}
	
	public void close()
	{
		try {
			m_os.close();
		} catch (IOException e) {
			/* Do nothing. */
		}
	}
	
	public void write(byte[] bytes) throws RpcIOException
	{
		try {
			m_os.write(bytes);
		} catch (IOException e) {
			RpcIOException rpc = new RpcIOException();
			rpc.initCause(e);
			throw rpc;
		}
	}
	
	public void write(byte[] bytes, int off, int len) throws RpcIOException
	{
		try {
			m_os.write(bytes, off, len);
		} catch (IOException e) {
			RpcIOException rpc = new RpcIOException();
			rpc.initCause(e);
			throw rpc;
		}
	}

	public void flush() throws RpcIOException
	{
		try {
			m_os.flush();
		} catch (IOException e) {
			RpcIOException rpc = new RpcIOException();
			rpc.initCause(e);
			throw rpc;
		}
	}
}
