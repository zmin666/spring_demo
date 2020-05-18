package com.zmin.helloword.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reader {
    private String name;
    private int age;
}
