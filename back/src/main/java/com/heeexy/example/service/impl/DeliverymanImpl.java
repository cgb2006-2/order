package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.DeliverymanDao;
import com.heeexy.example.dao.UserDao;
import com.heeexy.example.service.DeliverymanService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.InfoUtil;
import com.heeexy.example.util.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliverymanImpl implements DeliverymanService {

    @Autowired
    private DeliverymanDao deliverymanDao;

    @Autowired
    private UserDao userDao;

    @Override
    public JSONObject getInfoById(Integer id) {
        List<JSONObject> list = deliverymanDao.getInfoById(id);
        return CommonUtil.successPage(list);
    }

    /**
     *  修改个人登录密码,更新总用户表和配送员表
     */
    @Override
    public void updatePassword(String password) {
        deliverymanDao.updatePassword(InfoUtil.getUserId(),password);
        userDao.updatePassword(InfoUtil.getUserId(), password);
    }
}
