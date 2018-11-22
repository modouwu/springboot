package com.example.hiberate.designPattern.Composite.composite;

public class ImageFile extends AbstractFile {
    private String name;
    @Override
    void setName(String name) {
        this.name=name;
    }

    @Override
    void add(AbstractFile abstractFile) {
        System.out.println("对不起,不支持该方法;");
    }

    @Override
    void remove(AbstractFile abstractFile) {
        System.out.println("对不起,不支持该方法;");
    }

    @Override
    AbstractFile getChild(int i) {
        System.out.println("对不起,不支持该方法;");
        return null;
    }

    @Override
    void operation() {
        System.out.println("对图像文件"+this.name+"进行处理");
    }
}
