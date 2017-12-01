package com.aj.ajhouse.pojo.vo;

import com.aj.ajhouse.pojo.po.AjDocsMenu;

public class AjDocsMenuView extends AjDocsMenu {

    private String parentName;

    private String operatorName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
