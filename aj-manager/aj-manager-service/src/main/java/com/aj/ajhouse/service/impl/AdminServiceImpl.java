package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.AjAdminCustomMapper;
import com.aj.ajhouse.dao.AjAdminMapper;
import com.aj.ajhouse.pojo.po.AjAdmin;
import com.aj.ajhouse.pojo.po.AjAdminExample;
import com.aj.ajhouse.pojo.vo.AdminQuery;
import com.aj.ajhouse.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AjAdminCustomMapper ajAdminCustomMapper;

    @Autowired
    private AjAdminMapper ajAdminMapper;


    @Override
    public AjAdmin findByAcountnum(AjAdmin ajAdmin) {
        AjAdmin admin = null;
        try {
                admin = ajAdminCustomMapper.selectByAcountnum(ajAdmin.getAcountnum());

        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return admin;
    }

    @Override
    public int addAdmin(AjAdmin ajAdmin) {
        ajAdmin.setCreateTime(new Date());
        int mess = ajAdminMapper.insert(ajAdmin);
        return mess;
    }

    @Override
    public Result<AjAdmin> listAdminByPage(Page page, Order order, AdminQuery query) {
        Result<AjAdmin> result = null;
        try {
            //0 创建一个Map封装前台传递过来的参数
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);
            map.put("order", order);
            map.put("query", query);
            //1 创建一个响应参数实体类
            result = new Result<AjAdmin>();
            //2 对total进行设值(符合条件的总记录数)
            int total = ajAdminCustomMapper.countAdmins(map);
            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
            List<AjAdmin> list = ajAdminCustomMapper.listAdminsByPage(map);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public int update(AjAdmin ajAdmin) {
        int i= 0;
        try{
            i = ajAdminCustomMapper.updateAdmin(ajAdmin);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateBatch(List<Integer> ids) {
        int i=0;
        try {
            AjAdmin record = new AjAdmin();
            record.setIsUse(false);

            AjAdminExample example = new AjAdminExample();
            AjAdminExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);

            i = ajAdminMapper.updateByExampleSelective(record,example);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public AjAdmin findById(int id) {
        AjAdmin ajAdmin = null;
        try {
            ajAdmin = ajAdminMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return ajAdmin;
    }
}
