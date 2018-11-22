package com.example.hiberate.jdk8.optional;

public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1mb=1024*1024;
    private byte[] bigSize=new byte[2*_1mb];
    public static void main(String[] args){
        ReferenceCountingGC objA=new ReferenceCountingGC();
        ReferenceCountingGC objB=new ReferenceCountingGC();
        objA.instance=objB;
        objB.instance=objA;
        objA=null;
        objB=null;
        System.gc();
    }
}
