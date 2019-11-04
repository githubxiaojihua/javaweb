package com.xiaojihua.serviceImp;


import com.xiaojihua.service.Car;
import com.xiaojihua.service.Person;

public class PersonImpl implements Person
{
	private String name;
	private Car car;
	public void setName(String name) {
		this.name = name;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "PersonImpl [name=" + name + ", car=" + car + "]";
	}
	
	
	
}
