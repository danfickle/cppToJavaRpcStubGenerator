package com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample;
/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
import java.io.EOFException;
import java.io.IOException;

import com.github.danfickle.cppToJavaRpcSvrLibrary.RpcIOException;

public class SimpleServer {
    
	com.github.danfickle.cppToJavaRpcSvrLibrary.Connection m_conn;
	public void run() throws IOException, RpcIOException
    {
    	m_conn = new com.github.danfickle.cppToJavaRpcSvrLibrary.Connection(14000, new Dispatch());
	    
    	while (true)
    	{
    		/* Each call to read, processes one method call. */
    		m_conn.read();
    	}
    }

	public void shutdown()
	{
		m_conn.close();
	}
	
    public static void main(String... args)
    {
    	SimpleServer mn = new SimpleServer();
    	System.err.println("Note: Some exceptions are caused and stack traces printed by the client for testing purposes.");
    	try{
    		mn.run();
    	}
    	catch (RpcIOException se)
    	{
    		if (se.getCause() instanceof EOFException)
    		{
    			System.out.println("Socket closed by client.");
    		}
    		else
    		{
    			System.err.println("Exception thrown while processing rpc calls: " + se.getCause().getMessage());
    			se.printStackTrace();
    		}
    	}
    	catch (IOException e)
    	{
    		System.err.println("Exception thrown while processing rpc calls: " + e.getMessage());
    		e.printStackTrace();
    	}

    	mn.shutdown();
    }
}
