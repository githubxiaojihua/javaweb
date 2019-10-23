package com.xiaojihua.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static final EntityManagerFactory factory;
    private static  EntityManager em;

    static{
        factory = Persistence.createEntityManagerFactory("mysql");
    }

    public static EntityManager getEm(){
        return factory.createEntityManager();
    }
}
