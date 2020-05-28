package com.zmin.helloword.demo.controller;

import com.zmin.helloword.demo.model.AjaxResponse;
import com.zmin.helloword.demo.model.ArticleVO;
import com.zmin.helloword.demo.service.ArticleRestJPAService;
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

    @Resource(name = "articleRestJPAServiceImpl")
    ArticleRestJPAService articleRestJPAService;

    //增加一篇Article ，使用POST方法
    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody ArticleVO article) {
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        articleRestJPAService.saveArticle(article);
        return AjaxResponse.success(article);
    }

    //删除一篇Article，使用DELETE方法，参数是id
    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        articleRestJPAService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO article) {
        article.setId(id);
        articleRestJPAService.updateArticle(article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article，使用GET方法
    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {
        return AjaxResponse.success(articleRestJPAService.getArticle(id));
    }

    //获取所有文章
    @RequestMapping(value = "/article", method = GET, produces = "application/json")
    public AjaxResponse getAll() {
        return AjaxResponse.success(articleRestJPAService.getAll());
    }
}