package com.example.hiberate.designPattern.State;

public class PowerOnState implements TVState {
    @Override
    public void nextChannel() {
        System.out.println("跳转到下一个频道");
    }

    @Override
    public void prevChannel() {
        System.out.println("跳转到上一个频道");
    }

    @Override
    public void trunUp() {
        System.out.println("音量增加");
    }

    @Override
    public void trunDown() {
        System.out.println("音量减少");
    }
}
