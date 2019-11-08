package com.xiaojihua.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaojihua.domain.BaseDict;
import com.xiaojihua.domain.Customer;
import com.xiaojihua.service.CustomerService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@ParentPackage("struts-default")
@Namespace("/")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    //模型区域
    private Customer customer = new Customer();
    @Override
    public Customer getModel() {
        return customer;
    }

    //IOC区域
    @Autowired
    private CustomerService service;

    //值栈属性存值区域
    private List<BaseDict> levelList;
    private List<BaseDict> sourceList;
    private List<BaseDict> industryList;
    public List<BaseDict> getLevelList() {
        return levelList;
    }
    public List<BaseDict> getSourceList() {
        return sourceList;
    }
    public List<BaseDict> getIndustryList() {
        return industryList;
    }

    //方法区域

    /**
     * 跳转到新增客户页面
     * 查询出客户级别、信息来源、所属行业等数据在页面显示
     * @return
     */
    @Action(value="customer_addUI",results={@Result(name="addUI",location="/jsp/customer/add.jsp")})
    public String addUI(){
        /*步骤分析:
         *  1 查询所有客户级别数据 006  返回的是list
         *  2 查询所有信息来源数据 002  返回的是list
         *  3 查询所有所属行业数据 001 返回的是list
         *  4 把查询的三个list放在值栈中 到add.jsp页面把数据显示到下拉框中
         * */
        levelList = service.findCode("006");
        sourceList = service.findCode("002");
        industryList = service.findCode("001");
        //4 放在值栈中   1  成员属性  2 ValueStack的api:push()，这里采用第一种方式
        return "addUI";
    }

    /**
     * 保存客户
     * @return
     */
    @Action(value="customer_save",results={@Result(name="toList",location="/jsp/customer/list.jsp")})
    public String save(){
        service.save(customer);
        return "toList";
    }

}
