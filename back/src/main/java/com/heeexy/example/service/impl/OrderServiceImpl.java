package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.OrderDao;
import com.heeexy.example.service.OrderService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public JSONObject listAllOrder( ) {
        List<JSONObject> list = orderDao.listOrder();
        System.out.println(list);
        return CommonUtil.successPage(list);
    }

    /**
     *  根据Id查询配送员个人接订单信息
     *  TODO mapper没写
     * @return
     */
    @Override
    public JSONObject courierFindOrderId() {
        List<JSONObject> courierOrderLis= orderDao.courierFindOrderId();
        if (courierOrderLis==null || courierOrderLis.size()==0)
            return CommonUtil.errorJson(ErrorEnum.E_1031);
        return CommonUtil.successPage(courierOrderLis);
    }

}
