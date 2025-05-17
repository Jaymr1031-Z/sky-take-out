package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.annotation.AutoFill;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.entity.Setmeal;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Jaymr
 * @Date: 2025/5/17 18:23
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;
    @Autowired
    private SetmealDishMapper setmealDishMapper;

    /**
     * 新增菜品和对应口味
     * @param dishDTO
     */
    @Override
    @Transactional
    public void saveWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        //向菜品表插入1条数据
        dishMapper.insert(dish);

        //获取Insert语句生成的主键值
        Long dishId = dish.getId();

        //向口味表插入n条数据
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (!flavors.isEmpty() && flavors.size() > 0){
            flavors.forEach(dishFlavor -> {
                dishFlavor.setDishId(dishId);
            });
            DishFlavorMapper.InsertBatch(flavors);
        }
    }

    /**
     * 分页查询
     */
    @Override
    public PageResult page(DishPageQueryDTO dishPageQueryDTO) {
        PageHelper.startPage(dishPageQueryDTO.getPage(),dishPageQueryDTO.getPageSize());
        Page<Dish> p = dishMapper.getPage(dishPageQueryDTO);
        return new PageResult(p.getTotal(),p.getResult());
    }

    /**
     * 菜品删除
     */
    @Transactional
    @Override
    public void delete(List<Long> ids) {
        //判断当前菜品是否能删除----是否存在起售中的菜品
        for (Long id : ids) {
            Dish dish = dishMapper.getId(id);
            if (dish.getStatus() == StatusConstant.ENABLE){
                throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
            }
        }
        //判断当前菜品是否能删除----是否被套餐关联了
        List<Long> setmealIds = setmealDishMapper.getSetmealIdsByDishIds(ids);
        if (setmealIds != null && setmealIds.size()>0){
            //当前菜品被套餐关联
            throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
        }
        //删除菜品表中的菜品数据
        dishMapper.delete(ids);
        //删除菜品关联的口味数据
        dishMapper.deleteByDishId(ids);

    }

    /**
     * 修改菜品
     */
    @Override
    public void update(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        dishMapper.update(dish);
    }

    /**
     * 根据id查询菜品
     */
    @Override
    public DishDTO getById(Long id) {
        return dishMapper.getById(id);
    }

    /**
     * 根据分类id查询菜品
     */
    @Override
    public List<Dish> getByCateId(Long categoryId) {
        List<Dish> list = dishMapper.getByCateId(categoryId);
        return list;
    }

    /**
     * 菜品起售、停售
     */
    @Override
    public void openOrStop(Integer status, Long id) {
        dishMapper.openOrStop(status,id);
    }
}
