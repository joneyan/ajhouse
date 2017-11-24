package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.dao.AjHouseParamMapper;
import com.aj.ajhouse.pojo.po.AjHouseParam;
import com.aj.ajhouse.pojo.po.AjHouseParamExample;
import com.aj.ajhouse.service.AjHouseParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AjHouseParamServiceImpl implements AjHouseParamService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjHouseParamMapper ajHouseParamDao;
    @Override
    public int saveHouseParam(Integer houseCatId_, String paramData) {
        int i=0;
        try{
            AjHouseParam ajHouseParam = new AjHouseParam();
            ajHouseParam.setCatId(houseCatId_);
            ajHouseParam.setParamData(paramData);
            ajHouseParam.setCreatetime(new Date());
            ajHouseParam.setUpdatetime(new Date());
            ajHouseParamDao.insert(ajHouseParam);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public AjHouseParam getHouseParamByCatId(Integer catId) {
        AjHouseParam ajHouseParam=null;
        try{
            AjHouseParamExample example = new AjHouseParamExample();
            AjHouseParamExample.Criteria criteria = example.createCriteria();
            criteria.andCatIdEqualTo(catId);
            List<AjHouseParam> list = ajHouseParamDao.selectByExample(example);
            if(list != null && list.size() > 0){
                ajHouseParam = list.get(0);
            }

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return ajHouseParam;
    }
}
