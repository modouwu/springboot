package com.example.hiberate.designPattern.Composite.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends AbstractFile{
    private List<AbstractFile> abstractFileList=new ArrayList<>();
    private String name;
    @Override
    void setName(String name) {
        this.name=name;
    }

    @Override
    void add(AbstractFile abstractFile) {
        this.abstractFileList.add(abstractFile);
    }

    @Override
    void remove(AbstractFile abstractFile) {
        abstractFileList.remove(abstractFile);
    }

    @Override
    AbstractFile getChild(int i) {
        return abstractFileList.get(i);
    }

    @Override
    void operation() {
        System.out.println("对文件夹"+this.name+"进行处理");
        abstractFileList.forEach(AbstractFile::operation);
    }
}
