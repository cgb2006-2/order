package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.heeexy.example.service.DeliverymanService;
import com.heeexy.example.service.OrderService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配送员个人页面信息
 */
@RestController
@RequestMapping("/deliveryman")
public class DeliverymanController {
    @Autowired
    private DeliverymanService deliverymanService;
    @Autowired
    private OrderService orderService;

    /**
     * 查询当前登录用户的信息
     */
    @PostMapping("/getInfo")
    public JSONObject getInfo() {
        deliverymanService.getDelId();
        return deliverymanService.getInfo();
    }

    /**
     *  修改个人密码,并返回提示信息
     */
    @GetMapping("/updatePassword")
    public JSONObject updatePassword(JSONObject jsonObject){
        deliverymanService.updatePassword(jsonObject);
        return CommonUtil.successJson("修改成功");
    }

    /**
     *  查询个人订单信息
     */
    @PostMapping("/doFindOrderId")
    public JSONObject doFindOrderId(){

        return orderService.courierFindOrderId();
    }


}
