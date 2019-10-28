package com.xiaojihua.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaojihua.domain.Customer;
import com.xiaojihua.service.ICustomerService;
import com.xiaojihua.serviceImpl.CustomerServiceImp;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CustomerAction extends ActionSupport {

    public String findAll(){
        ICustomerService service = new CustomerServiceImp();
        List<Customer> all = service.findAll();
        //放到域中
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list",all);
        return SUCCESS;
    }
}
