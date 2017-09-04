package com.smart.domain;

import java.util.Date;

public class LoginLog {
    public static final String TABLE_NAME = "t_login_log";
    private int id;
    private int userId;
    private String ip;
    private Date loginDateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(Date loginDateTime) {
        this.loginDateTime = loginDateTime;
    }
}
