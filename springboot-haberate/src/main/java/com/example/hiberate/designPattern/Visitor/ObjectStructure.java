package com.example.hiberate.designPattern.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<Node> nodes = new ArrayList<Node>();

    public void add(Node node){
        nodes.add(node);
    }

    public void action(Visitor visitor){
        nodes.forEach(node -> {
            node.accept(visitor);
            //visitor.visit(node);
        });
    }
}
