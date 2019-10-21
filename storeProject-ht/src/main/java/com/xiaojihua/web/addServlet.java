package com.xiaojihua.web;

import com.xiaojihua.domain.CateGory;
import com.xiaojihua.domain.Product;
import com.xiaojihua.service.IProductService;
import com.xiaojihua.serviceImpl.ProductServiceImpl;
import com.xiaojihua.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 由于牵扯到上传文件的读取，页面表单的enctype改变为multitype
 * 原来的三种获取页面数据的方式失效，因此不能再从baseServlet中
 * 继承
 */
public class addServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response){
        //通过文件上传的方式来获取页面的所有数据
        try {
            //1、构造磁盘文件工厂
            DiskFileItemFactory disk = new DiskFileItemFactory();
            //2、根据工厂创建文件上传对象
            ServletFileUpload upload = new ServletFileUpload(disk);
            //3、使用上传对象解析请求
            List<FileItem> fileItems = upload.parseRequest(request);
            //用于存放页面数据的
            Map<String,Object> paramaters = new HashMap<>();
            for(FileItem fi : fileItems){
                //4、根据数据类型，如果是普通类型则将其封装到一个map里面
                if(fi.isFormField()){
                   String key = fi.getFieldName();
                   String value = fi.getString("utf-8");
                   paramaters.put(key,value);
                }else{
                    //5、如果是上传类型则进行上传，最终将文件路径保存到product中
                    //获取文件名称
                    String fileName = new String(fi.getName().getBytes(),"utf-8");
                    //得到上传文件的输入流
                    InputStream is = fi.getInputStream();
                    //构建存放路径
                    String path = getServletContext().getRealPath("/products/1");
                    FileOutputStream os = new FileOutputStream(path + "/" + fileName);
                    //将文件拷贝到服务器中
                    IOUtils.copy(is,os);
                    //关闭流
                    os.close();
                    is.close();
                    paramaters.put("pimage","products/1/" + fileName);
                }
            }
            //6、将得到的map参数拷贝到Product对象中
            Product product = new Product();
            BeanUtils.populate(product,paramaters);
            product.setPid(UUIDUtils.getUUID());
            product.setPflag(0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(new Date());
            product.setPdate(date);
            // 分类
            CateGory category = new CateGory();
            category.setCid(paramaters.get("cid").toString());
            // 分类在给product
            product.setCategory(category);
            //7、调用service保存product对象
            IProductService service = new ProductServiceImpl();
            service.saveProduct(product);
            //8、给easyui反馈
            response.getWriter().print("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        doGet(request,response);
    }
}
