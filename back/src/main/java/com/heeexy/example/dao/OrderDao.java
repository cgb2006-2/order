package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface OrderDao {
    /**
     * 查询订单数量
     */
    int countOrder();

    /**
     * 查询订单列表
     */
    List<JSONObject> listOrder();
}
