package com.xiaojihua;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Test只能在test文件夹中使用，因为在pom.xml中的scope是test
 */
public class JedisTest {

    /**
     * 测试jedis基本功能
     */
    @Test
    public void testJedisSingle(){
        //1、设置redis的服务器地址和端口号
        Jedis jedis = new Jedis("192.168.33.133",6379);
        //2、设置数据
        jedis.set("name","xiaojihua");
        //3、获取数据
        String name = jedis.get("name");
        System.out.println(name);
        //4、释放资源
        jedis.close();
    }

    /**
     * jedis连接池的使用
     */
    @Test
    public void testJedisPool(){
        //1、获取连接池配置对象，设置配置项
        JedisPoolConfig config = new JedisPoolConfig();
        //1.1 设置最大链接数
        config.setMaxTotal(30);
        //1.2设置最大空闲连接数
        config.setMaxIdle(10);
        //1.3设置等待超时时间
        config.setMaxWaitMillis(8000);

        //2、获取连接池对象
        JedisPool pool = new JedisPool(config,"192.168.33.133",6379);
        //3、获取核心对象
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            //4、设置数据
            jedis.set("name","zhangsan");
            //5、获取数据
            String name = jedis.get("name");
            System.out.println(name);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(jedis != null){
                jedis.close();
            }
            //连接池在这里不关闭也可以，服务器（虚拟机）关闭的时候也会关闭
            if(pool != null){
                pool.close();
            }
        }
    }

    @Test
    public void testUtils(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("age","12");
        String age = jedis.get("age");
        System.out.println(age);
        jedis.close();

    }
}
