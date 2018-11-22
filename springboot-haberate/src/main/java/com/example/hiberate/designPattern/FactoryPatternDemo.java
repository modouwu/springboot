package com.example.hiberate.designPattern;

import com.example.hiberate.designPattern.AbstractFactory.AbstractFactory;
import com.example.hiberate.designPattern.AbstractFactory.ColorFactory;
import com.example.hiberate.designPattern.AbstractFactory.FactoryProducer;
import com.example.hiberate.designPattern.Bridge.Circle;
import com.example.hiberate.designPattern.Builder.OrderBuilder;
import com.example.hiberate.designPattern.Factory.ShapeFactory;
import com.example.hiberate.designPattern.Filter.*;
import com.example.hiberate.designPattern.Singleton.SingleObject;

import java.util.ArrayList;
import java.util.List;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        //1.静态工厂方法
        ShapeFactory shapeFactory=new ShapeFactory();
        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();

        //2.抽象工厂方法
        //这里的AbstractFactory也可以不使用,直接通过下面语句直接调用
        Color red=new ColorFactory().getColor("red");
        //获取形状工厂
        AbstractFactory shapeFactory2 = FactoryProducer.getFactory("SHAPE");
        //获取形状为 Circle 的对象
        Shape shape2 = shapeFactory2.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape2.draw();
        //获取形状为 Rectangle 的对象
        Shape shape3 = shapeFactory2.getShape("RECTANGLE");
        //调用 Rectangle 的 draw 方法
        shape3.draw();
        //获取颜色工厂

        //3.单例模式
        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();
        //显示消息
        object.showMessage();

        //4.建造者模式
        OrderBuilder orderBuilder=OrderBuilder.newBuilder(15);
        try {
            Order order = orderBuilder.burger(new Burger(),5)
            .suit(new Suit(),10)
            .build();
            System.out.println(order.getPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5.桥接模式:实现系统可能有多个角度分类，每一种角度都可能变化，那么把这种多角度分类给分离出来让他们独立变化，减少他们之间耦合
        com.example.hiberate.designPattern.Bridge.Shape shape5=new Circle();
        shape5.setColor(new Blue());
        shape5.draw();

        //6.过滤模式:
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Male"));
        persons.add(new Person("Female"));
        persons.add(new Person("Single"));
        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria singleMale = new AndCriteria(male, female);
        Criteria singleOrFemale = new OrCriteria(male, female);
        male.meetCriteria(persons);
        female.meetCriteria(persons);
        singleMale.meetCriteria(persons);
        singleOrFemale.meetCriteria(persons);

        //7.组合模式
        //8.装饰器模式(代理模式 非常相似)
        //9.



    }
}
