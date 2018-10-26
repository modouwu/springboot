package com.example.hiberate.Scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import java.util.Date;

@Controller
public class ScheduledService {
    //@Scheduled(cron = "0 0 0 * * FRI")
    @Scheduled(cron = "0 * * * * *")
    public void testFixedRate() {
        System.out.println("执行定时任务");
    }

    public static void main(String[] args){
        System.out.println(new Date(7943));
        //isImgUrl("http://img.51miz.com/Element/00/71/06/20/3ed40262_E710620_85009118.png!/quality/90/unsharp/true/compress/true/format/png/fh/630");
    }
    public static boolean isImgUrl(String url) {
        if (StringUtils.isEmpty(url)) {
            return false;
        }
        if (-1 != url.indexOf("http://img1.chouti.com")
                || -1 != url.indexOf("http://dohko.img.gozap.com")) {
            return true;
        }
        String prefix = url.substring(url.lastIndexOf(".") + 1);
        if (prefix.toLowerCase().contains("png")) {
            return true;
        }
        return false;
    }
}
