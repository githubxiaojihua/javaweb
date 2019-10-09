package com.xiaojihua.serviceImpl;

import com.xiaojihua.dao.ICategoryDao;
import com.xiaojihua.daoImpl.CategoryImpl;
import com.xiaojihua.domain.Category;
import com.xiaojihua.service.ICategoryService;
import com.xiaojihua.utils.JedisPoolUtils;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    /**
     * 查询所有分类，并将其装换成json
     * @return
     * @throws SQLException
     */
    @Override
    public String findAll() throws SQLException {
        ICategoryDao categoryDao = new CategoryImpl();
        List<Category> categoryList = null;
        String categoryStr = null;
        categoryList = categoryDao.findAll();
        //当转化list和数组的时候使用JSONArray，当转化map或者对象的时候使用JSONObject
        categoryStr = JSONArray.fromObject(categoryList).toString();
        return categoryStr;
    }

    /**
     * 对分类查询进行优化，将查询出来的数据放到redis中
     * 所有人都往redis中查询，如果能查到则返回，
     * 如果查不到则走数据库查询，并将查询的结果放到redis中
     * @return
     * @throws SQLException
     */
    @Override
    public String fromRedis() throws SQLException {
        Jedis jedis = JedisPoolUtils.getJedis();
        String dht = jedis.get("dht");
        if(dht == null){
            dht = this.findAll();
            jedis.set("dht",dht);
            System.out.println("从mysql中拿的！");
            return dht;
        }
        System.out.println("从redis中拿的");
        return dht;
    }
}
