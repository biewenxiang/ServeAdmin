package com.xss.admin.common.service;

import com.alibaba.fastjson.JSONObject;
import com.xss.modules.utils.HttpUtil;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Service;

@Service
public class PushMessageService {

    public static String appid = "wx28aaae604a94c07e";
    public static String secret = "17a5719c3a2a9aa4e42bdfd20f6103ff";
    public static String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
    //public static String templateUrl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=access_token";


    public String sendMessage(String openid ,String form_id,String templateid){

        String access_token = TokenCache.getWXTokenString();
        String templateurl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+access_token;
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("access_token", access_token);
        jsonParam.put("touser", openid);
        jsonParam.put("form_id", form_id);
        jsonParam.put("page", "pages/index/index");
        jsonParam.put("template_id", templateid);

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 =new JSONObject();
        jsonObject1.put("value","测试数据一");
        jsonObject1.put("color","#173177");
        jsonObject.put("keyword1",jsonObject1);
        jsonObject.put("keyword2",jsonObject1);
        jsonObject.put("keyword3",jsonObject1);
        jsonObject.put("keyword4",jsonObject1);
        jsonObject.put("keyword5",jsonObject1);
        jsonParam.put("data", jsonObject);
        StringEntity entity2 = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题
        String results2 = HttpUtil.postMethod(templateurl,entity2);
        System.out.println(results2);
        return "";
    }

}
