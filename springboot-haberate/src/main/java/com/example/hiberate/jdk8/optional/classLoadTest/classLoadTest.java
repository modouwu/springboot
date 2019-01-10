package com.example.hiberate.jdk8.optional.classLoadTest;

public class classLoadTest {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
        Singleton2 singleTon2 = Singleton2.getInstance2();
        System.out.println("count1=" + singleTon2.value1);
        System.out.println("count2=" + singleTon2.value2);
    }
}
