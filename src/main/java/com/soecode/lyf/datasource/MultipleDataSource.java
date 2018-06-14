package com.soecode.lyf.datasource;

/**
 * Created by sewef on 2018/6/14.
 */

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 设置切换数据库数据源
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
    public static final String DATA_SOURCE_MYSQL= "mysqlDataSource";
    public static final String DATA_SOURCE_ORACLE = "oracleDataSource";

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    public static void removeDataSourceKey(){
        dataSourceKey.remove();
    }
}