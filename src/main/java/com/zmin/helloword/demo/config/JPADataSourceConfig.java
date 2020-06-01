package com.zmin.helloword.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class JPADataSourceConfig {

    //主数据源
    @Primary
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")    //结合application.yml的配置
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    //从数据源
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")   //结合application.yml的配置
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}