package com.aj.ajhouse.service;


import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.po.AjSysnews;

import java.util.List;

public interface QuestionService {

    public Result<AjQuestions> listQuestionByPage(Page page) ;

    int updateBatch(List<Integer> ids);
}
