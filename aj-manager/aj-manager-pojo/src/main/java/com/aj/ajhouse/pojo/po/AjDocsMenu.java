package com.aj.ajhouse.pojo.po;

import java.util.Date;

public class AjDocsMenu {
    private Integer id;

    private Integer parentid;

    private String name;

    private Boolean isParent;

    private Date createtime;

    private Date updatetime;

    private Integer status;

    private Integer operatorid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }

    @Override
    public String toString() {
        return "AjDocsMenu{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", name='" + name + '\'' +
                ", isParent=" + isParent +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", status=" + status +
                ", operatorid=" + operatorid +
                '}';
    }
}