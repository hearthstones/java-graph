package com.graph.mysql.domain;

import lombok.Data;

import java.util.Date;

/**
 * 订单实体类
 *
 * @author luchao
 * @date 2022/1/8
 */
@Data
public class Order {
    private Long id;

    private Long orderId;

    private String orderNo;

    private Long userId;

    private String receiverName;

    private String receiverPhone;

    private String receiverAddress;

    private String senderName;

    private String senderPhone;

    private String senderAddress;

    private String productInfo;

    private Date gmtCreate;

    private Date gmtModified;
}