package com.github.danfickle.cppToJavaRpcStubGenerator;
/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Generator
{
	private void cppPrintType(Class<?> ret, boolean inputArg) throws ClassNotFoundException
    {
    	if (inputArg)
    	{
        	if (ret.getCanonicalName().equals("java.lang.String"))
        	{
        		out.printf("const std::string & ");
        	}
    		else if (ret.isArray())
    		{
    			out.printf("const std::vector<%s> & ", cppArrayType(true, ret.getName()));
    		}
    		else if (ret.getCanonicalName().contains("."))
    		{
    			cppIsTypeIncluded(ret.getCanonicalName());
    			out.printf("%s & ", ret.getCanonicalName().replace('.', '_'));
    		}
    		else
    		{
    			out.printf("%s ", javaToCppTypes.get(ret.getCanonicalName()));
    		}
    	}
    	else
    	{
    		if (ret.getCanonicalName().equals("java.lang.String"))
    		{
    			out.printf("std::string ");
    		}
    		else if (ret.isArray())
    		{
    			out.printf("std::vector<%s> ", cppArrayType(true, ret.getName()));
    		}
    		else if (ret.getCanonicalName().contains("."))
    		{
    			cppIsTypeIncluded(ret.getCanonicalName());
    			out.printf("%s ", ret.getCanonicalName().replace('.', '_'));
    		}
    		else
    		{
    			out.printf("%s ", javaToCppTypes.get(ret.getCanonicalName()));
    		}
    	}
    }
    
    private void cppPrintMethodSignature(Method m, boolean isImplementation, boolean isStatic) throws ClassNotFoundException
    {
		out.print("\t" + (isStatic && !isImplementation ? "static " : ""));
		cppPrintType(m.getReturnType(), false);
		
		if (isImplementation)
			out.print(classNameWithUnderscores + "::");

		out.printf("%s%s(", m.getName(), (cppReserved.contains(m.getName()) ? "1" : ""));
		Class<?>[] pType = m.getParameterTypes();

		if (isStatic)
			out.printf("cppToJavaRpc::Connection * conn%s", (pType.length == 0 ? "" : ", "));
		
		for (int i = 0; i < pType.length; i++)
		{
			cppPrintType(pType[i], true);
			out.printf("var%d%s", i, (i == pType.length - 1 ? "" : ", "));
		}
		out.print(")");
    }

    private void cppPrintCtorSignature(Constructor<?> ctor, boolean isImplementation) throws ClassNotFoundException
    {
		Class<?>[] pType = ctor.getParameterTypes();
		
		if (isImplementation)
			out.print(classNameWithUnderscores + "::");
		
		out.print(classNameWithUnderscores);
		out.print("(cppToJavaRpc::Connection * conn");
		for (int i = 0; i < pType.length; i++)
		{
			out.print(", ");
			cppPrintType(pType[i], true);
			out.printf("var%d", i);
		}
		out.print(")");
    }
    
    private void cppPrintFieldSignature(Field f, boolean isImplementation, boolean isStatic, boolean write) throws ClassNotFoundException
    {
    	if (!write)
    	{
    		out.print("\t" + (isStatic && !isImplementation ? "static " : ""));
    		cppPrintType(f.getType(), false);
				
    		if (isImplementation)
    			out.print(classNameWithUnderscores + "::");

    		out.print("get_" + f.getName() + (cppReserved.contains(f.getName()) ? "1" : "") + "(" + (isStatic ? "cppToJavaRpc::Connection * conn" : "") + ")");
    		out.print(isImplementation ? "" : ";\n");
    	}
    	else
    	{
    		out.print("\t" + (isStatic && !isImplementation ? "static " : ""));
    		out.print("void ");
    	
    		if (isImplementation)
    			out.print(classNameWithUnderscores + "::");

    		out.print("set_" + f.getName() + (cppReserved.contains(f.getName()) ? "1" : "") + "(" + (isStatic ? "cppToJavaRpc::Connection * conn, " : ""));
    		cppPrintType(f.getType(), true);

    		out.print(")" + (isImplementation ? "" : ";"));
    	}
    }

    private void cppPrintWriteStatement(Class<?> type, int i, boolean isStatic) throws ClassNotFoundException
    {
    	String conn = isStatic ? "conn->" : "m_o->m_conn->";
    	
    	if (type.getCanonicalName().equals("java.lang.String"))
			out.printf("\t\t%swrite_String(var%d);%n", conn, i);
		else if (type.isArray())
			out.printf("\t\t%swrite_%s_array(var%d);%n", conn, printArrayType(type.getName()), i);
    	else if (type.getCanonicalName().contains("."))
			out.printf("\t\t%swrite_Object(var%d.m_o);%n", conn, i);
		else
			out.printf("\t\t%swrite_%s(var%d);%n", conn, type.getCanonicalName(), i);
    }
    
    private void cppPrintReturnStatement(Class<?> ret, boolean isStatic) throws ClassNotFoundException
    {
    	String conn = isStatic ? "conn->" : "m_o->m_conn->";
    	
    	if (ret.getCanonicalName().equals("java.lang.String"))
			out.printf("\t\treturn %send_method_String();", conn);
		else if (ret.isArray())
			out.printf("\t\treturn %send_method_%s_array();", conn, printArrayType(ret.getName()));
    	else if (ret.getCanonicalName().contains("."))
    	{
    		cppIsTypeIncluded(ret.getCanonicalName());
   			out.printf("\t\treturn %s(%send_method_Object());", ret.getCanonicalName().replace('.', '_'), conn);
    	}
   		else if (ret.getCanonicalName().equals("void"))
			out.printf("\t\t%send_method_void();", conn);
		else
			out.printf("\t\treturn %send_method_%s();", conn, ret.getCanonicalName());
    }
    
    private String cppGetPublicSuperclass(Class<?> cls)
    {
	    Class<?> tempClass = cls.getSuperclass();
	    String superClass = "java_object";
	    while (tempClass != null)
	    {
	    	if (Modifier.isPublic(tempClass.getModifiers()))
	    	{
	    		cppIsTypeIncluded(tempClass.getCanonicalName());
	    		superClass = tempClass.getCanonicalName();
	    		break;
	    	}
	    	tempClass = tempClass.getSuperclass();
	    }
	    return superClass;
    }
    
    private boolean cppIsTypeIncluded(String cls)
    {
    	if (typesProcessed.contains(cls) ||
    		typesToProcess.contains(cls))
    	{
    		return true;
    	}
    	else if (!cls.equals("java_object"))
    	{
    		emptyTypes.add(cls);
    	}
		return false;
    }

    private void cppSetupGenerator()
    {
    	javaToCppTypes.put("void", "void");
    	javaToCppTypes.put("boolean", "bool");
    	javaToCppTypes.put("byte", "int8_t");
    	javaToCppTypes.put("char", "uint16_t");
    	javaToCppTypes.put("short", "int16_t");
    	javaToCppTypes.put("int", "int32_t");
    	javaToCppTypes.put("long", "int64_t");
    	javaToCppTypes.put("float", "float");
    	javaToCppTypes.put("double", "double");
    	
    	cppReserved.add("delete");
    	cppReserved.add("typename");
    }
    	
    private void cppCreateClientStubHeader() throws ClassNotFoundException
    {
       	out.println("/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */");
	    out.println("#ifndef " + classNameWithUnderscores.toUpperCase());
	    out.println("#define " + classNameWithUnderscores.toUpperCase());
	    out.println("#include \"types_fwds.h\"");

	    if (cppIsTypeIncluded(cppGetPublicSuperclass(currentClass)))
	    		out.println("#include \"" + cppGetPublicSuperclass(currentClass).replace('.', '_').toLowerCase() + ".h\"");

	    out.println("namespace java {");
	    out.print("class " + classNameWithUnderscores);
    	out.println(" : public " + cppGetPublicSuperclass(currentClass).replace('.', '_') + " {");
    	out.println("public:");
	    
	    out.println("/***** Methods *****/");
	    for (int j = 0; j < methods.size(); j++)
	    {
	    	cppPrintMethodSignature(methods.get(j), false, false);
	    	out.println(";");
	    }

	    out.println("/***** Static Methods *****/");
	    for (int j = 0; j < statics.size(); j++)
	    {
	    	cppPrintMethodSignature(statics.get(j), false, true);
	    	out.println(";");
	    }
	    out.println("\tstatic bool instanceOf(cppToJavaRpc::Connection * conn, const java_object & o);");
	    
	    out.println("/***** Constructors *****/");
	    for(int cc = 0; cc < ctors.size(); cc++)
	    {
	    	out.print("\texplicit ");
	    	cppPrintCtorSignature(ctors.get(cc), false);
	    	out.println(";");
	    }
	    out.println("\texplicit " + classNameWithUnderscores + "(cppToJavaRpc::SafeJavaObjectIdPtr id);");
	    out.println("\texplicit " + classNameWithUnderscores + "();");
	    out.println("\texplicit " + classNameWithUnderscores + "(java_object & o);");

	    out.println("/***** Fields *****/");
	    for (int ff = 0; ff < fields.size(); ff++)
	    {
	    	cppPrintFieldSignature(fields.get(ff), false, false, false);
	    	if (!Modifier.isFinal(fields.get(ff).getModifiers()))
	    		cppPrintFieldSignature(fields.get(ff), false, false, true);
	    }

	    out.println("/***** Static Fields *****/");
	    for (int ff = 0; ff < sfields.size(); ff++)
	    {
	    	cppPrintFieldSignature(sfields.get(ff), false, true, false);
	    	if (!Modifier.isFinal(sfields.get(ff).getModifiers()))
	    		cppPrintFieldSignature(sfields.get(ff), false, true, true);
	    }

	    out.println("\tstatic int32_t JAVA_TYPE_ID;");
	    out.println("};\n}\n#endif");
    }
    
    private void cppCreateClientStub() throws ClassNotFoundException
    {
       	out.println("/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle. */");
    	out.println("#include \"" + classNameWithUnderscores.toLowerCase() + ".h\"");
	    out.println("#include \"conn.h\"\n#include \"types_head.h\"\n");
	    out.println("\tusing namespace java;");

	    for (int j = 0; j < methods.size(); j++)
		{
			Method m = methods.get(j);
			Class<?>[] pType  = m.getParameterTypes();
			
			cppPrintMethodSignature(m, true, false);
			out.println(" {\n\t\tm_o->m_conn->start_method(" + (j + 1) + ", m_o->m_id, JAVA_TYPE_ID);");
			
			for (int i = 0; i < pType.length; i++)
				cppPrintWriteStatement(pType[i], i, false);
			
			cppPrintReturnStatement(m.getReturnType(), false);
			out.println("\n\t}\n");
		}
	    
	    for (int j = 0; j < statics.size(); j++)
		{
			Method m = statics.get(j);
			Class<?>[] pType  = m.getParameterTypes();
			
			cppPrintMethodSignature(m, true, true);
			out.println(" {\n\t\tconn->start_method(" + (j + ctors.size() + 1) + ", 0, JAVA_TYPE_ID);");
			
			for (int i = 0; i < pType.length; i++)
				cppPrintWriteStatement(pType[i], i, true);
			
			cppPrintReturnStatement(m.getReturnType(), true);
			out.println("\n\t}\n");
		}
	    out.println("\tbool " + classNameWithUnderscores + "::instanceOf(cppToJavaRpc::Connection * conn, const java_object & o) {");
	    out.println("\t\tconn->start_method(0, 0, JAVA_TYPE_ID);");
	    out.println("\t\tconn->write_Object(o.m_o);");
	    out.println("\t\treturn conn->end_method_boolean();\n\t}\n");
	    
	    out.println("\t" + classNameWithUnderscores + "::" + classNameWithUnderscores + "() {}\n");
	    out.println("\t" + classNameWithUnderscores + "::" + classNameWithUnderscores + "(cppToJavaRpc::SafeJavaObjectIdPtr id) { m_o = (id); }\n");
	    out.println("\t" + classNameWithUnderscores + "::" + classNameWithUnderscores + "(java_object & o) { m_o = o.m_o; }\n");
	    for(int cc = 0; cc < ctors.size(); cc++)
	    {
	    	Constructor<?> ctor = ctors.get(cc);
			Class<?>[] pType  = ctor.getParameterTypes();
			
			out.print("\t");
			cppPrintCtorSignature(ctor, true);
			out.println(" {\n\t\tconn->start_method(" + (cc + 1) + ", 0, JAVA_TYPE_ID);");
			
			for (int i = 0; i < pType.length; i++)
			{
				cppPrintWriteStatement(pType[i], i, true);
			}
			out.println("\t\tm_o = conn->end_method_Object();\n\t}\n");
	    }

	    for (int ff = 0; ff < fields.size(); ff++)
	    {
	    	Field f = fields.get(ff);
	    	cppPrintFieldSignature(f, true, false, false);
	    	out.println(" {\n\t\tm_o->m_conn->start_method(" + (methods.size() + (ff * 2)) + ", m_o->m_id, JAVA_TYPE_ID);");
	    	cppPrintReturnStatement(f.getType(), false);
			out.println("\n\t}\n");
	    	
	    	if (!Modifier.isFinal(f.getModifiers()))
	    	{
		    	cppPrintFieldSignature(f, true, false, true);	    	
		    	out.println(" {\n\t\tm_o->m_conn->start_method(" + (methods.size() + (ff * 2) + 1) + ", m_o->m_id, JAVA_TYPE_ID);");
		    	cppPrintWriteStatement(f.getType(), 0, false);
		    	cppPrintReturnStatement(void.class, false);
		    	out.println("\n\t}\n");
	    	}
	    }
	    
	    for (int ff = 0; ff < sfields.size(); ff++)
	    {
	    	Field f = sfields.get(ff);
	    	cppPrintFieldSignature(f, true, true, false);
	    	out.println(" {\n\t\tconn->start_method(" + (ctors.size() + statics.size() + 1 +(ff * 2)) + ", 0, JAVA_TYPE_ID);");
	    	cppPrintReturnStatement(f.getType(), true);
			out.println("\n\t}\n");
	    	
	    	if (!Modifier.isFinal(f.getModifiers()))
	    	{
		    	cppPrintFieldSignature(f, true, true, true);	    	
		    	out.println(" {\n\t\tconn->start_method(" + (ctors.size() + statics.size() + 1 +(ff * 2) + 1) + ", 0, JAVA_TYPE_ID);");
		    	cppPrintWriteStatement(f.getType(), 0, true);
		    	cppPrintReturnStatement(void.class, true);
		    	out.println("\n\t}\n");
	    	}
	    }
	}

    private String cppArrayType(boolean in, String arrayType) throws ClassNotFoundException
    {
    	int i = 0;
    	while (arrayType.charAt(i) == '[')
    		i++;
    	char typeChar = arrayType.charAt(i);
    	switch (typeChar)
    	{
    	case 'Z':
    		return "bool";
    	case 'B':
    		return "int8_t";
    	case 'C':
    		return "uint16_t";
    	case 'D':
    		return "double";
    	case 'F':
    		return "float";
    	case 'I':
    		return "int32_t";
    	case 'J':
    		return "int64_t";
    	case 'S':
    		return "int16_t";
    	case 'L':
    	{
    		String canType = arrayType.substring(i + 1);
    		canType = canType.substring(0, canType.length() - 1);
    		
    		if (canType.equals("java.lang.String"))
    		{
    			return "std::string";
    		}
    		else
    		{
    			if (cppIsTypeIncluded(canType))
    				addDependentType(canType);

    			return (in ? "java_object" : canType.replace('.', '_'));
    		}
    	}
    	default:
    		return "BROKEN_JAVA";
    	}
    }
    
    private String printArrayType(String arrayType) throws ClassNotFoundException
    {
    	int i = 0;
    	while (arrayType.charAt(i) == '[')
    		i++;
    	
    	char typeChar = arrayType.charAt(i);
    	
    	switch (typeChar)
    	{
    	case 'Z':
    		return i + "D_boolean";
    	case 'B':
    		return i + "D_byte";
    	case 'C':
    		return i + "D_char";
    	case 'D':
    		return i + "D_double";
    	case 'F':
    		return i + "D_float";
    	case 'I':
    		return i + "D_int";
    	case 'J':
    		return i + "D_long";
    	case 'S':
    		return i + "D_short";
    	case 'L':
       	{
    		String canType = arrayType.substring(i + 1);
    		canType = canType.substring(0, canType.length() - 1);
    		
    		if (canType.equals("java.lang.String"))
    		{
    			return i + "D_String";
    		}
    		else
    		{
    			if (cppIsTypeIncluded(canType))
    				addDependentType(canType);
    			return i + "D_Object";
    		}
    	}
    	default:
    		return "BROKEN_JAVA";
    	}
    }
   
    private void javaPrintReadStatement(Class<?> type, int i) throws ClassNotFoundException
    {
		if (type.getCanonicalName().equals("java.lang.String"))
			out.printf("\t\t\tString var%d = conn.wire.readString();%n", i);
		else if (type.isArray())
			out.printf("\t\t\t%s var%d = (%s) conn.wire.read%sArray();%n", type.getCanonicalName(), i, type.getCanonicalName(), printArrayType(type.getName()).replace("_", ""));
		else if (type.getCanonicalName().contains("."))
			out.printf("\t\t\t%s var%d = (%s) conn.wire.readObject();%n", type.getCanonicalName(), i, type.getCanonicalName());
		else
			out.printf("\t\t\t%s var%d = conn.wire.read%s();%n", type.getCanonicalName(), i, type.getCanonicalName());
    }
    
    private void javaPrintReturnStatement(Class<?> ret) throws ClassNotFoundException
    {
    	if (ret.getCanonicalName().equals("java.lang.String"))
    		out.println("\t\t\tconn.wire.writeString(ret);");
    	else if (ret.isArray())
    		out.printf("\t\t\tconn.wire.write%sArray(ret);%n", printArrayType(ret.getName()).replace("_", ""));
    	else if (ret.getCanonicalName().contains("."))
    		out.println("\t\t\tconn.wire.writeObject(ret);");
    	else if (!ret.getCanonicalName().equals("void"))
    		out.printf("\t\t\tconn.wire.write%s(ret);%n", ret.getCanonicalName());
    }
    
    private void javaCreateServerStub() throws ClassNotFoundException
    {
    	out.printf("package %s;%n", stubPackage);
	    out.println("/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */");
	    out.printf("public class SvrStub_%s {%n", classNameWithUnderscores);
	    out.printf("static public void startMethod(int methodNumber, Object o, %s.Connection conn) throws Exception {%n", libPackage);
	    out.printf("\t%s internal = (%s) o;%n", className, className);
	    out.println("\tswitch (methodNumber) {");

	    for (int j = 0; j < methods.size(); j++)
		{
			Method m = methods.get(j);
			Class<?> ret = m.getReturnType();
			Class<?>[] pType = m.getParameterTypes();

			out.printf("\t\tcase %d: { /* %s */%n", j + 1, m.toGenericString());

			for (int i = 0; i < pType.length; i++)
			{
				addDependentType(pType[i].getCanonicalName());
				javaPrintReadStatement(pType[i], i);
			}

			addDependentType(ret.getCanonicalName());
			if (ret.getCanonicalName().equals("void"))
				out.printf("\t\t\tinternal.%s(", m.getName());
			else
				out.printf("\t\t\t%s ret = internal.%s(", ret.getCanonicalName(), m.getName());

			for (int i = 0; i < pType.length; i++)
				out.printf("var%d%s", i, (i == pType.length - 1 ? "" : ", "));

			out.println(");\n\t\t\tconn.wire.writeSuccess();");
			javaPrintReturnStatement(ret);
			out.println("\t\t\tbreak;\n\t\t}\n");
		}
	    
	    int firstField = methods.size();
		for (int j = 0; j < fields.size(); j++)
		{
			Field f = fields.get(j);
			Class<?> ret = f.getType();

			out.printf("\t\tcase %d: { /* getfield_%s */%n", firstField + (j * 2), f.toGenericString());
			out.printf("\t\t\t%s ret = internal.%s;%n", f.getType().getCanonicalName(), f.getName());
			out.println("\t\t\tconn.wire.writeSuccess();");
			javaPrintReturnStatement(ret);
			out.println("\t\t\tbreak;\n\t\t}");
			
			if (!Modifier.isFinal(f.getModifiers()))
			{
				out.printf("\t\tcase %d: { /* setfield_%s */%n", firstField + (j * 2) + 1, f.toGenericString());
				javaPrintReadStatement(ret, 0);
				out.printf("\t\t\tinternal.%s = var0;%n", f.getName());
				out.println("\t\t\tconn.wire.writeSuccess();");
			}
			addDependentType(f.getType().getCanonicalName());
		}

		out.println("\t\tdefault: {");
		out.println("\t\t\tthrow new NoSuchMethodException(\"Method \" + methodNumber + \" does not exist\");");
		out.println("\t\t}\n\t}\n}\n");
		
	    out.printf("static public void startStaticMethod(int methodNumber, %s.Connection conn) throws Exception {%n", libPackage);
	    out.println("\tswitch (methodNumber) {");
	    out.println("\t\tcase 0: { /* instanceOf */");
	    javaPrintReadStatement(Object.class, 0);
	    out.printf("\t\t\tboolean ret = (var0 instanceof %s);%n", className);
	    out.println("\t\t\tconn.wire.writeSuccess();");
	    javaPrintReturnStatement(boolean.class);
	    out.println("\t\t\tbreak;\n\t\t}\n");
	    
	    for(int i = 0; i < ctors.size(); i++)
	    {
	    	Constructor<?> ctor = ctors.get(i);
    		Class<?> [] types = ctor.getParameterTypes();
	    	out.printf("\t\tcase %d: { /* ctor: %s */%n", i + 1, ctor.toGenericString());
	    	int k = 0;
	    	
	    	for (Class<?> param : ctor.getParameterTypes())
    		{
	    		javaPrintReadStatement(param, k);
	    		k++;
	    		addDependentType(param.getCanonicalName());
    		}
    		out.printf("\t\t\t%s internal = new %s(", className, ctor.getName());

    		for (int j = 0; j < types.length; j++)
    			out.printf("var%d%s", j, (j == types.length - 1 ? "" : ", "));

    		out.println(");\n\t\t\tconn.wire.writeSuccess();");
    		out.println("\t\t\tconn.wire.writeObject(internal);");
    		out.println("\t\t\tbreak;\n\t\t}\n");
	    }
	    
		for (int j = 0; j < statics.size(); j++)
		{
			Method m = statics.get(j);
			out.printf("\t\tcase %d: { /* %s */%n", j + ctors.size() + 1, m.toGenericString());

			Class<?>[] pType = m.getParameterTypes();
			Class<?> ret = m.getReturnType();
			for (int i = 0; i < pType.length; i++)
			{
				javaPrintReadStatement(pType[i], i);
				addDependentType(pType[i].getCanonicalName());
			}

			addDependentType(ret.getCanonicalName());
			if (ret.getCanonicalName().equals("void"))
				out.printf("\t\t\t%s.%s(", className, m.getName());
			else
				out.printf("\t\t\t%s ret = %s.%s(", ret.getCanonicalName(), ret.getCanonicalName(), m.getName());

			for (int i = 0; i < pType.length; i++)
				out.printf("var%d%s", i, (i == pType.length - 1 ? "" : ", "));

			out.println(");\n\t\t\tconn.wire.writeSuccess();");
			javaPrintReturnStatement(ret);
			out.println("\t\t\tbreak;\n\t\t}");
		}

		firstField = ctors.size() + statics.size() + 1;
		for (int j = 0; j < sfields.size(); j++)
		{
			Field f = sfields.get(j);
			Class<?> ret = f.getType();
			out.printf("\t\tcase %d: { /* getfield_%s */%n", firstField + (j * 2), f.toGenericString());
			out.printf("\t\t\t%s ret = %s.%s;%n", ret.getCanonicalName(), className, f.getName());
			out.println("\t\t\tconn.wire.writeSuccess();");
			javaPrintReturnStatement(ret);
			out.println("\t\t\tbreak;\n\t\t}");
			
			if (!Modifier.isFinal(f.getModifiers()))
			{
				out.printf("\t\tcase %d: { /* setfield_ */%n", firstField + (j * 2) + 1, f.toGenericString());
				javaPrintReadStatement(ret, 0);
				out.printf("\t\t\t%s.%s = var0;%n", className, f.getName());
				out.println("\t\t\tconn.wire.writeSuccess();");
			}
		
			addDependentType(f.getType().getCanonicalName());
		}
		
		out.println("\t\tdefault: {");
		out.println("\t\t\tthrow new NoSuchMethodException(\"Static method \" + methodNumber + \" does not exist\");");
		out.println("\t\t}\n\t}\n}\n}");
		
		if (currentClass.getSuperclass() != null)
			addDependentType(currentClass.getSuperclass().getCanonicalName()); 
	}
	    		
	private void addDependentType(String canonicalName)
	{
		Class<?> toAdd = null;
		try {
			toAdd = Class.forName(canonicalName);
		} catch (ClassNotFoundException e) {
			//System.err.println("Warning: class not found (" + canonicalName + ")");
		}			

		if (toAdd != null &&
			Modifier.isPublic(toAdd.getModifiers()) &&
			includeDependentTypes &&
			canonicalName.contains(".") &&
			!typesToProcess.contains(canonicalName) &&
			!typesProcessed.contains(canonicalName))
			typesToProcess.add(canonicalName);
	}
	
	private Map<String, Integer> type_ids = new HashMap<String, Integer>();
	public List<String> typesToProcess = new ArrayList<String>();
	private Set<String> typesProcessed = new HashSet<String>();

	private List<Constructor<?>> ctors = new ArrayList<Constructor<?>>();
	private List<Method> methods = new ArrayList<Method>();
	private List<Method> statics = new ArrayList<Method>();
	private List<Field>  fields = new ArrayList<Field>();
	private List<Field>  sfields = new ArrayList<Field>();
	
	private String className;
	private String classNameWithUnderscores;
	private Class<?> currentClass;
	
	private PrintStream out;
    public boolean includeDependentTypes;
	public String cppOutputFolder;
	public String javaOutputFolder;
	public String stubPackage;
	public String libPackage;

    private HashMap<String, String> javaToCppTypes = new HashMap<String, String>();
    private Set<String> cppReserved = new HashSet<String>();
    private Set<String> emptyTypes = new HashSet<String>();
	
    public void start() throws IOException, ClassNotFoundException
    {
    	int classCount = 1;
    	cppIsTypeIncluded("java.lang.Exception");
    	cppIsTypeIncluded("java.lang.Object");
    	
    	while (!typesToProcess.isEmpty())
    	{
    		className = typesToProcess.get(typesToProcess.size() - 1);
    		classNameWithUnderscores = className.replace('.', '_');
    		typesToProcess.remove(typesToProcess.size() - 1);
    		typesProcessed.add(className);
    		
			currentClass = Class.forName(className);
			type_ids.put(className, classCount++);

			ctors.clear();
			for(Constructor<?> ctor : currentClass.getDeclaredConstructors())
			{
				if (Modifier.isPublic(ctor.getModifiers()) &&
						ctor.getAnnotation(Deprecated.class) == null &&
						!ctor.isSynthetic() &&
						ctor.getDeclaringClass().getCanonicalName().equals(className))
					ctors.add(ctor);
			}

			methods.clear();
			statics.clear();
			for (Method m : currentClass.getDeclaredMethods())
			{
				if (Modifier.isPublic(m.getModifiers()) &&
						m.getAnnotation(Deprecated.class) == null &&
						!m.isSynthetic() &&
						!m.isBridge() &&
						m.getDeclaringClass().getCanonicalName().equals(className))
				{
					if (!Modifier.isStatic(m.getModifiers()))
						methods.add(m);
					else
						statics.add(m);
				}
			}

			fields.clear();
			sfields.clear();
			for (Field f : currentClass.getDeclaredFields())
			{
				if (Modifier.isPublic(f.getModifiers()) &&
						f.getAnnotation(Deprecated.class) == null &&
						!f.isSynthetic() &&
						f.getDeclaringClass().getCanonicalName().equals(className))
				{
					if (!Modifier.isStatic(f.getModifiers()))
						fields.add(f);
					else
						sfields.add(f);
				}
			}

			cppSetupGenerator();

			out = new PrintStream(new File(javaOutputFolder + "SvrStub_" + classNameWithUnderscores + ".java"), "UTF-8");
			javaCreateServerStub();

			out = new PrintStream(new File(cppOutputFolder + classNameWithUnderscores.toLowerCase() + ".h"), "UTF-8");
			cppCreateClientStubHeader();

			out = new PrintStream(new File(cppOutputFolder + classNameWithUnderscores.toLowerCase() + ".cc"), "UTF-8");
			cppCreateClientStub();
    	}

		out = new PrintStream(new File(cppOutputFolder + "types.cc"), "UTF-8");
    	out.println("/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */");
    	for (Entry<String, Integer> item : type_ids.entrySet())
    		out.println("#include \"" + item.getKey().replace('.', '_').toLowerCase() + ".h\"");

    	out.println("using namespace java;");
    	
    	for (Entry<String, Integer> item : type_ids.entrySet())
    		out.println("int32_t " + item.getKey().replace('.', '_') + "::" + "JAVA_TYPE_ID = " + item.getValue() + ";");

		out = new PrintStream(new File(cppOutputFolder + "types_fwds.h"), "UTF-8");
    	out.println("/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */");
    	out.println("#ifndef JAVA_TYPES_FWDS\n#define JAVA_TYPES_FWDS\n");
		out.println("#include \"java_object.h\"");
    	out.println("namespace java {");
		for (Entry<String, Integer> item : type_ids.entrySet())
    		out.println("class " + item.getKey().replace('.', '_') + ";");

		for (String type : emptyTypes)
		{
			out.print("class " + type.replace('.', '_') + " : public java_object { ");
			out.print("public: inline " + type.replace('.','_') + "() {} ");
			out.println("inline " + type.replace('.', '_') + "(cppToJavaRpc::SafeJavaObjectIdPtr o) { m_o = o; } };");
		}
		
		out.println("}\n#endif");
		out.println("#include \"java_rpc_fwds.h\"");

		out = new PrintStream(new File(cppOutputFolder + "types_head.h"), "UTF-8");
    	out.println("/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */");
		for (Entry<String, Integer> item : type_ids.entrySet())
    		out.println("#include \"" + item.getKey().replace('.', '_').toLowerCase() + ".h\"");

		
		out = new PrintStream(new File(javaOutputFolder + "Dispatch.java"), "UTF-8");
		out.println("package " + stubPackage + ";");
		out.println("/* Generated with cppToJavaRpcStubGenerator by github.com/danfickle */");
		out.println("class Dispatch implements " + libPackage + ".CppToJavaRpcDispatch{");
		out.println("public void startMethod(int methodNumber, long id, int typeid, " + libPackage + ".Connection conn) throws Exception {");
		out.println("\tif (id != 0) {");
		out.println("\t\tswitch (typeid) {");

    	for (Entry<String, Integer> item : type_ids.entrySet())
    	{
    		out.print("\t\t\tcase " + item.getValue() + ": { ");
    		out.print("SvrStub_" + item.getKey().replace('.', '_') + ".startMethod(methodNumber, conn.wire.getObject(id), conn); ");
    		out.println("break; }");
    	}
    	out.println("\t\t\tdefault: { throw new ClassNotFoundException(\"Type id \" + typeid + \" not found\"); }");
		out.println("\t\t}\n\t} else {");
		out.println("\t\tswitch (typeid) {");
    	for (Entry<String, Integer> item : type_ids.entrySet())
    	{
    		out.print("\t\t\tcase " + item.getValue() + ": { ");
    		out.print("SvrStub_" + item.getKey().replace('.', '_') + ".startStaticMethod(methodNumber, conn); ");
    		out.println("break; }");
    	}
    	out.println("\t\t\tdefault: { throw new ClassNotFoundException(\"Type id \" + typeid + \" not found\"); }");
    	out.println("\t\t}\n\t}\n}\n}");
    }
}
