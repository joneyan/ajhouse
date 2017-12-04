package com.aj.ajhouse.portal.web;

import com.aj.ajhouse.common.dto.PageBean;
import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.Question;
import com.aj.ajhouse.pojo.vo.QuestionQuery;
import com.aj.ajhouse.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Controller
@Scope("prototype")
public class QuestionAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    QuestionService questionService;

    //qjk的问答模块
    //模糊查询所有问题
    @RequestMapping(value = "/wenda/rs{quesTitle}/pg{currentPage}/")
    public String listQuestionByPage(@PathVariable("quesTitle") String quesTitle,@PathVariable("currentPage") Integer currentPage , Model model ,HttpServletRequest request){
        //String s = new String(quesTitle,"UTF-8");
        //中文乱码-->tomcat插件配置加上转码见笔记
        //System.out.println(quesTitle+"---"+currentPage);

        PageBean<Question> pageBean = new PageBean<Question>();
        QuestionQuery questionQuery = new QuestionQuery();

        //List<Question> list = null;
        try {
            questionQuery.setQuesTitle(quesTitle);
            pageBean.setCurrentPage(currentPage);
            pageBean=questionService.listQuestionByPageInPortal(pageBean,questionQuery);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        model.addAttribute("quesTitle",quesTitle);
        //model.addAttribute("currentPage",currentPage);
        model.addAttribute("pageBean",pageBean);

        return "all_questions";
    }

    //问题的回答页
    @RequestMapping(value = "/wenda/xiangqing/{questionId}.html")
    public String showQuestion(@PathVariable("questionId") Integer id,Model model){
        //System.out.println(id);
        Question question = new Question();
        try {
            question=questionService.selectQuestionByIdInPortal(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        model.addAttribute("question",question);
        return "answers";
    }

    //提问页面  //仅用于页面跳转
    @RequestMapping(value = "/wenda/tiwen")
    public String putQuestion(){
        return "put_question";
    }
    //提问的表单提交
    @RequestMapping(value = "/wenda/tiwen/success")
    public String putQuestionSuccess(AjQuestions ajQuestions, AjUser ajUser, Model model){
        //System.out.println(ajQuestions.getQuesTitle()+";"+ajQuestions.getQuesContent());
        //暂时设置用户id，应该直接从页面的登录的用户中获取到的
        //ajUser.setId(31);
        //
        ajQuestions.setId(null);
        ajQuestions.setCreatetime(new Date());
        ajQuestions.setStatus(0);
        ajQuestions.setUserid(ajUser.getId());
        //新增问题
        int quesId = 0;
        try{
            questionService.addQuestion(ajQuestions);
            //获取当前新增问题的id，用于回显到成功页面的超链接中
            //select max(id) from aj_questions where userid = 31
            quesId = questionService.selectNewIdByUserIdInPortal(ajUser);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        model.addAttribute("quesId",quesId);
        return "put_question_success";
    }

}
