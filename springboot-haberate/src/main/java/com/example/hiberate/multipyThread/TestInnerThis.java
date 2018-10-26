package com.example.hiberate.multipyThread;

import com.example.hiberate.innerClass.A;
import com.example.hiberate.innerClass.C;

public class TestInnerThis {
    public static void main(String args[]){
        A a = new A();
        A.B b = a.new B();
        b.mb(333);
        //没有静态(static)的类中类不能使用外部类进行.操作,必须用实例来进行实例化类中类.
        C.D d=new C.D();
        //D是类C的一个属性
    }
}
