package com.example.hiberate.designPattern.State;

public class Client {
    public static void main(String[] args) {
       //状态模式作用,主要是为了替换if-else以及switch-case条件分支语句;
       //如果直接在state里的各个方法里写if-else对条件进行判断,那么会造成逻辑不清,代码冗余,
        // 如果新增一个状态或者方法行为, 会很麻烦,扩展性不好.但是如果条件分支很简单,无需用状态模式,会造成结构复杂

        TVController controller = new TVController();
        controller.powerOn();
        controller.nextChannel();
        controller.turnUp();
        controller.powerOff();
        controller.prevChannel();
    }
}
