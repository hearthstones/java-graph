package com.summary.mysql.mapper;

import com.summary.mysql.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品 Mapper层
 *
 * @author luchao
 * @date 2022/1/8
 */
@Mapper
public interface ProductMapper {

    /**
     * 插入
     *
     * @param record 商品记录
     * @return int
     */
    int insert(Product record);

    /**
     * 批量插入
     *
     * @param list product list
     * @return int
     */
    int batchInsert(List<Product> list);

}