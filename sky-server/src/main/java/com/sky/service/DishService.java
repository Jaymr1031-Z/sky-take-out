package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Dish;
import com.sky.result.PageResult;

import java.util.List;

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

    /**
     * 分页查询
     * @param dishPageQueryDTO
     * @return
     */
    PageResult page(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品删除
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 修改菜品
     * @param dishDTO
     */
    void update(DishDTO dishDTO);

    /**
     * 根据id查询菜品
     * @param id
     * @return
     */
    DishDTO getById(Long id);

    /**
     * 根据分类id查询菜品
     * @return
     */
    List<Dish> getByCateId(Long categoryId);

    /**
     * 菜品起售、停售
     * @param status
     * @param id
     */
    void openOrStop(Integer status, Long id);
}
