package com.xiaojihua.serviceImpl;

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
}
