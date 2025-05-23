package com.sky.controller.admin;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderStatisticsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jaymr
 * @Date: 2025/5/22 16:53
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Slf4j
@RequestMapping("/admin/order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 订单搜索
     */
    @GetMapping("/conditionSearch")
    public Result conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO){
        log.info("订单搜索:{}",ordersPageQueryDTO);
        PageResult page = orderService.conditionSearch(ordersPageQueryDTO);
        return Result.success(page);
    }

    /**
     * 各个状态的订单数量统计
     */
    @GetMapping("/statistics")
    public Result statistics(){
        log.info("各个状态的订单数量统计");
        OrderStatisticsVO orderStatisticsVO = orderService.statistics();
        return Result.success(orderStatisticsVO);
    }
}


















