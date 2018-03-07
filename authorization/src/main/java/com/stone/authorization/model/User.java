package com.stone.authorization.model;

import java.io.Serializable;

/**
 * User: 孙皓亮
 * Date: 2018/2/2
 * Time: 10:17
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8036219797322639507L;

    private String account;
    private String pwd;
    private Long userId;
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
