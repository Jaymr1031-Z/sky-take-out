package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Jaymr
 * @Date: 2025/5/20 16:34
 * @Version: v1.0.0
 * @Description: TODO
 **/
@RestController
@Slf4j
@RequestMapping("/user/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车
     * @param shoppingCartDTO
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO){
        log.info("添加购物车,商品信息为：{}",shoppingCartDTO);
        shoppingCartService.addShoppingcart(shoppingCartDTO);
        return Result.success();
    }

    /**
     * 查看购物车
     */
    @GetMapping("/list")
    public Result list(){
        log.info("查看购物车");
        List<ShoppingCart> list = shoppingCartService.list();
        return Result.success(list);
    }
}














