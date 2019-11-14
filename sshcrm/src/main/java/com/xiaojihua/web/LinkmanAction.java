package com.xiaojihua.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaojihua.bean.PageBean;
import com.xiaojihua.domain.Customer;
import com.xiaojihua.domain.Linkman;
import com.xiaojihua.service.CustomerService;
import com.xiaojihua.service.LinkmanService;
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

@Controller("linkmanAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {

    //模型区域
    private Linkman linkman = new Linkman();
    @Override
    public Linkman getModel() {
        return linkman;
    }
    //IOC区域
    @Autowired
    private CustomerService service;
    @Autowired
    private LinkmanService linkmanService;
    //值栈属性存值区域
    private List<Customer> customerList;
    private List<Linkman> linkmanList;
    private Linkman linkmanFind;
    private PageBean<Linkman> page;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Linkman> getLinkmanList() {
        return linkmanList;
    }

    public Linkman getLinkmanFind() {
        return linkmanFind;
    }

    public PageBean<Linkman> getPage() {
        return page;
    }
    //属性赋值区域
    private int pageNumber = 1;
    private int pageSize = 3;

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 跳转到新增联系人页面
     * @return
     */
    @Action(value="linkman_addUI",results={@Result(name="addUI",location="/jsp/linkman/add.jsp")})
    public String addUI(){
        /*步骤:
         * 1  获取所有的客户  list
         * 2 把封装好的list放在值栈中 带到add.jsp页面显示到下拉框中
         * */
        customerList = service.find();
        return "addUI";
    }

    /**
     * 保存联系人
     * @return
     */
    @Action(value="linkman_add",results={@Result(name="toAction",type="redirectAction",location="linkman_find")})
    public String add(){
        /*步骤:
         *  1 将modelDriver封装的对象数据进行传递
         *  2 保存完毕,执行list方法 查询最新数据到页面展示
         *
         * */
        linkmanService.save(linkman);
        return "toAction";
    }


    /**
     * 菜单和功能按钮共用一个方法
     */
    @Action(value="linkman_find",results={@Result(name="toList",location="/jsp/linkman/list.jsp")})
    public String find(){

        /*步骤:
		 * 1 查询所有的客户 返回的是list
		 * 2 将list放在值栈中 带到list.jsp页面显示到条件查询的下拉列表中
         * 3 将联系人的数据全查 返回的list
		 * 4 将联系人的list放在值栈中 带到list.jsp页面展示联系人的信息
         **/
        customerList = service.find();
        /*linkmanList = linkmanService.find();*/

        //使用离线查询实现公用一个方法
        DetachedCriteria dc = DetachedCriteria.forClass(Linkman.class);
        //查询条件不为空则设置查询条件，不过不判断会出错
        if(linkman.getLkm_name() != null){
            dc.add(Restrictions.like("lkm_name","%" + linkman.getLkm_name() + "%"));
        }
        if(linkman.getCustomer() != null && linkman.getCustomer().getCust_id() != -1){
            dc.add(Restrictions.eq("customer.cust_id",linkman.getCustomer().getCust_id()));
        }
        linkmanList = linkmanService.findByDc(dc);
        return "toList";
    }

    /**
     * 跳转到联系人编辑页面
     * @return
     */
    @Action(value="linkman_editUI",results={@Result(name="editUI",location="/jsp/linkman/edit.jsp")})
    public String editUI(){

        //设置下拉框数据
        customerList = service.find();
        //根据id获取查询的联系人数据，放到值栈中进行显示
        linkmanFind = linkmanService.findById(linkman.getLkm_id());
        return "editUI";
    }

    /**
     * 更新联系人信息
     * @return
     */
    @Action(value="linkman_update",results={@Result(name="toAction",type="redirectAction",location="linkman_find")})
    public String update(){
        linkmanService.update(linkman);
        return "toAction";
    }


    /**
     * 分页查询
     * @return
     */
    @Action(value="linkman_findPage",results={@Result(name="toList",location="/jsp/linkman/listPage.jsp")})
    public String findPage(){
        /*步骤:
         * 1 查询所有的客户 返回的是list
         * 2 将list放在值栈中 带到list.jsp页面显示到条件查询的下拉列表中
         * 3 将联系人的数据全查 返回的list
         * 4 将联系人的list放在值栈中 带到list.jsp页面展示联系人的信息
         **/
        customerList = service.find();
        DetachedCriteria dc = DetachedCriteria.forClass(Linkman.class);
        //设置查询条件
        if(linkman.getLkm_name()!= null){
            dc.add(Restrictions.like("lkm_name","%" + linkman.getLkm_name() + "%"));
        }
        if(linkman.getCustomer()!= null && linkman.getCustomer().getCust_id() != -1){
            dc.add(Restrictions.eq("customer.cust_id",linkman.getCustomer().getCust_id()));
        }
        PageBean<Linkman> pageBean = new PageBean<>(pageNumber,pageSize);
        page = linkmanService.findPage(dc, pageBean);
        return "toList";
    }
}
