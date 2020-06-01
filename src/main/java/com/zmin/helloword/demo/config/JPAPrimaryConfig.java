package com.zmin.helloword.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryPrimary",
        transactionManagerRef="transactionManagerPrimary",
        basePackages= { "com.zmin.helloword.demo.jpa.test" }) //设置Repository所在位置
public class JPAPrimaryConfig {

 
    @Resource
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;        //primary数据源注入

    @Primary
    @Bean(name = "entityManagerPrimary")        //primary实体管理器
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }

  

    @Primary
    @Bean(name = "entityManagerFactoryPrimary")    //primary实体工厂
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {

        return builder
                .dataSource(primaryDataSource)
                .properties(getVendorProperties())
                .packages("com.zmin.helloword.demo.jpa.test")     //设置实体类所在位置
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

  

    @Resource
    private JpaProperties jpaProperties;

    private Map getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

  

    @Primary
    @Bean(name = "transactionManagerPrimary")         //primary事务管理器
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}
