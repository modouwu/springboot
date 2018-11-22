package com.example.hiberate.designPattern.Visitor;

public class NodeB extends Node{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String operation() {
        return "nodeB operation";
    }
}
