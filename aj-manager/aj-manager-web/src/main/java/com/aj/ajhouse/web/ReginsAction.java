package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.pojo.po.AjCity;
import com.aj.ajhouse.pojo.po.AjRegins;
import com.aj.ajhouse.pojo.vo.AjReginsCustom;
import com.aj.ajhouse.pojo.vo.AjReginsQuery;
import com.aj.ajhouse.service.CityService;

import com.aj.ajhouse.service.ReginsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Scope("prototype")     //区域
public class ReginsAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReginsService reginsService;
    @Autowired
    private CityService cityService;

    @ResponseBody
    @RequestMapping("/regin")
    //添加指定城市下的区域       //,@RequestParam("regin_id") Integer regin_id
    public int saveRegin(AjRegins ajRegins){
        int i = 0;
        //System.out.println(ajRegins.getName()+";"+ajRegins.getReginId());

        try{
            i = reginsService.saveRegins(ajRegins);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return i;
    }

    @ResponseBody
    @RequestMapping("/regins")
    //分页查询所有区域
    public Result<AjReginsCustom> listReginsByPage(Page page, AjReginsQuery query, Order order){
        Result<AjReginsCustom> list = null;
        try {
            list = reginsService.listReginsByPage(page,query,order);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/regin/batch")
    //批量删除
    public int deleteBatch(@RequestParam("ids[]")List ids){
        int i = 0;
        try {
            i = reginsService.deleteBatch(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    //点击编辑按钮，查询当前选中项相关信息，数据回显到修改页面
    @RequestMapping("/regins/{id}")
    public String getReginsById(@PathVariable("id")Integer id, Model model){

        AjRegins ajRegins = null;
        try {
            ajRegins = reginsService.selectReginsById(id);
            //name = ajRegins.getName();
            //cityId = ajRegins.getCityId();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        model.addAttribute("ajRegins",ajRegins);
        //修改页面的视图
        return "regin-editor";
    }

    //编辑的提交
    @ResponseBody
    @RequestMapping("/regins/editor")      //@RequestParam("treeNode")TreeNode treeNode
    public int updateRegins(AjRegins ajRegins){
        int i = 0;
        /*System.out.println(cityName);
        AjCity a = cityService.selectCityByName(cityName);
        System.out.println(a.getId()+","+a.getName());*/
        //System.out.println(ajRegins.getId()+";"+ajRegins.getName()+";"+ajRegins.getCityId());
        try {
            //AjCity ajCity = cityService.selectCityByName(cityName);
            //ajRegins.setCityId(ajCity.getId());
            i = reginsService.updateRegins(ajRegins);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return  i;
    }

}
