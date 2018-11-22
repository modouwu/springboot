package com.example.hiberate.designPattern.AbstractFactory;

import com.example.hiberate.designPattern.Color;
import com.example.hiberate.designPattern.Shape;

public abstract class AbstractFactory {
    //为 Color 和 Shape 对象创建抽象类来获取工厂。
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
