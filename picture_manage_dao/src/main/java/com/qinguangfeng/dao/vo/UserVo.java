package com.qinguangfeng.dao.vo;

/**
 * @author qinguangfeng
 */
public class UserVo {
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
     * @return Integer
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
     * @return String
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
     * @return String
     */
    public String getPassword() {
        return password;
    }
}