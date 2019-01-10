package com.example.hiberate.jdk8.optional.classLoadTest;

public class Singleton2 {
    public static int value1;
    public static int value2 = 2;
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2() {
        value1++;
        value2++;
    }

    public static Singleton2 getInstance2() {
        return singleton2;
    }
    //count1=1
    //count2=3
    //这里由于构造方法在赋值语句后面，所以赋值语句不会覆盖构造方法里的值
}
