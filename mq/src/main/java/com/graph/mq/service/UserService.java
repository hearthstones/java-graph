package com.graph.mq.service;

import com.graph.mq.pojo.dto.AddUserDTO;

/**
 * UserService
 *
 * @author luchao
 * @since 2022/5/18
 */
public interface UserService {

    /**
     * 新增用户
     *
     * @param dto 新增用户DTO
     */
    void add(AddUserDTO dto);

}
