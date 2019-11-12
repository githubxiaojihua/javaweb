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
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("customerAction")
@Scope(value="prototype")
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
    private List<Customer> customers;
    public Customer customerFind;
    public List<BaseDict> getLevelList() {
        return levelList;
    }
    public List<BaseDict> getSourceList() {
        return sourceList;
    }
    public List<BaseDict> getIndustryList() {
        return industryList;
    }
    public List<Customer> getCustomers() { return customers; }
    public Customer getCustomerFind() {
        return customerFind;
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
    @Action(value="customer_save",results={@Result(name="toAction",type="redirectAction",location="customer_find")})
    public String save(){
        service.save(customer);
        return "toAction";
    }

    /**
     * 查询客户列表
     * @return
     */
    @Action(value="customer_find",results={@Result(name="toList",location="/jsp/customer/list.jsp")})
    public String list(){
        /*步骤:
         * 上集:
         *  1 将条件中的客户级别数据查询出来
         *  2 将条件中的客户来源数据查询出来
         *  3 将条件中的客户行业数据查询出来
         *  4 把查询的数据放在值栈中,带到list.jsp页面显示数据在条件里的下拉框中
         *
         * 下集:
         *   1 将客户数据从数据库中全部查询出来  list
         *   2 将查询出来的list数据放在值栈中,带到list.jsp页面显示所有客户的数据
         * */
        levelList = service.findCode("006");
        sourceList = service.findCode("002");
        industryList = service.findCode("001");
        customers = service.find();
        return "toList";
    }

    /**
     * 条件查询
     * @return
     */
    @Action(value="customer_conditionFind",results={@Result(name="toList",location="/jsp/customer/list.jsp")})
    public String conditionFind(){
        /*步骤:
         *  1 将页面的数据封装给modelDriver的customer对象中
         *  2 离线条件查询 (抛弃了传统的方式 使用hibernate提供的离线对象来完成条件查询)
         *
         * */

        // 获取一个hibernate提供的离线对象
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);//相当于from Customer
        //设置条件
        dc.add(Restrictions.like("cust_name","%" + customer.getCust_name() + "%"));
        if(customer.getCust_level().getDict_id() != -1){
            dc.add(Restrictions.eq("cust_level.dict_id",customer.getCust_level().getDict_id()));
        }
        if(customer.getCust_source().getDict_id() != -1){
            dc.add(Restrictions.eq("cust_source.dict_id",customer.getCust_source().getDict_id()));
        }
        if(customer.getCust_industry().getDict_id() != -1){
            dc.add(Restrictions.eq("cust_industry.dict_id",customer.getCust_industry().getDict_id()));
        }
        customers = service.conditionFind(dc);
        //每个请求都会新建一个ACTION因此要重新赋值
        levelList = service.findCode("006");
        sourceList = service.findCode("002");
        industryList = service.findCode("001");
        return "toList";
    }

    /**
     * 跳转到编辑页面
     * @return
     */
    @Action(value="customer_editUI",results={@Result(name="editUI",location="/jsp/customer/edit.jsp")})
    public String editUI(){
        //每个请求都会新建一个ACTION因此要重新赋值
        levelList = service.findCode("006");
        sourceList = service.findCode("002");
        industryList = service.findCode("001");

        //查询客户信息进行回填
        customerFind = service.findById(customer.getCust_id());
        return "editUI";
    }

    /**
     * 修改后返回列表页
     * @return
     */
    @Action(value="customer_update",results={@Result(name="toAction",type="redirectAction",location="customer_find")})
    public String update(){
        service.update(customer);
        return "toAction";
    }

    /**
     * 删除
     * @return
     */
    @Action(value="customer_delete",results={@Result(name="toAction",type="redirectAction",location="customer_find")})
    public String delete(){
        //OID删除只需要一个ID
        service.delete(customer);
        return "toAction";
    }

}
