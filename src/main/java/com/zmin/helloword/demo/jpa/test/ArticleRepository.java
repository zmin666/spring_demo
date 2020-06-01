package com.zmin.helloword.demo.jpa.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    //注意这个方法的名称，jPA会根据方法名自动生成SQL执行
    Article findByAuthor(String author);
}