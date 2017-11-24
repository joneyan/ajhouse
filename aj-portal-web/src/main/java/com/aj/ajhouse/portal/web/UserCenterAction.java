package com.aj.ajhouse.portal.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /*@Autowired
    private UserCenterService userCenterService;*/
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
     * @return
     */
   /* @RequestMapping("/messages/{id}")
    public String getMessages(Page page, Order order){
        System.out.println("messages");
        List<AjSysnews> list =null;
        list =userCenterService.getMessages( page,  order);
        System.out.println(list);
        return "m";
    }*/

    /**
     *
     * 我的提问Action
     * @param id 用户id
     * @param map
     * @return
     */
    @RequestMapping("/questMessages/{id}")
    public String questMessages( @PathVariable(value="id") Integer id , Map<String,Object> map){
        System.out.println("questMessages");
        int i =id;
        System.out.println(i);
        return "m";
    }

    /**
     *
     * 我的回答Action
     * @param id 用户id
     * @param map
     * @return
     */
    @RequestMapping("/questionAns/{id}")
    public String questionAns( @PathVariable(value="id") Integer id , Map<String,Object> map){
        System.out.println("questionAns");
        int i =id;
        System.out.println(i);
        return "m";
    }

    /**
     * 修改资料
     * @param id  用户id
     * @param map
     * @return
     */
     @RequestMapping("/userX/{id}")
    public String userX( @PathVariable(value="id") Integer id , Map<String,Object> map){
        System.out.println("userX");
        int i =id;
        System.out.println(i);
        return "m";
    }


}
