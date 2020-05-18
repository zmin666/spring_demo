package com.zmin.helloword.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Article {
    private Long id;
    @JsonProperty("auther")
    private String author;

    private String title;
    @JsonIgnore
    private String content;

    private Date createTime;
    private List<Reader> reader;
}
