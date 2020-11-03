package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

public interface OrderService {
    /**
     * 订单列表
     */
    JSONObject listAllOrder();

    JSONObject FindOrderById(Integer id);

    JSONObject updateOrderState(String orderId, Integer state);
}
