package com.xiaojihua.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0DataSourceUtils {
    private static DataSource ds = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
