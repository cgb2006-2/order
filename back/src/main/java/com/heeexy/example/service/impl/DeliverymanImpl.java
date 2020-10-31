package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.DeliverymanDao;
import com.heeexy.example.service.DeliverymanService;
import com.heeexy.example.util.CommonUtil;
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

    @Override
    public Integer getDelId() {
        Session session = SecurityUtils.getSubject().getSession();
        JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
        String username = userInfo.getString("username");
        System.out.println(username);
        Integer id = deliverymanDao.getId(username);
        return id;
    }

    @Override
    public JSONObject getInfo() {
        List<JSONObject> list = new ArrayList<>();
        list.add(deliverymanDao.getInfoById(getDelId()) );
        return CommonUtil.successPage(list);
    }
}
