package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Jaymr
 * @Date: 2025/5/16 15:20
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Mapper
public interface CategoryMapper {
    /**
     * 更新分类
     * @param category
     */
    void update(Category category);

    /**
     * 分页查询分类
     * @param cate
     * @return
     */
    Page<Category> get(CategoryPageQueryDTO cate);

    /**
     * 新增分类
     */
    void add(Category category);

    /**
     * 根据id删除分类
     * @param id
     */
    void delete(Integer id);
}
