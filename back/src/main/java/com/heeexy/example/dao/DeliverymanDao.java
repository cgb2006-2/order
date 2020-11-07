package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface DeliverymanDao {

    int updatePassword(Integer deliverymanId, String password);

    List<JSONObject> getInfoById(Integer deliverymanId);

    List<JSONObject> getAllDeliveryman();

    int logoutTime(Integer state,Integer deliverymanId);

    int logTime(Integer state,Integer deliverymanId);
}
