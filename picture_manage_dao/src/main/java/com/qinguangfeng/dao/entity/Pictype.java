package com.qinguangfeng.dao.entity;

/**
 * @author qinguangfeng
 */
public class Pictype {
    /**
     * 图片类型
     */
    private Integer typeid;
    /**
     * 图片类型的名字
     */
    private String typename;
    /**
     *
     */
    private String logicdele;

    /**
     * 图片类型
     *
     * @param typeid
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * 图片类型
     *
     * @return
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 图片类型的名字
     *
     * @param typename
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * 图片类型的名字
     *
     * @return
     */
    public String getTypename() {
        return typename;
    }

    /**
     * @param logicdele
     */
    public void setLogicdele(String logicdele) {
        this.logicdele = logicdele;
    }

    /**
     * @return
     */
    public String getLogicdele() {
        return logicdele;
    }
}