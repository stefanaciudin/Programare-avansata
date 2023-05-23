package compulsory;

import junit.framework.Test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.net.MalformedURLException;

public class ClassAnalyzer {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        Class clasa = null;
        try {
            clasa = Class.forName("compulsory.TestClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        File f = new File("/home/stef/Desktop/pa labs/12/compulsory/src/main/java/compulsory/TestClass.java");
        URL urls[] = new URL[1];
        urls[0] = f.toURI().toURL();
        ClassLoader cl = new URLClassLoader(urls);
        cl.loadClass("compulsory.TestClass");

        assert clasa != null;
        System.out.println("Package of the class:" + clasa.getPackage().getName());

        for (Method m : clasa.getMethods()) {
            if (m.getParameterCount() == 0) {
                try {
                    m.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Method name: " + m.getName());
            System.out.println("Method parameters: " + Arrays.toString(m.getParameters()));
            System.out.println("Method return type: " + m.getReturnType());
            System.out.println("Method exceptions: " + Arrays.toString(m.getExceptionTypes()));
        }
        //invokeTestMethods(clasa);

    }

}