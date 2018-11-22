package com.example.hiberate.designPattern.Visitor;

public class VisitorA implements Visitor {
    @Override
    public void visit(NodeA node) {
        System.out.println(node.operation());
    }

    @Override
    public void visit(NodeB node) {
        System.out.println(node.operation());
    }
    //这里visit方法是方法的重载,是静态分派,在编译期就确定了NODE类型
}
