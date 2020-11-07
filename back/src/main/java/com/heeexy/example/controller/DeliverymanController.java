package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.heeexy.example.service.DeliverymanService;
import com.heeexy.example.service.OrderService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.InfoUtil;
import com.heeexy.example.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/getInfo")
    public JSONObject getInfo() {
        return deliverymanService.getInfoById(InfoUtil.getUserId());
    }

    /**
     *  修改个人密码,并返回提示信息
     */
    @Transactional
    @PostMapping("/updatePassword")
    public JSONObject updatePassword(String password){
        if (password==null)
            return CommonUtil.errorJson(ErrorEnum.E_20202);
        deliverymanService.updatePassword(password);
        return CommonUtil.successJson("修改成功");
    }

    /**
     *  查询个人订单信息
     */
    @GetMapping("/doFindOrderById")
    public JSONObject doFindOrderById(){
        return orderService.FindOrderById(InfoUtil.getUserId());
    }

    /**
     * 下班修改
     * @return
     */
    @GetMapping("/logoutTime")
    public JSONObject logoutTime(){
        return deliverymanService.logoutTime();
    }

    /**
     * 上班
     * @return
     */
    @GetMapping("/logTime")
    public JSONObject logTime(){
        return deliverymanService.logTime();
    }
}
