package com.ByteDance.proxy.bdproxy;


import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @ClassName BDProxy
 * @Description TODO 代理
 * @Version 1.0
 **/
public class BDProxy {

    public static final String lineFeed = "\n";

    //JDK中$Proxy0 后面的数字会自增
    public static int count = -1;

    public static Object newProxyInstance(
            BDClassLoader loader,
            Class<?>[] interfaces,
            BDInvocationHandler h) throws IllegalArgumentException {
        //用代码生成代码
        String classCode = generateSourceCode(interfaces);
        System.out.println(classCode);
        String className = "$Proxy" + count;

        String classPath = BDProxy.class.getResource("").getPath();
        try {
            //将字符串写入到.java文件中
            File file = new File(classPath + className + ".java");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(classCode.getBytes());
            fos.flush();

            //JDK的tools工具类，将文件编译为.class文件
            JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
            task.call();
            standardFileManager.close();

            //创建代理类
            Class<?> aClass = loader.findClass(className);
            Constructor<?> constructor = aClass.getConstructor(BDInvocationHandler.class);
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSourceCode(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        //包名
        String packageName = BDProxy.class.getPackage().getName();
        sb.append("package ").append(packageName).append(";").append(lineFeed);
        //import类
        String implementsInterface = "";
        for (int i = 0; i < interfaces.length; i++) {
            String iName = interfaces[i].getName();
            sb.append("import ").append(iName).append(";").append(lineFeed);
            if (i == interfaces.length - 1) {
                implementsInterface += iName;
            } else {
                implementsInterface += iName + ",";
            }
        }
        //引入反射包
        sb.append("import java.lang.reflect.*;").append(lineFeed);

        //代理类
        String className = "$Proxy" + ++count;
        sb.append("public class " + className).append(" implements ").append(implementsInterface).append("{").append(lineFeed);
        //聚合BDInvocationHandler
        sb.append("BDInvocationHandler h;").append(lineFeed);
        //构造器给BDInvocationHandler赋值
        sb.append("public " + className + "(BDInvocationHandler h){").append(lineFeed);
        sb.append("this.h = h;").append(lineFeed);
        sb.append("}").append(lineFeed);

        //实现接口所有方法
        for (int i = 0; i < interfaces.length; i++) {
            Method[] declaredMethods = interfaces[i].getDeclaredMethods();
            for (int j = 0; j < declaredMethods.length; j++) {
                Method method = declaredMethods[j];
                //方法名
                String methodName = method.getName();
                //方法返回类型名
                String returnTypeName = method.getReturnType().getName();
                //参数类型
                Class<?>[] parameterTypes = method.getParameterTypes();
                String param = "param";
                String paramTypeMethod = "";
                String paramType = "";
                String inParam = "";
                for (int k = 0; k < parameterTypes.length; k++) {
                    Class<?> parameterType = parameterTypes[k];
                    String typeName = parameterType.getTypeName();
                    if (k == parameterTypes.length - 1) {
                        paramTypeMethod += typeName + " " + param + k;
                        paramType += typeName + ".class";
                        inParam += param + k;
                    }
                    else {
                        paramTypeMethod += typeName + " " + param + k + ",";
                        paramType += typeName + ".class,";
                        inParam += param + k + ",";
                    }
                }
                //构造方法
                sb.append("public " + returnTypeName + " " + methodName + "(").append(paramTypeMethod).append("){").append(lineFeed);

                sb.append("try {").append(lineFeed);

                sb.append("Method m = " + interfaces[i].getName() + ".class.getMethod(").append("\"" + methodName + "\", new Class[]{").append(paramType).append("});").append(lineFeed);
                if ("void".equals(returnTypeName)) {
                    sb.append("this.h.invoke(this, m, new java.lang.Object[]{").append(paramType).append("});").append(lineFeed);
                    sb.append("} catch (Throwable e){ e.printStackTrace();}").append(lineFeed);
                }
                else {
                    sb.append("return (" + returnTypeName + ") this.h.invoke(this, m, new java.lang.Object[]{").append(inParam).append("});").append(lineFeed);
                    sb.append("} catch (Throwable e){ ").append(lineFeed);
                    sb.append("e.printStackTrace();").append(lineFeed);
                    sb.append("}").append(lineFeed);
                    sb.append("return null;").append(lineFeed);
                }
                sb.append("}").append(lineFeed);
            }
        }

        sb.append("}").append(lineFeed);

        return sb.toString();
    }

}
