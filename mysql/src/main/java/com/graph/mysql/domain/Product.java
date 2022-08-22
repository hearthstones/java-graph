package com.graph.mysql.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体类
 *
 * @author luchao
 * @date 2022/1/8
 */
@Data
public class Product {
    private Long id;

    private String name;

    private BigDecimal price;

    private String description;

    private Date gmtCreate;

    private Date gmtModified;
}