package com.xiaojihua.servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 解决请求乱码的几种方式：
 *
 * 浏览器通常使用UTF-8进行编码，但是服务器通常使用ISO8859-1进行解码，
 *
 */
public class C16LuanMaDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "汤姆";
        System.out.println(s);
        //模拟浏览器
        String s1 = URLEncoder.encode(s, "utf-8");
        System.out.println(s1);
        //模拟服务器
        String s2 = URLDecoder.decode(s1, "iso-8859-1");
        System.out.println(s2);

        //第一种方式
        //使用iso-8859-1编码
        String s3 = URLEncoder.encode(s2, "iso-8859-1");
        System.out.println(s3);
        //使用utf-8解码
        String s4 = URLDecoder.decode(s3, "utf-8");
        System.out.println(s4);

        //第二种方式
        //把乱码的数据打成iso-8859-1的字节数组
        byte[] bytes = s2.getBytes("iso-8859-1");
        //在把字节数组使用utf-8的编码方式重新组装成字符串
        String s5 = new String(bytes, "utf-8");
        System.out.println(s5);
        //简写方式
        String s6 = new String(s2.getBytes("iso-8859-1"), "utf-8");
        System.out.println("s6="+s6);
    }
}
