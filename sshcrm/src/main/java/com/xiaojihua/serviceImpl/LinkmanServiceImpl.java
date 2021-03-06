package com.xiaojihua.serviceImpl;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.dao.LinkmanDao;
import com.xiaojihua.domain.Linkman;
import com.xiaojihua.service.LinkmanService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("linkmanService")
@Transactional
public class LinkmanServiceImpl implements LinkmanService {

    @Autowired
    private LinkmanDao dao;

    @Override
    public void save(Linkman linkman) {
        dao.save(linkman);
    }

    @Override
    public List<Linkman> find() {
        return dao.find();
    }

    @Override
    public List<Linkman> findByDc(DetachedCriteria dc) {
        return dao.findByDc(dc);
    }

    @Override
    public Linkman findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void update(Linkman linkman) {
        dao.update(linkman);
    }

    @Override
    public PageBean<Linkman> findPage(DetachedCriteria dc, PageBean pageBean) {
        //查询并设置总条数
        int totalNumber = dao.findCount(dc);
        pageBean.setTotalNumber(totalNumber);
        //查询并设置数据集
        List<Linkman> linkmanList = dao.findPage(dc, pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(linkmanList);
        return pageBean;
    }
}
