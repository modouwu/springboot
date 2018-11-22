package com.example.hiberate.jdk8.optional;

import com.example.hiberate.innerClass.A;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC ASVE_HOOK=null;
    public void isAlive(){
        System.out.println("yes i am alive");
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method is executed");
        FinalizeEscapeGC.ASVE_HOOK=this;
    }

    public static void main(String[] args) throws InterruptedException {
        ASVE_HOOK=new FinalizeEscapeGC();
        ASVE_HOOK=null;
        System.gc();
        Thread.sleep(500);
        if (ASVE_HOOK!=null){
            ASVE_HOOK.isAlive();
        }else {
            System.out.println("no i am dead");
        }
        ASVE_HOOK=null;
        System.gc();
        Thread.sleep(500);
        if (ASVE_HOOK!=null){
            ASVE_HOOK.isAlive();
        }else {
            System.out.println("no i am dead");
        }
    }
}
