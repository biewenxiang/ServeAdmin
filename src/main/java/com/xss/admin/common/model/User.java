package com.xss.admin.common.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("user")
public class User implements Serializable {

    private Integer userid;//用户id

    private String username;//用户名

    private String password;//密码

    private Integer usertype;//用户类型

    private Integer roleid;//角色id

    private String userdescription;//描述信息


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getUserdescription() {
        return userdescription;
    }

    public void setUserdescription(String userdescription) {
        this.userdescription = userdescription;
    }


}