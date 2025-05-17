package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * @Author: Jaymr
 * @Date: 2025/5/17 18:22
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface DishService {

    /**
     * 新增菜品和对应口味
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
