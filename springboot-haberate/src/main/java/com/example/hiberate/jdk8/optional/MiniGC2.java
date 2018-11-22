package com.example.hiberate.jdk8.optional;

public class MiniGC2 {
    private static int _1mb=1024*1024;
    public static void main(String[] args){
        byte[] allocat1,allocat2,allocat3,allocat4,allocat5,allocat6,allocat7;
        allocat1=new byte[2*_1mb];
        allocat2=new byte[2*_1mb];
        allocat3=new byte[2*_1mb];
        allocat1=null;
        allocat4=new byte[2*_1mb];
        allocat5=new byte[2*_1mb];
        allocat6=new byte[2*_1mb];
        allocat4=null;
        allocat5=null;
        allocat6=null;
        allocat7=new byte[2*_1mb];
    }
}
