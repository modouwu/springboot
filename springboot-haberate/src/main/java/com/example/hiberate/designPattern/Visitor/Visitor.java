package com.example.hiberate.designPattern.Visitor;

public interface Visitor {
    /**
     * 对应于NodeA的访问操作
     */
    void visit(NodeA node);
    /**
     * 对应于NodeB的访问操作
     */
    void visit(NodeB node);
}
