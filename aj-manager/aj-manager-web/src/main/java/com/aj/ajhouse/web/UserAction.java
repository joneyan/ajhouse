package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.UserQuery;
import com.aj.ajhouse.service.AjUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller
@Scope("prototype")
public class UserAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AjUserService ajUserService;

    //查询指定条件的用户
    public Result<AjUser> listUserByPage(Page page, Order order, UserQuery query){
        Result<AjUser> result = null;
        try{
                result = ajUserService.listUserByPage(page,order,query);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return result;
    }

}
