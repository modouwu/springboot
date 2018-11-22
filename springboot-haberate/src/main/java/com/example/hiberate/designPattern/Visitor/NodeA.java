package com.example.hiberate.designPattern.Visitor;

public class NodeA extends Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String operation() {
        return "nodeA operation";
    }
}
