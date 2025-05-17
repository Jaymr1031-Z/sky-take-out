package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Jaymr
 * @Date: 2025/5/17 23:40
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Mapper
public interface SetmealDishMapper {
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);
}















