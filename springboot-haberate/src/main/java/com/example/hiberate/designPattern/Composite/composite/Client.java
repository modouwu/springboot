package com.example.hiberate.designPattern.Composite.composite;

public class Client {
    public static void main(String[] args){
        //组合模式，就是在一个对象中包含其他对象，这些被包含的对象可能是终点对象（不再包含别的对象），
        // 也有可能是非终点对象（其内部还包含其他对象，或叫组对象），
        // 我们将对象称为节点，即一个根节点包含许多子节点，这些子节点有的不再包含子节点，而有的仍然包含子节点
        //业务方法,通过递归处理
        ImageFile imageFile=new ImageFile();
        imageFile.setName("image1");
        TextFile textFile=new TextFile();
        textFile.setName("text1");
        Folder folder1=new Folder();
        folder1.setName("folder1");
        Folder folder2=new Folder();
        folder2.setName("folder2");
        folder1.add(folder2);
        folder1.add(imageFile);
        folder2.add(textFile);
        folder2.add(imageFile);
        folder1.operation();
    }
}
