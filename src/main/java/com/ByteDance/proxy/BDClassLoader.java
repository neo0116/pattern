package com.ByteDance.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName BDClassLoader
 * @Description TODO
 * @Version 1.0
 **/
public class BDClassLoader extends ClassLoader {

    private File classPathFile;

    public BDClassLoader() {
        String path = BDClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //全类名
        String className = BDClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            //找到类路径下名称为==> name 的类
            File classFile = new File(classPathFile, name + ".class");
            try {
                if (classFile.exists()) {
                    FileInputStream fis = new FileInputStream(classFile);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = fis.read(bytes)) != -1) {
                        bos.write(bytes, 0, len);
                    }
                    //将.class文件转成字节数组后由 JDK底层方法进行类加载
                    return defineClass(className, bos.toByteArray(), 0, bos.size());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
