package com.xiaojihua.domain;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象，不往数据库中存
 */
public class Cart {

    //购物项，key用pid来设置，这样方便
    //选用map的原因是通过key来获取某个商品的时候方便
    //选用linkedHashMap的原因是为了保证速度的同时，保证购物项的顺序
    private Map<String,CartItem> items = new LinkedHashMap<>();
    //总金额
    private double total;

    /**
     * 只提供get方法
     * @return
     */
    public Map<String, CartItem> getItems() {
        return items;
    }

    /**
     * 只提供get方法
     * @return
     */
    public double getTotal() {
        return total;
    }

    //===购物车的方法有添加、删除和清空。不提供设置Total的方法（安全），
    //total的设置在这三个方法中

    /**
     * 往购物车中增加购物项
     * @param item
     */
    public void add(CartItem item){
        String key = item.getProduct().getPid();
        //判断item是已经存在
        if(items.containsKey(key)){
            //存在，则根据key找到对应的购物项，并将其count增加item.count，
            // 然后计算total = total + item.subTotal
            CartItem mapItem = items.get(key);
            mapItem.setCount(mapItem.getCount() + item.getCount());
        }else{
            //不存在，则增加到map中，并计算total = total + item.subTotal
            items.put(key,item);
        }
        total += item.getSubTotal();

    }

    /**
     * 删除购物车中的购物项
     * @param pid
     */
    public void remove(String pid){
        //从map中删除项目
        CartItem item = items.remove(pid);
        //重新设置total值
        total -= item.getSubTotal();
    }

    /**
     * 清空购物车
     */
    public void clear(){
        items.clear();
        total = 0;
    }

}
