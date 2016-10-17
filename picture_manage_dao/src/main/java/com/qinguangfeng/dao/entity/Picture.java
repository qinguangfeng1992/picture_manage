package com.qinguangfeng.dao.entity;

/**
 * @author qinguangfeng
 */
public class Picture {
    /**
     * 图片的ID
     */
    private Integer picid;
    /**
     * 图片的名字
     */
    private String picname;
    /**
     * 图片创建时间
     */
    private java.util.Date pictime;
    /**
     * 大图的url
     */
    private String bigpic;
    /**
     * 小图的url
     */
    private String smallpic;

    /**
     * 逻辑删除
     */
    private String logicdele;



    /**
     * 图片的ID
     *
     * @param picid
     */
    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    /**
     * 图片的ID
     *
     * @return
     */
    public Integer getPicid() {
        return picid;
    }

    /**
     * 图片的名字
     *
     * @param picname
     */
    public void setPicname(String picname) {
        this.picname = picname;
    }

    /**
     * 图片的名字
     *
     * @return
     */
    public String getPicname() {
        return picname;
    }

    /**
     * 图片创建时间
     *
     * @param pictime
     */
    public void setPictime(java.util.Date pictime) {
        this.pictime = pictime;
    }

    /**
     * 图片创建时间
     *
     * @return
     */
    public java.util.Date getPictime() {
        return pictime;
    }

    /**
     * 大图的url
     *
     * @param bigpic
     */
    public void setBigpic(String bigpic) {
        this.bigpic = bigpic;
    }

    /**
     * 大图的url
     *
     * @return
     */
    public String getBigpic() {
        return bigpic;
    }

    /**
     * 小图的url
     *
     * @param smallpic
     */
    public void setSmallpic(String smallpic) {
        this.smallpic = smallpic;
    }

    /**
     * 图片类型的ID
     */
    private Integer typeid;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * 小图的url
     *
     * @return
     */
    public String getSmallpic() {
        return smallpic;
    }

    /**
     * 逻辑删除
     *
     * @param logicdele
     */
    public void setLogicdele(String logicdele) {
        this.logicdele = logicdele;
    }

    /**
     * 逻辑删除
     *
     * @return
     */
    public String getLogicdele() {
        return logicdele;
    }

}