package com.xiaojihua.servlet;

import com.xiaojihua.bean.Product;
import com.xiaojihua.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProductServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        ProductService service = new ProductService();
        try{
            req.setAttribute("products",service.findAllProduct());
            req.getRequestDispatcher("/list.jsp").forward(req,resp);
        }catch(SQLException exception){
            exception.printStackTrace();
        }catch(IOException exception){
            exception.printStackTrace();
        }catch(ServletException exception){
            exception.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        doGet(req,resp);
    }
}
