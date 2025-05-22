package com.sky.dto;

import lombok.Data;

/**
 * @Author: Jaymr
 * @Date: 2025/5/22 08:42
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Data
public class HistoryOrderPageQueryDTO {
    private int page;
    private int pageSize;
    private Integer status;
}
