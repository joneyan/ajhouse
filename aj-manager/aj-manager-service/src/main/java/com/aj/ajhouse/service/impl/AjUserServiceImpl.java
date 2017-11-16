package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.AjUserCustomMapper;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.UserQuery;
import com.aj.ajhouse.service.AjUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AjUserServiceImpl implements AjUserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AjUserCustomMapper ajUserCustomMapper;

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
}
