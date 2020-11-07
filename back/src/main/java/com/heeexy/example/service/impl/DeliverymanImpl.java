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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliverymanImpl implements DeliverymanService {

    @Autowired
    private DeliverymanDao deliverymanDao;

    @Autowired
    private UserDao userDao;

    /**
     * 查询配送员列表
     * @param deliverymanId
     * @return
     */
    @Override
    public JSONObject getInfoById(Integer deliverymanId) {
        List<JSONObject> list = null;
        if(deliverymanId.equals(10003))
            list=deliverymanDao.getAllDeliveryman();
        else
            list = deliverymanDao.getInfoById(deliverymanId);
        return CommonUtil.successPage(list);
    }

    /**
     *  修改个人登录密码,更新总用户表和配送员表
     */
    @Override
    @Transactional
    public void updatePassword(String password) {
        deliverymanDao.updatePassword(InfoUtil.getUserId(),password);
        userDao.updatePassword(InfoUtil.getUserId(), password);
    }

    /**
     * 下班
     * @return
     */
    @Override
    public JSONObject logoutTime() {
        deliverymanDao.logoutTime(0, InfoUtil.getUserId());
        return CommonUtil.successJson();
    }

    /**
     * 上班
     * @return
     */
    @Override
    public JSONObject logTime() {
        deliverymanDao.logTime(1,InfoUtil.getUserId());
        return CommonUtil.successJson();
    }
}
