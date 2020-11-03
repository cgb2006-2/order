package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface DeliverymanService {
    JSONObject getInfoById(Integer id);
    void updatePassword(String jsonObject);
}
