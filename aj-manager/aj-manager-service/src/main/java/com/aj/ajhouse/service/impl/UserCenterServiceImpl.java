package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.AjSysnewsMapper;
import com.aj.ajhouse.dao.SysnewMapper;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.service.UserCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yiyun
 * @Company:
 * @Package: com.aj.ajhouse.service.impl
 * @Date: 2017-11-23
 * @Time: 22:16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
@Service
public class UserCenterServiceImpl implements UserCenterService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SysnewMapper sysnewMapper;

    @Override
    public List<AjSysnews> getMessages(Page page, Order order) {
        Result<AjSysnews> result = null;
        try {
            //0 创建一个Map封装前台传递过来的参数
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);
            map.put("order", order);
            //1 创建一个响应参数实体类
            result = new Result<AjSysnews>();
            //2 对total进行设值(符合条件的总记录数)
            int total = sysnewMapper.countSysnew(map);
            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
            List<AjSysnews> list = sysnewMapper.listSysnewByPage(map);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        //todo
        return null;
    }
}
