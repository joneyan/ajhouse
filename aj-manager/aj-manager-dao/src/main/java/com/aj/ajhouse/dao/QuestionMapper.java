package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.vo.Question;

import java.util.List;
import java.util.Map;

public interface QuestionMapper {

    int countQuestion();

    List<AjQuestions> listQuestionByPage(Map<String, Object> map);

    int updateBatch(Integer id);

    //qjk问答分页查询模糊查询
    int countQuestionByTitle(Map<String, Object> map);
    List<Question> listQuestionByPageInPortal(Map<String, Object> map);
    //qjk通过id查询问题
    Question selectQuestionByIdInPortal(Map<String, Object> map);
    //qjk查询出新增问题的id
    int selectNewIdByUserIdInPortal(Map<String, Object> map);
}
