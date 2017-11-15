package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjQuestions;

import java.util.List;
import java.util.Map;

public interface QuestionMapper {

    int countQuestion();

    List<AjQuestions> listQuestionByPage(Map<String, Object> map);
}
