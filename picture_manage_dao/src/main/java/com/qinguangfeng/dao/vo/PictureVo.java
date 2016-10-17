package com.qinguangfeng.dao.vo;

/**
 * @author qinguangfeng
 */
public class PictureVo {
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
     * 图片类型的ID
     */
    private Integer typeid;
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
     * @return Integer
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
     * @return String
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

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * 图片类型表 的图片名字
     */
    private String typename;

    /**
     * 图片创建时间
     *
     * @return String
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
     * 图片详细信息表的 图片标题
     */
    public String pictitle;
    /**
     * 图片详细信息表的 图片描述
     */
    public String picdesc;

    public String getPictitle() {
        return pictitle;
    }

    public void setPictitle(String pictitle) {
        this.pictitle = pictitle;
    }

    public String getPicdesc() {
        return picdesc;
    }

    public void setPicdesc(String picdesc) {
        this.picdesc = picdesc;
    }

    /**
     * 大图的url
     *
     * @return String
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
     * 小图的url
     *
     * @return String
     */
    public String getSmallpic() {
        return smallpic;
    }

    /**
     * 图片类型的ID
     *
     * @param typeid
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * 图片类型的ID
     *
     * @return Integer
     */
    public Integer getTypeid() {
        return typeid;
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
     * @return String
     */
    public String getLogicdele() {
        return logicdele;
    }


}