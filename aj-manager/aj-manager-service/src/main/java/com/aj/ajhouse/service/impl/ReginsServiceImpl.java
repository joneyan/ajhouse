package com.aj.ajhouse.service.impl;


import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.dao.AjReginsCustomMapper;
import com.aj.ajhouse.dao.AjReginsMapper;
import com.aj.ajhouse.pojo.po.AjRegins;
import com.aj.ajhouse.pojo.po.AjReginsExample;
import com.aj.ajhouse.pojo.vo.AjReginsCustom;
import com.aj.ajhouse.pojo.vo.AjReginsQuery;
import com.aj.ajhouse.service.ReginsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReginsServiceImpl implements ReginsService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AjReginsMapper reginsDao;
    @Autowired
    private AjReginsCustomMapper reginsCustomDao;

    @Override
    public int saveRegins(AjRegins ajRegins) {
        int i = 0;
        try{
            i = reginsDao.insert(ajRegins);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Result<AjReginsCustom> listReginsByPage(Page page,AjReginsQuery query,Order order) {
        Result<AjReginsCustom> result = null;
        try {
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("page", page);
            map.put("order", order);
            map.put("query", query);
            //1 创建一个响应参数实体类
            result = new Result<AjReginsCustom>();
            //2 对total进行设值(符合条件的总记录数)
            int total = reginsCustomDao.countRegins(map);
            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
            List<AjReginsCustom> list = reginsCustomDao.listReginsByPage(map);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override   //批量删除
    public int deleteBatch(List ids) {
        int i=0;
        try {
            //创建更新模板 delete * from aj_rgins where id in (?,?...)
            AjReginsExample example = new AjReginsExample();
            AjReginsExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            //执行删除
            i = reginsDao.deleteByExample(example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public AjRegins selectReginsById(int id) {
        AjRegins ajRegins = null;
        try {
            ajRegins = reginsDao.selectByPrimaryKey((Integer) id);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return ajRegins;
    }

    @Override
    public int updateRegins(AjRegins ajRegins) {
        int i = 0 ;
        try {
            //创建更新模板
            AjReginsExample example = new AjReginsExample();
            AjReginsExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(ajRegins.getId());
            //执行
            i = reginsDao.updateByExample(ajRegins,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
