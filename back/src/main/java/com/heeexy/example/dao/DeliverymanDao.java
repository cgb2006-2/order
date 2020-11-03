package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface DeliverymanDao {

    int updatePassword(Integer id, String password);

    List<JSONObject> getInfoById(Integer id);

}
