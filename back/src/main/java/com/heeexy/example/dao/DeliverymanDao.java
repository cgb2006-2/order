package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

public interface DeliverymanDao {
    Integer getId(String username);

    JSONObject getInfoById(Integer id );

    JSONObject updatePassword(JSONObject jsonObject);
}
