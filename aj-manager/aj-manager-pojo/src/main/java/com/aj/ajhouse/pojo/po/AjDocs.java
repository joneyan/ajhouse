package com.aj.ajhouse.pojo.po;

import java.util.Date;

public class AjDocs {
    private Integer id;

    private String doCtitle;

    private Integer menuTopid;

    private Integer menuLeafid;

    private Date creatTime;

    private Date updateTime;

    private String docContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoCtitle() {
        return doCtitle;
    }

    public void setDoCtitle(String doCtitle) {
        this.doCtitle = doCtitle == null ? null : doCtitle.trim();
    }

    public Integer getMenuTopid() {
        return menuTopid;
    }

    public void setMenuTopid(Integer menuTopid) {
        this.menuTopid = menuTopid;
    }

    public Integer getMenuLeafid() {
        return menuLeafid;
    }

    public void setMenuLeafid(Integer menuLeafid) {
        this.menuLeafid = menuLeafid;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDocContent() {
        return docContent;
    }

    public void setDocContent(String docContent) {
        this.docContent = docContent == null ? null : docContent.trim();
    }
}