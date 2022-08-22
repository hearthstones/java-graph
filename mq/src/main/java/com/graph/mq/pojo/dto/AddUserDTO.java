package com.graph.mq.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 新增用户DTO
 *
 * @author luchao
 * @since 2022/5/17
 */
@Data
@Accessors(chain = true)
public class AddUserDTO {

    private Long id;

    private String username;

    private String password;

    private String phone;

    private String address;

}
