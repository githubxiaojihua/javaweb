package com.xiaojihua.serviceImpl;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.dao.ICategoryDao;
import com.xiaojihua.daoImpl.CategoryDaoImpl;
import com.xiaojihua.domain.CateGory;
import com.xiaojihua.service.ICategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    /**
     * 查询所有类目
     * @return
     */
    @Override
    public EasyuiPageBean<CateGory> findCategory(String page,String rows) throws SQLException {
        int pageNumber = 1;
        int pageSize = 5;
        if(page != null && !"".equals(page)){
            pageNumber = Integer.parseInt(page);
        }
        if(rows != null && !"".equals(rows)){
            pageSize = Integer.parseInt(rows);
        }
        EasyuiPageBean pageBean = new EasyuiPageBean(pageNumber,pageSize);
        ICategoryDao dao = new CategoryDaoImpl();
        EasyuiPageBean<CateGory> cateGories = dao.findCategory(pageBean);
        cateGories.setTotal(dao.recordCount());
        return cateGories;
    }

    /**
     * 根据cid删除类目
     * @param cid
     * @throws SQLException
     */
    @Override
    public void deleteByCid(String cid) throws SQLException {
        ICategoryDao dao = new CategoryDaoImpl();
        dao.deleteByCid(cid);
    }
}
