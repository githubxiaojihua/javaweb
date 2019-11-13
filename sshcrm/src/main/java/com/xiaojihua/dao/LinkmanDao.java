package com.xiaojihua.dao;

import com.xiaojihua.domain.Linkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface LinkmanDao {
    void save(Linkman linkman);
    List<Linkman> find();
    List<Linkman> findByDc(DetachedCriteria dc);
    Linkman findById(Long id);
    void update(Linkman linkman);
}
