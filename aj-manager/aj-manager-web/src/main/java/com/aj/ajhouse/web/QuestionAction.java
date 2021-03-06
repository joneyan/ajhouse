package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.pojo.vo.QuestionQuery;
import com.aj.ajhouse.service.QuestionService;
import com.aj.ajhouse.service.SysnewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Scope("prototype")
public class QuestionAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    QuestionService questionService;


    @RequestMapping(value = "/questions")
    @ResponseBody
    public Result<AjQuestions> listQuestionByPage(Page page, QuestionQuery questionQuery){
        Result<AjQuestions> list=null;
        try{
           list=questionService.listQuestionByPage(page,questionQuery);

        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }
    @RequestMapping(value = "/dquestion")
    @ResponseBody
    public int dquestions(@RequestParam("ids[]") List<Integer> ids){
        System.out.println("dquestion");
        int i=0;
        try{
            i = questionService.updateBatch(ids);

        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
