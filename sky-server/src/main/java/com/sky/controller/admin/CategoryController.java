package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
  *@Author: Jaymr
  *@Date: 2025/5/16 15:24
  *@Version: v1.0.0
  *@Description: TODO
 **/
@Slf4j
@RequestMapping("/admin/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 修改分类
     */
    @PutMapping
    public Result update(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类：{}",categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分页查询：{}",categoryPageQueryDTO);
        PageResult p = categoryService.page(categoryPageQueryDTO);
        return Result.success(p);
    }
}
