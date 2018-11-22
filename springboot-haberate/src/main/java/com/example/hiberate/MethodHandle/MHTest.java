package com.example.hiberate.MethodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;

public class MHTest {
    public String toString(String s,String s2) {

        return "hello," + s + "MethodHandle,"+s2;
    }

    public static void main(String[] args) {
        MHTest mhTest = new MHTest();
        MethodHandle mh = getToStringMH();////获取方法句柄

        //1.
        try {
            String result = (String)mh.invokeExact(mhTest,"sss","sss2");
            System.out.println(result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //2.
        mh= mh.bindTo(mhTest);
        try {
            String result = (String)mh.invokeWithArguments("sss","sss2");
            System.out.println(result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    public static MethodHandle getToStringMH(){
        MethodType methodType=MethodType.methodType(String.class, Arrays.asList(String.class,String.class));
        MethodHandle methodHandle = null;
        try {
             methodHandle=MethodHandles.lookup().findVirtual(MHTest.class,"toString",methodType);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return methodHandle;
    }
}
