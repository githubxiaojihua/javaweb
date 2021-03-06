package com.xiaojihua.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaojihua.domain.Customer;
import com.xiaojihua.service.ICustomerService;
import com.xiaojihua.serviceImpl.CustomerServiceImp;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    /**
     * 通过成员属性的方式将查询出来的list放到值栈中，然后在页面
     * 通过ognl表达式获取
     */
    private List<Customer> list;

    public List<Customer> getList() {
        return list;
    }

    /**
     * 查询所有客户列表
     * @return
     */
    public String findAll(){
        ICustomerService service = new CustomerServiceImp();
//        List<Customer> all = service.findAll();
        //放到域中
        /*HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list",all);*/

        //设置了已经放到值栈中的List
        list = service.findAll();

        return SUCCESS;
    }

    /**
     * 跳转到增加客户页面
     * @return
     */
    public String addUI(){
        return "addUI";
    }

    /**
     * 增加客户信息，增加完成后需要跳转到客户列表，
     * 因此进行请求转发到action（客户列表的action)
     * @return
     */
    public String add(){
        ICustomerService service = new CustomerServiceImp();
        service.add(customer);
        return "toAction";
    }

}
