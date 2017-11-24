package com.aj.ajhouse.portal.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.service.UserCenterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author: yiyun
 * @Company:
 * @Package: com.aj.ajhouse.portal.web
 * @Date: 2017-11-23
 * @Time: 19:40
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

@Controller
@Scope("prototype")
public class UserCenterAction {

    @Autowired
    UserCenterService userCenterService;
    /**
     *用户中心跳转
     * @return
     */
   @RequestMapping("/toUserCenter")
   public String toIndex(){
       return "userCenter";
   }

    /**
     * 系统消息Action
     *@param tel 用户手机
     * @return
     */
    @RequestMapping("/messages/{tel}")
    public String getMessages(@PathVariable(value="tel") String tel ,Page page, Order order){
        System.out.println("messages");
        List<AjSysnews> list =null;
        list =userCenterService.getMessages( page,  order);
        System.out.println(tel);
        return "userCenter/userCenterMess";
    }

    /**
     *
     * 我的提问Action
     * @param tel 用户手机
     * @param map
     * @return
     */
    @RequestMapping("/questMessages/{tel}")
    public String questMessages( @PathVariable(value="tel") String tel , Map<String,Object> map){
        System.out.println("questMessages");
       System.out.println(tel);
        return "userCenter/userCenterQuestMess";
    }

    /**
     *
     * 我的回答Action
     * @param tel 用户手机
     * @param map
     * @return
     */
    @RequestMapping("/questionAns/{tel}")
    public String questionAns( @PathVariable(value="tel") String tel ,Map<String,Object> map){
        System.out.println("questionAns");
        System.out.println(tel);
        return "userCenter/userCenterQuestAns";
    }

    /**
     * 修改资料
     * @param tel 用户手机
     * @param map
     * @return
     */
     @RequestMapping("/userX/{tel}")
    public String userX( @PathVariable(value="tel") String tel , Map<String,Object> map){
        System.out.println("userX");

      System.out.println(tel);
        return "userCenter/userCenterUserX";
    }


}
