package com.example.hiberate.designPattern.Bridge;

import com.example.hiberate.designPattern.Color;

public abstract class Shape {
    //桥接模式:用一个类实现画不同颜色不同形状的图形,这里有两个改变因素,放到一个抽象类里,
    // 这样客户端对于具体的实现不敏感,实现了解耦

    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
