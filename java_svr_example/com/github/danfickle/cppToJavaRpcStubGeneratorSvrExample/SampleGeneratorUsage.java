package com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample;

import java.io.IOException;

import com.github.danfickle.cppToJavaRpcStubGenerator.Generator;

/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
public class SampleGeneratorUsage {
    public static void main(String... args)
    {
    	Generator gen = new Generator();

    	/* Configuration follows. */
    	gen.includeDependentTypes = false;
    	/* Please make sure folders have trailing slash. */
    	/* BE CAREFUL about overwriting. Files will be overwritten silently. */
    	gen.cppOutputFolder = "/home/user/cppToJavaRpcStubGenerator/output/cpp";
    	gen.javaOutputFolder = "/home/user/cppToJavaRpcStubGenerator/output/java";
    	gen.stubPackage = "com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample";
    	gen.libPackage = "com.github.danfickle.cppToJavaRpcSvrLibrary";
    	
    	/* Add your types to process here. */
    	gen.typesToProcess.add("java.lang.StringBuilder");
    	gen.typesToProcess.add("java.lang.Object");
    	gen.typesToProcess.add("java.lang.Exception");
    	gen.typesToProcess.add("java.lang.Throwable");
    	gen.typesToProcess.add("com.github.danfickle.cppToJavaRpcStubGeneratorSvrExample.RpcTest");

    	/* Start the generator. */
    	try {
			gen.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}
