package com.summary.mysql.mapper;

import com.summary.mysql.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户 Mapper层
 *
 * @author luchao
 * @date 2022/1/8
 */
@Mapper
public interface UserMapper {

    /**
     * 插入
     *
     * @param record user记录
     * @return int
     */
    int insert(User record);
}