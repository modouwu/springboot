package com.example.hiberate.designPattern.Bridge;

public class Rectangle extends Shape {
    @Override
    public void draw() {
        color.fill();
        System.out.println("this is Rectangle");
    }
}
