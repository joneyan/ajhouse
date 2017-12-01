package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.PageBean;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.AjQuestionAnsMapper;
import com.aj.ajhouse.dao.AjQuestionsMapper;
import com.aj.ajhouse.dao.AjUserMapper;
import com.aj.ajhouse.dao.QuestionMapper;
import com.aj.ajhouse.pojo.po.AjQuestionAns;
import com.aj.ajhouse.pojo.po.AjQuestionAnsExample;
import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.AjQuestionAnsCustom;
import com.aj.ajhouse.pojo.vo.Question;
import com.aj.ajhouse.pojo.vo.QuestionQuery;
import com.aj.ajhouse.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class QuestionServiceImpl implements QuestionService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuestionMapper questionDao;

    @Autowired
    private AjQuestionAnsMapper ajQuestionAnsDao;

    @Autowired
    private AjUserMapper ajUserDao;

    @Autowired
    private AjQuestionsMapper ajQuestionsDao;


    @Override
    public Result<AjQuestions> listQuestionByPage(Page page,QuestionQuery questionQuery){
        System.out.println("listQuestionByPage");
        Result<AjQuestions> result=null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);
            map.put("questionQuery", questionQuery);

            result = new Result<AjQuestions>();
            int total = questionDao.countQuestion();
            result.setTotal(total);

            List<AjQuestions> list = questionDao.listQuestionByPage(map);

            result.setRows(list);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();


        }

        return result;
    }

    @Override
    public int updateBatch(List<Integer> ids) {
        int i=0;
        try{
            for (int j=0;ids.size()>j;j++){
                i = questionDao.updateBatch(ids.get(j));
            }
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public PageBean<Question> listQuestionByPageInPortal(PageBean<Question> pageBean, QuestionQuery questionQuery){
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            //当前页
            pageBean.getCurrentPage();
            //每页数据条数，10
            int pageSize = 10;
            //总个数
            map.put("questionQuery",questionQuery);
            int totalCount = questionDao.countQuestionByTitle(map);
            //总页数计算         总记录条数 每页记录条数
            int totalPage = (totalCount+pageSize-1)/pageSize;

            pageBean.setPageSize(pageSize);
            pageBean.setTotalCount(totalCount);
            pageBean.setTotalPage(totalPage);
            //查询到的问题
            map.put("pageBean",pageBean);
            List<Question> list = questionDao.listQuestionByPageInPortal(map);

            //对每个问题进行回答计数
            List<Question> list2 = new ArrayList<Question>();
            for(Question ques : list) {
                int num = 0;
                //
                AjQuestionAnsExample example = new AjQuestionAnsExample();
                AjQuestionAnsExample.Criteria criteria = example.createCriteria();
                criteria.andQuesIdEqualTo(ques.getId());
                num += ajQuestionAnsDao.countByExample(example);
                //
                ques.setAnswersNum(num);
                list2.add(ques);
            }
            pageBean.setList(list2);

            //pageBean.setList(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return pageBean;
    }

    @Override
    public Question selectQuestionByIdInPortal(int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Question question = null;
        int num = 0;
        try {
            question = new Question();
            map.put("id",id);
            question = questionDao.selectQuestionByIdInPortal(map);
            //获取提出该问题的用户的手机号
            int userId = question.getUserid();
            AjUser au = ajUserDao.selectByPrimaryKey(userId);
            question.setTel(au.getTel());

            //先根据问题id去qj_question_ans表的ques_id字段查找出对应的回答
            AjQuestionAnsExample example = new AjQuestionAnsExample();
            AjQuestionAnsExample.Criteria criteria = example.createCriteria();
            criteria.andQuesIdEqualTo(id);
            List<AjQuestionAns> list=ajQuestionAnsDao.selectByExample(example);
            //倒序
            Collections.reverse(list);
            //question.setAnswerList(list);
            //计数
            question.setAnswersNum(list.size());
            //再由回答的user_id去aj_user表中找出用户信息
            List<AjQuestionAnsCustom> list2 = new ArrayList<AjQuestionAnsCustom>();
            AjQuestionAnsCustom ansCustom = null;
            for(AjQuestionAns ans : list) {
                ansCustom = new AjQuestionAnsCustom();
                //ansCustom = (AjQuestionAnsCustom) ans;
                ansCustom.setAnsContent(ans.getAnsContent());
                ansCustom.setAnsId(ans.getAnsId());
                ansCustom.setCreatetime(ans.getCreatetime());
                ansCustom.setId(ans.getId());
                ansCustom.setQuesId(ans.getQuesId());
                ansCustom.setStatus(ans.getStatus());
                ansCustom.setUserId(ans.getUserId());

                ansCustom.setAjUser(ajUserDao.selectByPrimaryKey(ans.getUserId()));
                list2.add(ansCustom);
            }
            question.setAnswerList(list2);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return question;
    }

    @Override
    public int addQuestion(AjQuestions ajQuestions) {
        int i = 0;
        try {
            i += ajQuestionsDao.insert(ajQuestions);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return i;
    }

    @Override
    public int selectNewIdByUserIdInPortal(AjUser ajUser) {
        int id = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("ajUser",ajUser);
            id = questionDao.selectNewIdByUserIdInPortal(map);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return id;
    }
}

