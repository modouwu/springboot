package com.example.hiberate.designPattern.Observer;

public class UserObserver implements Observer {
    private String name;
    public void setName(String name){
        this.name=name;
    }
    @Override
    public void update(String message) {
        System.out.println(name+":收到一条信息:"+message);
    }
}
