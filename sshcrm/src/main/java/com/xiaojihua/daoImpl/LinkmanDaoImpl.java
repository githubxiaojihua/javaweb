package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.LinkmanDao;
import com.xiaojihua.domain.Linkman;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("linkmanDao")
public class LinkmanDaoImpl implements LinkmanDao {

    @Autowired
    private HibernateTemplate template;

    @Override
    public void save(Linkman linkman) {
        template.save(linkman);
    }

    @Override
    public List<Linkman> find() {
        return (List<Linkman>)template.find("from Linkman");
    }

    @Override
    public List<Linkman> findByDc(DetachedCriteria dc) {
        return (List<Linkman>)template.findByCriteria(dc);
    }

    @Override
    public Linkman findById(Long id) {
        return template.get(Linkman.class,id);
    }

    @Override
    public void update(Linkman linkman) {
        template.update(linkman);
    }

    @Override
    public List<Linkman> findPage(DetachedCriteria dc, int start, int pageSize) {
        dc.setProjection(null);
        return (List<Linkman>)template.findByCriteria(dc,start,pageSize);
    }

    @Override
    public int findCount(DetachedCriteria dc) {
        dc.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>)template.findByCriteria(dc);
        return list.get(0).intValue();
    }
}
