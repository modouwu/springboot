package com.example.hiberate.designPattern.Observer;

public interface Observerable {//被观察者接口
    void registerObserver(Observer o);//给被观察者注册观察者
    void removeObserver(Observer o);//移除观察者
    void notifyObserver();//通知所有观察者
}
