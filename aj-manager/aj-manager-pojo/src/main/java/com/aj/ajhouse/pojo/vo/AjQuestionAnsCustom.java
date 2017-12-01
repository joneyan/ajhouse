package com.aj.ajhouse.pojo.vo;

import com.aj.ajhouse.pojo.po.AjQuestionAns;
import com.aj.ajhouse.pojo.po.AjUser;

public class AjQuestionAnsCustom extends AjQuestionAns {
    private AjUser ajUser;

    public AjUser getAjUser() {
        return ajUser;
    }

    public void setAjUser(AjUser ajUser) {
        this.ajUser = ajUser;
    }
}
