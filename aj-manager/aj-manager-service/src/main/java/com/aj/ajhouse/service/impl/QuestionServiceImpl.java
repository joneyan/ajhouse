package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.QuestionMapper;
import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class QuestionServiceImpl implements QuestionService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    QuestionMapper questionDao;


    @Override
    public Result<AjQuestions> listQuestionByPage(Page page){
        System.out.println("listQuestionByPage");
        Result<AjQuestions> result=null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);

            result = new Result<AjQuestions>();

            int total = questionDao.countQuestion();
            result.setTotal(total);

            List<AjQuestions> list = questionDao.listQuestionByPage(map);
            result.setRows(list);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();


        }
        System.out.println(result);
        return result;
    }
}

