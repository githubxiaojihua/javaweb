package com.xiaojihua;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * redis连接池工具类
 * 通过配置文件配置相关参数
 */
public class JedisPoolUtils {
    //相关参数
    private static String host;
    private static int port;
    private static int maxTotal;
    private static int maxIdel;
    private static int maxWaitMill;
    private static JedisPoolConfig config = null;
    private static JedisPool pool =null;

    static{
        //新建配置对象
        config = new JedisPoolConfig();
        //加载配置文件
        ResourceBundle resource = ResourceBundle.getBundle("com/xiaojihua/jedis");
        //读取配置文件中的值并且设置相关属性
        config.setMaxWaitMillis(Integer.parseInt(resource.getString("maxWaitMillis")));
        config.setMaxTotal(Integer.parseInt(resource.getString("maxTotal")));
        config.setMaxIdle(Integer.parseInt(resource.getString("maxIdle")));

        String host = resource.getString("host");
        int port = Integer.parseInt(resource.getString("port"));
        //设置连接池
        pool = new JedisPool(config,host,port);
    }

    /**
     * 提供公共方法从连接池中返回Jedis引用
     * @return
     */
    static public Jedis getJedis(){
        return pool.getResource();
    }
}
