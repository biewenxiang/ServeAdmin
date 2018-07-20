package com.xss.admin.common.service;

import com.alibaba.fastjson.JSONObject;
import com.xss.modules.utils.HttpUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 获取微信token
 */
public class TokenCache {
    private static  String wxtoken="";
//    appid:wx8bcc3d53dac57245
//    secret:6602eab534202c30bc49cc1c012ed737
    public static String appid = "wx8bcc3d53dac57245";
    public static String secret = "6602eab534202c30bc49cc1c012ed737";
    public static String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
    static {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //reset();
                System.out.println(wxtoken);
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        //long intevalPeriod = 60 * 60 * 1000;//一小时
        long intevalPeriod = 1000;

        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
    }

    public static String getWXTokenString(){
        if ("".equals(wxtoken)){
            String results = HttpUtil.getUrlContent(accessTokenUrl);
            JSONObject jsonObject = JSONObject.parseObject(results);
            jsonObject.get("access_token");
            wxtoken = jsonObject.get("access_token").toString();
        }
        return wxtoken;
    }
    public static void reset(){
        String results = HttpUtil.getUrlContent(accessTokenUrl);
        JSONObject jsonObject = JSONObject.parseObject(results);
        jsonObject.get("access_token");
        wxtoken = jsonObject.get("access_token").toString();
    }



}
