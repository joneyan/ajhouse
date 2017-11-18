package com.aj.ajhouse.service;


import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.pojo.vo.QuestionQuery;

import java.util.List;

public interface QuestionService {

    public Result<AjQuestions> listQuestionByPage(Page page,QuestionQuery questionQuery) ;

    int updateBatch(List<Integer> ids);
}
