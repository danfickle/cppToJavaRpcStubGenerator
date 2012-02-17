package com.github.danfickle.cppToJavaRpcSvrLibrary;
/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
import java.io.IOException;

/* We create a custom exception type so we can determine it from other exceptions
 * which need to be returned to the client.
 */
public class RpcIOException extends IOException
{
	private static final long serialVersionUID = 1L;
}
