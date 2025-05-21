package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderSubmitVO;

/**
 * @Author: Jaymr
 * @Date: 2025/5/21 11:18
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface OrderService {

    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
}
