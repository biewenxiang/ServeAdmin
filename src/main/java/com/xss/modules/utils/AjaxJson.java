package com.xss.modules.utils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * $.ajax后需要接受的JSON
 *
 * @author
 *
 */
public class AjaxJson {

    private boolean success = true;// 是否成功
    private String msg = "操作成功";// 提示信息
    private Object obj = null;// 其他信息
    private Map<String, Object> attributes;// 其他参数
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getJsonStr(){
        JSONObject obj = new JSONObject();
        obj.put("success", this.isSuccess());
        obj.put("msg", this.getMsg());
        obj.put("obj", this.obj);
        obj.put("attributes", this.attributes);
        return obj.toJSONString();
    }

    /**
     * layui返回数据格式
     * @param a
     * @return
     */
    public static String getJson2UI(PageInfo a){
        JSONObject json=new JSONObject();
        json.put("code", 0);
        json.put("count", a.getTotal());
        json.put("data", a.getList());
        json.put("status", "success");

        return json.toJSONString();
    }
}
