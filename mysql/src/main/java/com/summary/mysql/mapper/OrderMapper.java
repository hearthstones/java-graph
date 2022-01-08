package com.summary.mysql.mapper;

import com.summary.mysql.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单 Mapper层
 *
 * @author luchao
 * @date 2022/1/8
 */
@Mapper
public interface OrderMapper {

    /**
     * 插入
     *
     * @param record 订单记录
     * @return int
     */
    int insert(Order record);

}