package com.zmin.helloword.demo.service;

import com.zmin.helloword.demo.model.ArticleVO;

import java.util.List;

public interface ArticleRestJPAService {

    ArticleVO saveArticle(ArticleVO article);

    void deleteArticle(Long id);

    void updateArticle(ArticleVO article);

    ArticleVO getArticle(Long id);

    List<ArticleVO> getAll();
}
