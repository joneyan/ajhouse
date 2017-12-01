package com.aj.ajhouse.service;


import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.PageBean;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.Question;
import com.aj.ajhouse.pojo.vo.QuestionQuery;

import java.util.List;

public interface QuestionService {

    public Result<AjQuestions> listQuestionByPage(Page page,QuestionQuery questionQuery) ;

    int updateBatch(List<Integer> ids);

    //qjk问答页面的分页、模糊查询
    PageBean<Question> listQuestionByPageInPortal(PageBean<Question> pageBean, QuestionQuery questionQuery);
    //qjk问题的回答页面
    Question selectQuestionByIdInPortal(int id);
    //qjk新增问题
    int addQuestion(AjQuestions ajQuestions);
    //qjk查询新增的问题的id，回显其id
    int selectNewIdByUserIdInPortal(AjUser ajUser);
}
