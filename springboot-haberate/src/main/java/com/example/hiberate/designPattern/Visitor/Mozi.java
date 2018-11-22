package com.example.hiberate.designPattern.Visitor;

public class Mozi {
    public void ride(Horse h){
        System.out.println("骑马");
    }

    public void ride(WhiteHorse wh){
        System.out.println("骑白马");
    }

    public void ride(BlackHorse bh){
        System.out.println("骑黑马");
    }

    public void moziEat(Horse2 horse2){
        horse2.eat();
    }

    public void moziEat(WhiteHorse2 horse2){
        horse2.eat();
    }

    public static void main(String[] args) {
        //静态分派(Static Dispatch)发生在编译时期，分派根据静态类型信息发生。静态分派对于我们来说并不陌生，
        // 方法重载就是静态分派
        //怎么判断?调用者是单一类,有多个不同参数的方法,没有继承实现等层次

        Horse wh = new WhiteHorse();//静态类型是Horse 动态类型是whiteHorse
        Horse bh = new BlackHorse();
        Mozi mozi = new Mozi();
        mozi.ride(wh);
        mozi.ride(bh);

        WhiteHorse wh2 = new WhiteHorse();
        BlackHorse bh2 = new BlackHorse();
        mozi.ride(wh2);
        mozi.ride(bh2);

        //动态分派 方法的重写支持动态分派,此时调用者涉及继承
        Horse2 horse2=new WhiteHorse2();
        horse2.eat();

        mozi.moziEat(horse2);//不管有沒有moziEat(WhiteHorse2 horse2),走的都是moziEat(Horse2 horse2),
        //因为此时没有方法的重写,单个时可以看成是特殊的方法重载,通过debug可以看到穿进去的真实类型为WhiteHorse.
        //然后执行horse2.eat,此时涉及方法的重写了,调用真实类型的eat方法
    }

    interface Horse{}
    static class WhiteHorse implements Horse{
        WhiteHorse(){
        }
    }
    static class BlackHorse implements Horse{
        BlackHorse(){
        }
    }

    static class Horse2{
        public void eat(){
            System.out.println("马吃草");
        }
    }

    static class WhiteHorse2 extends Horse2{
        @Override
        public void eat(){
            System.out.println("bai马吃草");
        }
    }

    static class BlackHorse2 extends Horse2{
        @Override
        public void eat(){
            System.out.println("hei马吃草");
        }
    }

}
