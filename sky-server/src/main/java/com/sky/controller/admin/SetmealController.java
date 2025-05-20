package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Jaymr
 * @Date: 2025/5/18 10:38
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Slf4j
@RequestMapping("/admin/setmeal")
@RestController
public class SetmealController {

    @Autowired
    private SetmealService setmealService;
    /**
     * 分页查询
     * @return
     */
    @GetMapping("/page")
    public Result page(SetmealPageQueryDTO setmealPageQueryDTO){
        log.info("分页查询:{}",setmealPageQueryDTO);
        PageResult page = setmealService.page(setmealPageQueryDTO);
        return Result.success(page);
    }

    /**
     * 修改套餐
     */
    @PutMapping
    public Result update(@RequestBody SetmealDTO setmealDTO){
        log.info("修改套餐:{}",setmealDTO);
        setmealService.update(setmealDTO);
        return Result.success();
    }

    /**
     * 根据id查询套餐
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        log.info("根据id查询套餐:{}",id);
        SetmealVO setmealVO = setmealService.getById(id);
        return Result.success(setmealVO);
    }

    /**
     * 新增套餐
     */
    @PostMapping
    public Result save(@RequestBody SetmealDTO setmealDTO){
        setmealService.saveWithDish(setmealDTO);
        return Result.success();
    }

    /**
     * 删除套餐
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Long> ids){
        log.info("删除套餐：{}",ids);
        setmealService.delete(ids);
        return Result.success();
    }

    /**
     * 起售、停售套餐
     */
    @PostMapping("/status/{status}")
    public Result openOrStop(@PathVariable Integer status,Long id){
        log.info("起售停售套餐:{} {}",status == 1?"启售":"停售",id);
        setmealService.openOrStop(status,id);
        return Result.success();

    }

}




















