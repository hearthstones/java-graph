package com.summary.mysql.mapper;

import com.summary.mysql.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 批量插入
     *
     * @param list user list
     */
    void batchInsert(List<User> list);

    /**
     * 查询用户信息
     *
     * @param id 主键ID
     * @return 用户信息
     */
    User selectById(Long id);

}