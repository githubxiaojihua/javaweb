package com.xiaojihua.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CollBean 
{
	public CollBean()
	{
		System.out.println(11111);
	}
	
	private String[] ss;
	private List ll;
	private Map mm;
	private Properties properties; //键值对
	
	public void setSs(String[] ss) {
		this.ss = ss;
	}
	public void setLl(List ll) {
		this.ll = ll;
	}
	public void setMm(Map mm) {
		this.mm = mm;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}




	@Override
	public String toString() {
		return "CollBean [ss=" + Arrays.toString(ss) + ", ll=" + ll + ", mm=" + mm + ", properties=" + properties + "]";
	}
	
	
	
	
}
