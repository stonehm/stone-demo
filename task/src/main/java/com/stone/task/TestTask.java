package com.stone.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class TestTask {
    private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0/10 * *  * * ? ")   //每10秒执行一次
    public void test() {
        System.out.println(sdf.format(new Date()) + "A1");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sdf.format(new Date()) + "A2");
    }

    @Scheduled(cron = "0/10 * *  * * ? ")   //每10秒执行一次
    public void test1() {
        System.out.println(sdf.format(new Date()) + "B1");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sdf.format(new Date()) + "B2");
    }

    @Scheduled(cron = "0/5 * *  * * ? ")   //每10秒执行一次
    public void test2() {
        System.out.println(sdf.format(new Date()) + "C");
    }

}
