package com.heeexy.example.util;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.util.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class InfoUtil {
    public static JSONObject getUserInfo(){
        Session session = SecurityUtils.getSubject().getSession();
        JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
        return userInfo;
    }

    public static Integer getUserId(){
        return getUserInfo().getInteger("userId");
    }

}
