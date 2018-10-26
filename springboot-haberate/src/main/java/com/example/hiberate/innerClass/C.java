package com.example.hiberate.innerClass;

public class C {
    private int s = 111;
    public static class D {
        private int s = 222;
        public void mb(int s) {
            System.out.println(s); // 局部变量s
            System.out.println(this.s); // 内部类对象的属性s
        }
    }
}
