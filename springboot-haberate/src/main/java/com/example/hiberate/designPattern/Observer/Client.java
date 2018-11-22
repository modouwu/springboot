package com.example.hiberate.designPattern.Observer;

public class Client {
    public static void main(String[] args){
        WechatServer observerable=new WechatServer();
        UserObserver zhangsan=new UserObserver();
        zhangsan.setName("zhangsan");
        UserObserver lisi=new UserObserver();
        zhangsan.setName("lisi");
        observerable.registerObserver(zhangsan);
        observerable.registerObserver(lisi);
        observerable.changeMessage("我发布新文章了");
    }
}
