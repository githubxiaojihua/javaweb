package com.xiaojihua.servlet;

import java.util.UUID;

/**
 * 使用java自身工具类获取UUID
 */
public class UUIDCLS {
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","").toUpperCase();
    }
}
