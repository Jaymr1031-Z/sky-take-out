package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 新增菜品
     * @param dish
     */
    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    /**
     * 分页查询
     * @return
     */
    Page<Dish> getPage(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品删除
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 修改菜品
     */
    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    DishDTO getById(Long id);

    /**
     * 根据分类id查询菜品
     */
    List<Dish> getByCateId(Long categoryId);

    /**
     * 菜品起售、停售
     * @param status
     * @param id
     */
    void openOrStop(Integer status, Long id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    Dish getId(Long id);

    /**
     * 根据id删除口味
     * @param ids
     */
    void deleteByDishId(List<Long> ids);
}
