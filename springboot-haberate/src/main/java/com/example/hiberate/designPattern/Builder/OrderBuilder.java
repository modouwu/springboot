package com.example.hiberate.designPattern.Builder;

import com.example.hiberate.designPattern.Burger;
import com.example.hiberate.designPattern.Order;
import com.example.hiberate.designPattern.Suit;

public class OrderBuilder {
    private Burger mBurger;
    private Suit mSuit;
    private Integer mPrice;

    //通过static方法,来提供构造器的入口,同时提供初始化参数入口,初始化int
    public static OrderBuilder newBuilder(Integer mPrice){
        return new OrderBuilder(mPrice);
    }
   /* public static OrderBuilder newBuilder(){
        return new OrderBuilder();
    }*/

    public OrderBuilder(Integer price){
        mPrice=price;
    }

    public OrderBuilder(){
    }

    //单点汉堡,num为数量
    public OrderBuilder burger(Burger burger, int num){
        mBurger = burger;
        mPrice=mPrice+num;
        return this;
    }

    //点套餐，实际中套餐也可以点多份
    public OrderBuilder suit(Suit suit, int num){
        mSuit = suit;
        mPrice=mPrice+num;
        return this;
    }

    //完成订单,在build时可以做校验，如果不满足必要条件，则可以直接抛出创建异常
    public Order build() throws Exception {
        Order order = new Order();
        order.setBurger(mBurger);
        order.setSuit(mSuit);
        order.setPrice(mPrice);
        if(order.getPrice() < 30){
            throw new Exception("订单金额未达到30元");
        }
        return order;
    }
}
