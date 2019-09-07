package com.xiaojihua.timerx;

import java.util.Calendar;
import java.util.Date;

public class C02Calenderx {
    public static void main(String[] args){
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.set(Calendar.YEAR,2008);
        ca.set(Calendar.MONTH,8-1);
        ca.set(Calendar.DAY_OF_MONTH,8);
        ca.set(Calendar.HOUR,8);
        ca.set(Calendar.MINUTE,8);
        ca.set(Calendar.SECOND,8);

        System.out.println(ca.getTime().toLocaleString());

    }
}
