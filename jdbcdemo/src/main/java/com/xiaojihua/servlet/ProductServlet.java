package com.xiaojihua.servlet;

import com.xiaojihua.bean.Product;
import com.xiaojihua.service.ProductService;
import com.xiaojihua.utils.DataSourcesUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProductServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if("findAll".equalsIgnoreCase(method)){
            findAll(request,response);
        }
        if("addUI".equalsIgnoreCase(method)){
            addUI(request,response);
        }
        if("add".equalsIgnoreCase(method)){
            add(request,response);
        }
        if("edit".equals(method)){
            edit(request,response);
        }
        if("update".equals(method)){
            update(request,response);
        }
        if("delete".equals(method)){
            deletePro(request,response);
        }
        if("delSel".equals(method)){
            deleteSel(request,response);
        }
        if("select".equals(method)){
            select(request,response);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response){
        ProductService service = new ProductService();
        try {
            List<Product> pros = service.findAll();
            request.setAttribute("list",pros);
            request.getRequestDispatcher("/list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/product.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //int i = 1/0;
            Map<String,String[]> proMap = request.getParameterMap();
            Product pro = new Product();
            BeanUtils.copyProperties(pro,proMap);
            pro.setPid(UUIDCLS.getUUID());
            pro.setPdate(new Date().toLocaleString());
            ProductService service = new ProductService();
            service.add(pro);
            request.getRequestDispatcher("/product?method=findAll").forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "添加商品失败");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取id
            String id = request.getParameter("id");
            //调用方法查询pro
            ProductService ps = new ProductService();
            Product pro=ps.getProByPid(id);

            //把pro放入request中
            request.setAttribute("pro", pro);
            //请求转发到edit.jsp
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "查询单条记录商品失败");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取map
            Map<String, String[]> map = request.getParameterMap();
            //创建bean
            Product pro = new Product();
            //把map中的数据拷贝到bean中
            BeanUtils.populate(pro, map);
            //调用service完成数据更新
            ProductService ps = new ProductService();
            ps.updatePro(pro);
            //请求转发到查询所有商品的链接上
            request.getRequestDispatcher("/product?method=findAll").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            request.setAttribute("msg", "更新商品失败");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private void deletePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取pid
            String pid = request.getParameter("pid");
            //调用service和dao完成删除商品操作
            ProductService ps = new ProductService();
            ps.deletePro(pid);

            //请求转发到查询所有的链接上
            request.getRequestDispatcher("/product?method=findAll").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            request.setAttribute("msg", "删除商品失败");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private void deleteSel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String[] ids = request.getParameterValues("id");
            ProductService ps = new ProductService();
            ps.deleteProSel(ids);
            request.getRequestDispatcher("/product?method=findAll").forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msg","批量删除失败！");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String kw = request.getParameter("kw");
        ProductService service = new ProductService();
        try {
            List<Product> list = service.select(name,kw);
            request.setAttribute("list",list);
            request.setAttribute("name",name);
            request.setAttribute("kw",kw);
            request.getRequestDispatcher("/list.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "更新商品失败");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
