package com.example.hiberate.designPattern.Bridge;

public class Circle extends Shape {
    @Override
    public void draw() {
        color.fill();
        System.out.println("this is circle");
    }
}
