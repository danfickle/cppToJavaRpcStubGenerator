# C++ To Java RPC Stub Generator #

## About ##
This project is an automatic stub generator for C++ to Java RPC (remote procedure calls). It uses Java reflection to automatically produce server(Java) and client(C++) stubs. Also included in the project are basic C++ and Java RPC libraries that are used by the stubs. Currently tested on Linux with JRE 1.6.

## Sample code ##
This sample shows usage of the java.lang.StringBuilder class in C++:

	java::java_lang_StringBuilder o(&conn);

	o.append(std::string("Hello World!\n"));
	o.append(256);
	o.append(1.12345f).append(23456.789).append(-1000); /* Method chaining supported. */
	o.append(-1000);
	o.append(0);

	std::vector<uint16_t> chars;
	chars.push_back('g');
	chars.push_back('i');
	chars.push_back('t');

	o.append(chars, 1, 2); /* Arrays supported. */

	std::cout << o.toString() << std::endl;
	std::cout << o.reverse().toString() << std::endl;

## License ##
The project code is licensed under the permissive BSD license. Generated files remain the property of the people generating them.

## Current Issues ##
+ Two or more dimension arrays are not supported by the RPC libraries. If you generate stubs for a class containing methods that take or return two or more dimension arrays, you will have to go into the stubs and comment out those methods.
+ In/out arguments are not supported.
+ No way to tell whether a string is null or empty.
+ No way to tell whether an array is null or empty.
+ No way to pass in null object reference.
+ Warnings produced in Java stubs (unchecked and rawtypes).


## Dependencies ##
The C++ RPC library uses socket communication as well as strong and weak pointers. These can either be provided by the C++ Boost library or the Qt framework.

## Using ##
The project contains three java projects (the generator, RPC server library and a sample server) and one C++ project (RPC client library with sample usage).

 1. First build the Java server RPC library and export as a JAR.
 2. Build the Java generator and export as a JAR.
 3. Import these JAR files into the Java sample server, build and run either SampleGeneratorUsage.java or SimpleServer.java
 4. Compile the C++ project using (on Linux) `g++ -I /home/user/boost_1_46_1/ *.cc -lpthread -lboost_system` (with the cpp directory as cwd). 
 5. You can also build the C++ project using Qt. A Qt project file is included.
 6. You can now run the C++ sample project.

## Types ##
The following types are supported:

	Java Type           C++ Type
	number              int8_t, int16_t, int32_t, int64_t, float, double
	char                uint16_t
	java.lang.String    std::string in UTF-8 format.
	object              generated object stub
	array               std::vector<array_type> eg. std::vector<int8_t> for byte[]

## Exceptions ##
Exceptions thrown in the Java stubs are propagated back to the C++ client. The exception thrown is always a `java::java_lang_Exception`. However, one can use the instanceOf operator and casting constructor to cast to supported exception types. The following code sample demonstrates this:

	try
	{
		o.append(chars, 5, 3);
	}
	catch(java::java_lang_Exception e)
	{
		e.printStackTrace();
		if (java::java_lang_Throwable::instanceOf(&conn, e))
		{
			java::java_lang_Throwable throwable(e);
			std::cout << throwable.getMessage() << std::endl;
		}
	}

## Performance ##
This project favors correctness and ease-of-use over performance. Therefore, some performance anti-patterns are used such as returning std::string and std::vector on the stack.

## Security ##
The project is intended to be used only with trusted clients.
