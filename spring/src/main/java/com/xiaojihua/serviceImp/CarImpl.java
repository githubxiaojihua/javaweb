package com.xiaojihua.serviceImp;


import com.xiaojihua.service.Car;

public class CarImpl implements Car
{
	
	private String name;
	private double price;
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	// 有参构造 --方便di的构造器注入方式
	public CarImpl(String name,double price)
	{
		this.name=name;
		this.price=price;
	}
	public CarImpl(){}
	

	@Override
	public void run() {
		System.out.println("价格:"+price+"钱的"+name+"车跑起来了...");
		
	}
	@Override
	public String toString() {
		return "CarImpl [name=" + name + ", price=" + price + "]";
	}
	
	

}
