package com.imooc.mapper;

import com.imooc.config.BaseMapper;
import com.imooc.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper extends BaseMapper<Order> {

    int insert(Order order);

    int update(Order order);

    int deleteById(@Param("id")Integer id);

}