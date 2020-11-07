package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

public interface DeliverymanService {
    JSONObject getInfoById(Integer deliverymanId);

    void updatePassword(String password);

    JSONObject logoutTime();

    JSONObject logTime();
}
