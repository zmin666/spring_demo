package com.zmin.helloword.demo.jap;

import com.zmin.helloword.demo.jpa.test.Article;
import com.zmin.helloword.demo.jpa.test.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;
    
    @Test
    public void userTest() {
        Article article = articleRepository.findByAuthor("zimug");
        System.out.println(article);
    }

}