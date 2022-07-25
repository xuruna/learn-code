package com.imooc.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

//标识配置文件
@Configuration
//标识开启事务
@EnableTransactionManagement
public class DruidDateSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DruidDateSourceConfig.class);

    @Autowired
    public DruidDataSourceSetting druidDataSourceSetting;

    public static String DRIVER_CLASSNAME;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() throws SQLException{
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(druidDataSourceSetting.getDirverClassName());
        DRIVER_CLASSNAME = druidDataSourceSetting.getDirverClassName();
        ds.setUrl(druidDataSourceSetting.getUrl());
        ds.setUsername(druidDataSourceSetting.getUsername());
        ds.setPassword(druidDataSourceSetting.getPassword());
        ds.setInitialSize(druidDataSourceSetting.getInitialSize());
        ds.setMinIdle(druidDataSourceSetting.getMinIdle());
        ds.setMaxActive(druidDataSourceSetting.getMaxActive());
        ds.setTimeBetweenConnectErrorMillis(druidDataSourceSetting.getTimeBetweenEvictionRunsMillis());
        ds.setMinEvictableIdleTimeMillis(druidDataSourceSetting.getMinEvictableIdleTimeMillis());
        ds.setValidationQuery(druidDataSourceSetting.getValidationQuery());
        ds.setTestWhileIdle(druidDataSourceSetting.isTestWhileIdle());
        ds.setTestOnBorrow(druidDataSourceSetting.isTestOnBorrow());
        ds.setTestOnReturn(druidDataSourceSetting.isTestOnReturn());
        ds.setPoolPreparedStatements(druidDataSourceSetting.isPoolPreparedStatements());
        ds.setMaxPoolPreparedStatementPerConnectionSize(druidDataSourceSetting.getMaxPoolPreparedStatementPerConnectionSize());
        ds.setFilters(druidDataSourceSetting.getFilters());
        ds.setConnectionProperties(druidDataSourceSetting.getConnectionProperties());
        logger.info("druid datasource config : {}",ds);
        return ds;
    }


    @Bean
    public PlatformTransactionManager transactionManager() throws Exception{
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource());
        return txManager;
    }

}
