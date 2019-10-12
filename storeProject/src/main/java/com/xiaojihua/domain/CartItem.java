package com.xiaojihua.domain;

/**
 * 购物项，不往数据库中存
 */
public class CartItem {
    //商品对象
    private Product product;
    //商品数量
    private Integer count;
    //商品小计
    private double subTotal;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 自定义小计算法
     * @return
     */
    public double getSubTotal() {
        return product.getShop_price() * count;
    }

    /**
     * 不允许对外暴露设置小计金额（为了安全）
     */
    /*public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }*/
}
