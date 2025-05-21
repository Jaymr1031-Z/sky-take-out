package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Jaymr
 * @Date: 2025/5/21 11:21
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Mapper
public interface OrderMapper {
    void insert(Orders orders);
}
