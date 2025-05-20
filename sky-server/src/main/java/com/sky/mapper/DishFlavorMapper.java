package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Jaymr
 * @Date: 2025/5/17 19:35
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入口味数据
     * @param flavors
     */
    static void InsertBatch(List<DishFlavor> flavors) {
    }

    /**
     * 根据菜品id查询对应的口味
     * @param dishId
     * @return
     */
    public List<DishFlavor> getByDishId(Long dishId);

}
