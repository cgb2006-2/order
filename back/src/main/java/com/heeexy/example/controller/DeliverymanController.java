package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.DeliverymanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveryman")
public class DeliverymanController {
    @Autowired
    private DeliverymanService deliverymanService;

    /**
     * 查询当前登录用户的信息
     */
    @PostMapping("/getInfo")
    public JSONObject getInfo() {
        deliverymanService.getDelId();
        return deliverymanService.getInfo();
    }

}
