package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.dao.AjCityCustomMapper;
import com.aj.ajhouse.dao.AjCityMapper;
import com.aj.ajhouse.dao.AjReginsCustomMapper;
import com.aj.ajhouse.dao.AjReginsMapper;
import com.aj.ajhouse.pojo.po.AjCity;
import com.aj.ajhouse.pojo.po.AjCityExample;
import com.aj.ajhouse.pojo.po.AjRegins;
import com.aj.ajhouse.pojo.po.AjReginsExample;
import com.aj.ajhouse.pojo.vo.AjCityCustom;
import com.aj.ajhouse.pojo.vo.AjCityQuery;
import com.aj.ajhouse.pojo.vo.AjReginsCustom;
import com.aj.ajhouse.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AjCityMapper ajCityMapper;

    @Autowired
    private AjCityCustomMapper ajCityCustomMapper;

    @Autowired
    private AjReginsCustomMapper ajReginsCustomMapper;

    @Override
    public int saveCity(AjCity ajCity) {
        int i = 0;
        try{
            i = ajCityMapper.insert(ajCity);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Result<AjCityCustom> listCityByPage(Page page, Order order, AjCityQuery query) {
        Result<AjCityCustom> result = null;
        try {
            //0 创建一个Map封装前台传递过来的参数
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("page", page);
            map.put("order", order);
            map.put("query", query);
            //1 创建一个响应参数实体类
            result = new Result<AjCityCustom>();
            //2 对total进行设值(符合条件的总记录数)
            int total = ajCityCustomMapper.countCity(map);
            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
            List<AjCityCustom> list = ajCityCustomMapper.listCityByPage(map);
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
            //AjCity r = new AjCity();
            //创建更新模板 delete * from aj_city where id in (?,?...)
            AjCityExample example = new AjCityExample();
            AjCityExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            //执行删除
            i = ajCityMapper.deleteByExample(example);

            //级联'删除'，将属于该城市的区域的城市id改为0
            //update aj_regins set city_id=0 where city_id in (?,?...)
            //[3, 4]
            ajReginsCustomMapper.updateByCityIds(ids);


        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<TreeNode> listCityCats() {
        List<AjCityCustom> list = null;
        try {
            //执行查询
            list = ajCityCustomMapper.listCity();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        List<TreeNode> resultList = new ArrayList<TreeNode>();
        //遍历原有集合
        for (int i=0;i<list.size();i++){
            TreeNode node = new TreeNode();
            Integer id1 = list.get(i).getId();
            int id2 = id1;
            Long id3 = (long)id2;
            node.setId(id3);
            node.setText(list.get(i).getName());
            node.setState("open");
            resultList.add(node);
        }
        return resultList;
    }

    @Override
    public AjCity selectCityById(int id) {
        AjCity city = null;
        try {
            city = ajCityMapper.selectByPrimaryKey((Integer) id);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public int updateCity(AjCity ajCity) {
        int i = 0;
        //AjCity c = new AjCity();
        //创建更新模板
        AjCityExample example = new AjCityExample();
        AjCityExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(ajCity.getId());
        //执行
        i = ajCityMapper.updateByExample(ajCity,example);
        return i;
    }

    @Override
    public AjCity selectCityByName(String cityName) {
        //AjCity c = new AjCity();
        //创建模板
        AjCityExample example = new AjCityExample();
        AjCityExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(cityName);
        //执行
        List list = ajCityMapper.selectByExample(example);
        return (AjCity) list.get(0);
    }
}
