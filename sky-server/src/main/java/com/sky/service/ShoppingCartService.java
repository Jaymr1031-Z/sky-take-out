package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

/**
 * @Author: Jaymr
 * @Date: 2025/5/20 16:38
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface ShoppingCartService {
    void addShoppingcart(ShoppingCartDTO shoppingCartDTO);

    List<ShoppingCart> list();
}
