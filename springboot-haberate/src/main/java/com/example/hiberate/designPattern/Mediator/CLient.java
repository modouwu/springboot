package com.example.hiberate.designPattern.Mediator;

public class CLient {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        //中介者模式,这里如果sendMessage参数包含两个实现USER接口的类user1,user2,那么如果在各自的user1,user2类里写上各自
        //的sendMessage方法,那么如果需要再扩展sendMessage给user3,user4,那么每个实现类user1,user2都要修改代码,通过一个
        //中介类,可以只修改中介类,降低偶合

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
