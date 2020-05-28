package com.zmin.helloword.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * 这个是给前端使用的, 一般有多个dao层的po组成
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArticleVO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private List<Reader> reader;
}
