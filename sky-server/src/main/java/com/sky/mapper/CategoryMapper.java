package com.sky.mapper;

import com.github.pagehelper.Page;
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
     * 分页查询
     * @param cate
     * @return
     */
    Page<Category> get(CategoryPageQueryDTO cate);
}
