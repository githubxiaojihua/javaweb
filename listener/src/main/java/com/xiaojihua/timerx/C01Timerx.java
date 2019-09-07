package com.xiaojihua.timerx;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * java定时器的使用
 */
public class C01Timerx {
    public static void main(String[] args){
        Date date = new Date();
        System.out.println("当前时间是：" + date.toLocaleString());

        Timer timer = new Timer();
        //四秒后每隔一秒执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                System.out.println("当前时间是：" + date.toLocaleString());
            }
        },4000,1000);


    }
}
