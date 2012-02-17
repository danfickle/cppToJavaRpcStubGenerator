package com.github.danfickle.cppToJavaRpcSvrLibrary;
/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection
{
	public Wire wire;
	private CppToJavaRpcDispatch m_dispatch;
	private Socket m_clientSocket;

	public Connection(int port, CppToJavaRpcDispatch dispatch) throws IOException, RpcIOException
	{
		m_dispatch = dispatch;
        ServerSocket serverSocket = new ServerSocket(port);
        m_clientSocket = serverSocket.accept();
        serverSocket.close();

		RpcInputStream is = new RpcInputStream(m_clientSocket);
	    RpcOutputStream os = new RpcOutputStream(m_clientSocket);
    
	    Coder coder = new Coder(os, is);
		wire = new Wire(coder);
	}
	
	public void close()
	{
		wire.close();
		try {
			m_clientSocket.close();
		} catch (IOException e) {
			/* Do nothing. */
		}
	}
	
	public void read() throws IOException, RpcIOException
	{
		long objectId = wire.readlong();
		//	System.out.println("object ID:" + objectId);
		int methodNumber = wire.readint();
		//	System.out.println("methodNumber:" + methodNumber);
		int typeid = wire.readint();
		//	System.out.println("type ID:" + typeid);
		
		try {
			startMethod(methodNumber, objectId, typeid);		
		}
		catch (Exception e)
		{
			if (e instanceof RpcIOException)
			{
				throw (RpcIOException) e;
			}
			else
			{
				wire.writeFailure();
				wire.writeObject(e);
			}
		}
		wire.flush();
	}
	
	private void startMethod(int methodNumber, long id, int typeid) throws Exception
	{
		//if (wire.getObject(id) != null)
		//	System.out.println(id != 0 ? wire.getObject(id).getClass().getCanonicalName() : "new");

		if (methodNumber == 0 && id != 0 && typeid == 0)
		{
			// Destructor.
			Object internal = wire.getObject(id);
			wire.deleteObject(internal);
			wire.writeSuccess();
		}
		else
		{
			m_dispatch.startMethod(methodNumber, id, typeid, this);
		}
	}
}
