package com.xiaojihua.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通过使用json-lib将java相关对象转换成json
 * 主要包括JSONArray和JSONObject两个对象
 * 前一个是用来转换数组或者是list的
 * 后一个是用来转换map或者是javaBean的
 */
public class JsonTest {

    @Test
    public void t1(){
        String[] x = {"aa","bb","cc"};
        JSONArray jsonArray = JSONArray.fromObject(x);
        System.out.println(jsonArray);
    }

    @Test
    public void t2(){
        List<String> list = new ArrayList<>();
        list.add("XX");
        list.add("YY");
        list.add("ZZ");
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
    }

    @Test
    public void t3(){
        Map<String,String> map = new HashMap<>();
        map.put("ii","II");
        map.put("jj","JJ");
        map.put("qq","QQ");
        JSONObject jsonObject = JSONObject.fromObject(map);
        System.out.println(jsonObject);
    }

    @Test
    public void t4(){
        User user = new User("zhangsan","1243");
        JSONObject jsonObject = JSONObject.fromObject(user);
        System.out.println(jsonObject);
    }
}
