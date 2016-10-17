package com.qinguangfeng.dao.vo;

/**
 * @author qinguangfeng
 */
public class PictypeVo {
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
     * @return Integer
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
     * @return String
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
     * @return String
     */
    public String getLogicdele() {
        return logicdele;
    }
}