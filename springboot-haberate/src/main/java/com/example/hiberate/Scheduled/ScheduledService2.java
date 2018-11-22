package com.example.hiberate.Scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component public class ScheduledService2 {
    @Scheduled(fixedRate = 1000)//这个注解必须注入到容器才会生效
    public void testFixedRate() {
        System.out.println("执行定时任务2");
    }
}
