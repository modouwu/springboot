package com.example.hiberate.designPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements Observerable{
    private List<Observer> list=new ArrayList<>();
    private String message;

    public void changeMessage(String newMessage){
        this.message=newMessage;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObserver() {
        list.forEach(observer -> observer.update(message));
    }
}
