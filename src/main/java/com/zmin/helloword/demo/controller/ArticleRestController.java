package com.zmin.helloword.demo.controller;

import com.zmin.helloword.demo.model.AjaxResponse;
import com.zmin.helloword.demo.model.Article;
import com.zmin.helloword.demo.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource(name = "articleRestJDBCServiceImpl")
    ArticleRestService articleRestService;

    //增加一篇Article ，使用POST方法
    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        articleRestService.saveArticle(article);
        return AjaxResponse.success(article);
    }

    //删除一篇Article，使用DELETE方法，参数是id
    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        articleRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article，使用GET方法
    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {
        return AjaxResponse.success(articleRestService.getArticle(id));
    }

    //获取所有的Article，使用GET方法
    @RequestMapping(value = "/article", method = GET, produces = "application/json")
    public AjaxResponse getAllArticle() {
        return AjaxResponse.success(articleRestService.getAll());
    }
}