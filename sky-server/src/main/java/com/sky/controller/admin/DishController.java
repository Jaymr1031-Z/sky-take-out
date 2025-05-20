package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Dish;
import com.sky.mapper.DishMapper;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @Author: Jaymr
 * @Date: 2025/5/17 18:20
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Slf4j
@RequestMapping("/admin/dish")
@RestController
public class DishController {

    @Autowired
    private DishService dishService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 新增菜品
     * @param dishDTO
     * @return
     */
    @PostMapping
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("新增菜品：{}",dishDTO);
        dishService.saveWithFlavor(dishDTO);
        //清理缓存数据
        String key = "dish_" +dishDTO.getCategoryId();
        clearCache(key);
        return Result.success();
    }

    /**
     * 菜品分页查询
     */
    @GetMapping("/page")
    public Result page(DishPageQueryDTO dishPageQueryDTO){
        log.info("菜品分页查询：{}",dishPageQueryDTO);
        PageResult page = dishService.page(dishPageQueryDTO);
        return Result.success(page);
    }

    /**
     * 菜品删除
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Long> ids){
        log.info("菜品删除，{}",ids);
        dishService.delete(ids);

        //将所有的菜品缓存数据清理掉 所有以dish_开头的key
        clearCache("dish*");
        return Result.success();
    }

    /**
     * 修改菜品
     */
    @PutMapping
    public Result update(@RequestBody DishDTO dishDTO){
        log.info("修改菜品：{}",dishDTO);
        dishService.update(dishDTO);

        //将所有的菜品缓存数据清理掉 所有以dish_开头的key
        clearCache("dish*");

        return Result.success();
    }

    /**
     * 根据id查询菜品
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        log.info("根据id查询菜品:{}",id);
        DishDTO dishDTO = dishService.getById(id);
        return Result.success(dishDTO);
    }

    /**
     * 根据分类id查询菜品
     */
    @GetMapping("/list")
    public Result<List<Dish>> getByCateId(@RequestParam Long categoryId){
        log.info("根据分类id查询菜品:{}",categoryId);
        List<Dish> list = dishService.getByCateId(categoryId);
        return Result.success(list);
    }

    /**
     * 菜品起售、停售
     */
    @PostMapping("/status/{status}")
    public Result openOrStop(@PathVariable Integer status,Long id){
        log.info("菜品起售、停售:{},{}",status,id);
        dishService.openOrStop(status,id);

        //将所有的菜品缓存数据清理掉 所有以dish_开头的key
        clearCache("dish*");
        return Result.success();
    }

    /**
     * 清理缓存数据
     * @param pattern
     */
    private void clearCache(String pattern){
        Set keys = redisTemplate.keys(pattern);
        redisTemplate.delete(keys);
    }
}
