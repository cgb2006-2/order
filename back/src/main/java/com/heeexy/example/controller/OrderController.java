package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.OrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequiresPermissions("order:deliveryman")
    @GetMapping("/findAll")
    public JSONObject listOrder() {
        return orderService.listAllOrder();
    }

    @PostMapping("/updateOrderState")
    public JSONObject updateOrderState(String orderId,Integer state){

        return orderService.updateOrderState(orderId,state);
    }
}
