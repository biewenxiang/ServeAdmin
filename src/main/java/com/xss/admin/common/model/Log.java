package com.xss.admin.common.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 日志表
 */
@Alias("log")
public class Log implements Serializable {


    private Long logid;//日志

    private String username = "";//操作人

    private String createtime = "";//createtime

    private String content = "";//详细

    private String operation = "";//操作类型（增删改）

    private String ip = "";//ip地址

    private String module = "";//所属模块

    public Long getLogid() {
        return logid;
    }

    public void setLogid(Long logid) {
        this.logid = logid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }


}
