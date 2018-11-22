package com.example.hiberate.designPattern.Composite.composite;

public abstract class AbstractFile {
    abstract void setName(String name);
    abstract void add(AbstractFile abstractFile);
    abstract void remove(AbstractFile abstractFile);
    abstract AbstractFile getChild(int i);
    abstract void operation();

}
