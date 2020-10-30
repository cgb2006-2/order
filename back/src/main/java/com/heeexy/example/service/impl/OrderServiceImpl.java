package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.OrderDao;
import com.heeexy.example.service.OrderService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public JSONObject listAllOrder() {
        List<JSONObject> list = orderDao.listOrder();
        return CommonUtil.successPage(list);
    }
}
