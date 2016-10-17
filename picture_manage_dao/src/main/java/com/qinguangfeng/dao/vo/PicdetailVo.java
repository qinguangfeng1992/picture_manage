package com.qinguangfeng.dao.vo;

/**
 * @author qinguangfeng
 */
public class PicdetailVo {
    /**
     * 套图详细信息表的id
     */
    private Integer detailid;
    /**
     * 套图的图片来源
     */
    private String picurl;
    /**
     * 套图的标题
     */
    private String pictitle;
    /**
     * 套图的介绍
     */
    private String picdesc;

    /**
     * 套图详细信息表的id
     *
     * @param detailid
     */

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    /**
     * 只显示新增的图片文本url
     */
    private String addlogic;

    public String getAddlogic() {
        return addlogic;
    }

    public void setAddlogic(String addlogic) {
        this.addlogic = addlogic;
    }

    /**
     * 套图信息表的ID
     */
    private Integer picid;

    /**
     * 套图详细信息表的id
     *
     * @return Integer
     */
    public Integer getDetailid() {
        return detailid;
    }

    /**
     * 套图的图片来源
     *
     * @param picurl
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    /**
     * 套图的图片来源
     *
     * @return String
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * 套图的标题
     *
     * @param pictitle
     */
    public void setPictitle(String pictitle) {
        this.pictitle = pictitle;
    }

    /**
     * 套图的标题
     *
     * @return String
     */
    public String getPictitle() {
        return pictitle;
    }

    /**
     * 套图的介绍
     *
     * @param picdesc
     */
    public void setPicdesc(String picdesc) {
        this.picdesc = picdesc;
    }

    /**
     * 套图的介绍
     *
     * @return String
     */
    public String getPicdesc() {
        return picdesc;
    }
}