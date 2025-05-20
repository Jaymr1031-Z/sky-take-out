package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;

import java.util.List;

/**
 * @Author: Jaymr
 * @Date: 2025/5/18 10:39
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface SetmealService {
    /**
     * 分页查询
     * @return
     */
    PageResult page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 修改套餐
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    SetmealVO getById(Long id);

    /**
     * 新增套餐 同时保存套餐和菜品的关联关系
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);

    /**
     * 删除套餐
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     *
     * 起售、停售套餐
     * @param status
     * @param id
     */
    void openOrStop(Integer status, Long id);

    /**
     * 条件查询
     * @param setmeal
     * @return
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据id查询菜品选项
     * @param id
     * @return
     */
    List<DishItemVO> getDishItemById(Long id);
}
