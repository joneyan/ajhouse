package com.aj.ajhouse.pojo.vo;

import com.aj.ajhouse.pojo.po.AjQuestions;

import java.util.List;

public class Question extends AjQuestions {
    private String nickname;
    //qjk 问题的回答数
    private int answersNum;
    //qjk 问题的所有回答
    private List<AjQuestionAnsCustom> answerList;
    //qjk 该问题的用户的电话
    private String tel;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAnswersNum() {
        return answersNum;
    }

    public void setAnswersNum(int answersNum) {
        this.answersNum = answersNum;
    }

    public List<AjQuestionAnsCustom> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<AjQuestionAnsCustom> answerList) {
        this.answerList = answerList;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
