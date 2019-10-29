package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaojihua.struts.domain.User;
import sun.rmi.transport.ObjectTable;

import java.util.List;
import java.util.Map;

/**
 * 测试struts属性封装----复杂类型 list map
 *
 */
public class ActionDemo13 extends ActionSupport{

    List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    Map<String,User> map;

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String execute() throws Exception{
        //测试是否封装好了数据---list
        /*for(User user : list){
            System.out.println(user);
        }*/

        //测试是否封装好了数据---map
        for(String key : map.keySet()){
            System.out.println(key + ":" + map.get(key));
        }
        return null;
    }

}
