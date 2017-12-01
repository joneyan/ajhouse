package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.AjUserCustomMapper;
import com.aj.ajhouse.dao.AjUserMapper;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.UserQuery;
import com.aj.ajhouse.service.AjUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AjUserServiceImpl implements AjUserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AjUserCustomMapper ajUserCustomMapper;

    @Autowired
    private AjUserMapper ajUserMapper;

    @Override
    public Result<AjUser> listUserByPage(Page page, Order order, UserQuery query) {
        Result<AjUser> result = null;
        try {
            //0 创建一个Map封装前台传递过来的参数
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);
            map.put("order", order);
            map.put("query", query);
            //1 创建一个响应参数实体类
            result = new Result<AjUser>();
            //2 对total进行设值(符合条件的总记录数)
            int total = ajUserCustomMapper.countUsers(map);
            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
            List<AjUser> list = ajUserCustomMapper.listUsersByPage(map);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public AjUser findById(int id) {
        AjUser user = null;
        try {
            user = ajUserMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateUser(AjUser ajUser) {
        int i = 0;
        try {
            i = ajUserMapper.updateByPrimaryKeySelective(ajUser);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public AjUser findByTel(String tel) {

        AjUser ajUser=ajUserCustomMapper.getUser(tel);

        return ajUser;
    }

    @Override
    public int addUser(String tel,String password) {
        AjUser ajUser = new AjUser();

        Date date = new Date();

        ajUser.setLastloginTime(date);
        ajUser.setAccountnum(tel);
        ajUser.setPassword(password);
        ajUser.setTel(tel);
        ajUser.setPhoto("http://101.132.176.163:80/images/lianjiaim_noagent.png");
        ajUser.setCreateTime(date);
        ajUser.setRole(1);
        ajUser.setStatus(0);


        int i = ajUserMapper.insertSelective(ajUser);
        return i;
    }
}
