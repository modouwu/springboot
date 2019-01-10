package com.example.hiberate.jdk8.optional.classLoadTest;


public class Test {
    public static void main(String[] args)  {

    }

    public void test(int b) {
        int a = 10;
        new Thread(() -> {
            System.out.println(a);
            System.out.println(b);
        }).start();
    }
}
