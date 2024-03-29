package com.graph.mysql.mapper;

import com.graph.mysql.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 批量插入
     *
     * @param list order list
     * @return int
     */
    int batchInsert(List<Order> list);

}