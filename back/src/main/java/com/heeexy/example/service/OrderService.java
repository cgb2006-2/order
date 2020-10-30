package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

public interface OrderService {
    /**
     * 订单列表
     */
    JSONObject listOrder(JSONObject jsonObject);
}
