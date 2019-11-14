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
        /**
         * 设置为Null主要是因为，service端先调用findCount方法，
         * findCount方法会设置一个Projection。
         * 因为在同一个DC里面因此在调用本方法的时候还会保留，导致
         * hibernate生成的sql还是查询select count(*)这样的，
         * 只有设置null清空projection后才能根据条件生成
         * select * from Linkman where ....这样的
         */
        dc.setProjection(null);
        return (List<Linkman>)template.findByCriteria(dc,start,pageSize);
    }

    @Override
    public int findCount(DetachedCriteria dc) {
        //设置查询聚合函数。生成的语句select count(*).....
        dc.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>)template.findByCriteria(dc);
        return list.get(0).intValue();
    }
}
