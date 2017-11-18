package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.pojo.po.AjCity;
import com.aj.ajhouse.pojo.vo.AjCityCustom;
import com.aj.ajhouse.pojo.vo.AjCityQuery;
import com.aj.ajhouse.service.CityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Scope("prototype")    //城市
public class CityAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityService cityService;


    @ResponseBody
    @RequestMapping("/city")
    //添加城市
    public int saveCity(AjCity ajCity){
        int i = 0;
        try{
            i = cityService.saveCity(ajCity);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/cities")
    //分页查询所有城市  //cities
    public Result<AjCityCustom> listCitiesByPage(Page page, Order order, AjCityQuery query){
        Result<AjCityCustom> list = null;
        try {                               //,order,query
            list = cityService.listCityByPage(page,order,query);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }


    @ResponseBody
    @RequestMapping("/cities/batch")
    //批量删除
    public int deleteBatch(@RequestParam("ids[]")List ids){
        int i = 0;
        try {
            i = cityService.deleteBatch(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/citiesCats")
    //查询所有城市，用于添加区域页面里的城市下拉框选择
    public List<TreeNode> listCitiesCats(){
        List<TreeNode> list = null;
        try {
            list = cityService.listCityCats();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/city/editor")
    public String getCityById(@RequestParam("id")int id, HttpSession session){
        //System.out.println(id);
        String name=null;
        try {
          name = cityService.selectCityById(id).getName();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        //System.out.println(name);
        session.setAttribute("cityId",id);
        //将查询到的当前选项的城市名，存到session域
        session.setAttribute("cityName",name);

        return name;
    }

    @ResponseBody
    @RequestMapping("/city/editor2")
    public int updateCity(AjCity ajcity){
        int i = 0 ;
        //System.out.println(city.getId()+","+city.getName());
        try {
            i = cityService.updateCity(ajcity);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

}
