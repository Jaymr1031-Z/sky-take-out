package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import com.sky.service.ShoppingCartService;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

/**
 * @Author: Jaymr
 * @Date: 2025/5/20 16:44
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Mapper
public interface ShoppingCartMapper {

    /**
     * 动态条件查询购物车
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 根据id修改商品数量
     * @param shoppingCart
     */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart shoppingCart);

    /**
     * 插入购物车数据
     * @param shoppingCart
     */
    @Insert("INSERT INTO shopping_cart(name, image, user_id, dish_id, setmeal_id, dish_flavor, amount, create_time) " +
            "VALUES (#{name}, #{image}, #{userId}, #{dishId}, #{setmealId}, #{dishFlavor}, #{amount}, #{createTime})")
    void insert(ShoppingCart shoppingCart);

    /**
     * 清空购物车
     * @param shoppingCart
     */
    @Delete("delete from shopping_cart where user_id = #{userId}")
    void delete(ShoppingCart shoppingCart);

    /**
     * 删除购物车中的商品
     */
    void sub(ShoppingCart shoppingCart);

}
