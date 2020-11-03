package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface OrderDao {
    /**
     * 查询订单数量
     */
    int countOrder( );

    /**
     * 管理员查询所有订单列表
     */
    List<JSONObject> listOrder();

    /**
     * 配送员查询自己的订单列表
     */
    List<JSONObject> findOrderById(Integer id);

    void updateOrderState(String orderId, Integer state);
}
