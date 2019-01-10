package com.example.hiberate.jdk8.optional.classLoadTest;

public class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
    //1.main中调用static方法，触发SingleTon的初始化，
    // 类加载过程，准备阶段会先给静态字段初始化，count1=0,count2=0singleTon=null
    //2.然后执行类的其他static语句块，按照代码顺序从前往后执行，
    // 首先执行new SingleTon()，此时会执行构造器方法，
    // 接着执行下面的赋值语句，此时count1没有赋值语句，值仍然为０，count2赋值为０
    //3.最终输出：
    //count1=1
    //count2=0

}
