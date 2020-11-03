package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.OrderDao;
import com.heeexy.example.service.OrderService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public JSONObject listAllOrder( ) {
        List<JSONObject> list = orderDao.listOrder();
        return CommonUtil.successPage(list);
    }

    /**
     *  根据Id查询配送员个人接订单信息
     */
    @Override
    public JSONObject FindOrderById(Integer id) {
        List<JSONObject> list= orderDao.findOrderById(id);
        return CommonUtil.successPage(list);
    }

    @Transactional
    @Override
    public JSONObject updateOrderState(String orderId, Integer state) {
        orderDao.updateOrderState(orderId,state);
        return CommonUtil.successJson();
    }

}
