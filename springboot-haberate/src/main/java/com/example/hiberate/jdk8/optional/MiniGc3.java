package com.example.hiberate.jdk8.optional;

public class MiniGc3 {
    private static int _1mb=1024*1024;
    public static void main(String[] args){
        //allocat4发生MiniGC
        byte[] allocat1,allocat2,allocat3,allocat4;
        /*allocat1=new byte[_1mb*2];
        allocat2=new byte[_1mb*2];
        allocat3=new byte[_1mb*2];
        allocat4=new byte[_1mb*4];*/

        //设置不同的年龄
        /*allocat1=new byte[_1mb/4];
        allocat2=new byte[_1mb*4];
        allocat3=new byte[_1mb*4];
        allocat3=null;
        allocat3=new byte[_1mb*4];*/

        //动态年龄 allocat1 allocat2自动进入老年代
        allocat1=new byte[_1mb/4];
        allocat2=new byte[_1mb/4];
        allocat3=new byte[_1mb*4];
        allocat4=new byte[_1mb*4];
        allocat4=null;
        allocat4=new byte[_1mb*4];
    }
}
