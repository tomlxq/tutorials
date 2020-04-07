package com.guava.entity;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/3
 */
@Data
public class User {
    private static final long serialVersionUID = 1L;
    private Integer id; // id
    private String name; // name
    private String pwd; // pwd
    private Integer age; // age
    private Date creatTime; // creatTime

}
