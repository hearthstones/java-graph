package com.summary.mysql.domain;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author luchao
 * @date 2022/1/8
 */
@Data
public class User {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String address;

    private Date gmtCreate;

    private Date gmtModified;
}