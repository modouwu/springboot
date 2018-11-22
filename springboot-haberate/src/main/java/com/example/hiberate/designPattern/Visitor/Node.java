package com.example.hiberate.designPattern.Visitor;

public abstract class Node {
    public abstract void accept(Visitor visitor);
    public abstract String operation();
}
