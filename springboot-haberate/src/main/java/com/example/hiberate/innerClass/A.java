package com.example.hiberate.innerClass;

public class A {
    private int s = 111;
    public class B {
        private int s = 222;
        public void mb(int s) {
            System.out.println(s); // 局部变量s
            System.out.println(this.s); // 内部类对象的属性s
            System.out.println(A.this.s); // 外层类对象属性s
            //内部类与类中的域、方法一样是外部类的成员，所以在内部类中可以直接访问外部类
            //的其他域及方法，即使它们是private 的。这也是使用内部类的一个好处。
            //如果内部类中与外部类有同名的域或方法，可以使用冠以外部类名.this 来访问外部类
            //中的同名成员。
        }
    }
}
