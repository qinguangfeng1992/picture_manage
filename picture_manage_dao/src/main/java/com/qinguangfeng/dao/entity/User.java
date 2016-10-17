package com.qinguangfeng.dao.entity;

/**
 * @author qinguangfeng
 */
public class User {
    /**
     *
     */
    private Integer userid;
    /**
     *
     */
    private String username;
    /**
     *
     */
    private String password;

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }
}