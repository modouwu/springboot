package com.example.hiberate.designPattern.State;

public class TVController {
    TVState state;

    public void setState(TVState state) {
        this.state = state;
    }

    public void powerOn() {
        setState(new PowerOnState());
        System.out.println("开机啦！");
    }

    public void powerOff() {
        setState(new PowerOffsetState());
        System.out.println("关机啦！");
    }

    public void nextChannel() {
        state.nextChannel();
    }

    public void prevChannel() {
        state.prevChannel();
    }

    public void turnUp() {
        state.trunUp();
    }

    public void trunDown() {
        state.trunDown();
    }
}
