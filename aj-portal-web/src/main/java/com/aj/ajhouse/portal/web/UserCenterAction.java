package com.aj.ajhouse.portal.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjQuestionAns;
import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.AjUserCenterAns;
import com.aj.ajhouse.service.UserCenterService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.InputStream;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserCenterService userCenterService;

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
    public String getMessages(@PathVariable(value="tel") String tel , Model model, Page page,   Map<String,Object> map){
        System.out.println("messages");
        Result<AjSysnews> list =null;

        list =userCenterService.getMessages( tel ,map);
        model.addAttribute("sysnew",list);
//        model.addAttribute("pb",page);
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
    public String questMessages( @PathVariable(value="tel") String tel,Model model ,Page page, Map<String,Object> map){
        System.out.println("questMessages");

        Result<AjQuestions> list =null;

        list =userCenterService.questMessages( tel ,map);
        model.addAttribute("quest",list);

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
    public String questionAns(@PathVariable(value="tel") String tel ,  Model model, Page page,   Map<String,Object> map){
        System.out.println("questMessages");

        Result<AjUserCenterAns> list =null;

        list =userCenterService.questAnsMessages( tel ,map);
        model.addAttribute("ans",list);

        return "userCenter/userCenterQuestAns";
    }
    /**
     *
     * 修改头像
     * @param map
     * @return
     */
    @RequestMapping("/cephalicPhase")
    public String cephalicPhase(@RequestParam("images[]")List<MultipartFile> images, HttpServletRequest request, Model model, Page page, Map<String,Object> map){
        System.out.println("cephalicPhase");
        AjUser ajUser=new AjUser();
        System.out.println(images);
        String tel = request.getParameter("tel");

        AjUser u=new AjUser();
        u.setTel(tel);
        u=userCenterService.getUserMessages(u);


        int i=0;
        try{
            i = userCenterService.cephalicPhase(u,images);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        if(i==1){
            map.put("tel",u.getTel());
            String tel_ = userCenterService.findUserByTel(map);
            HttpSession session = request.getSession();
            ajUser= (AjUser) session.getAttribute("ajUser");
            ajUser.setPhoto(tel_);
            session.setAttribute("ajUser",ajUser);

            return "userCenter";
        }
        return "userCenterXiu";
    }

    /**
     * 修改资料
     * @param tel 用户手机
     * @param map
     * @return
     */
     @RequestMapping("/userX/{tel}")
    public String userX(@PathVariable(value="tel") String tel , Model model, Page page,HttpServletRequest request,Map<String,Object> map){
        System.out.println("userX");
        AjUser u=new AjUser();
        u.setTel(tel);
        u=userCenterService.getUserMessages(u);
        model.addAttribute("user",u);
        return "userCenter/userCenterUserX";
    }

    @RequestMapping("/updataUser")
    @ResponseBody
    public String updataUser(Model model, Page page, HttpServletRequest request, Map<String,Object> map){
        System.out.println("updataUser");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String idcard = request.getParameter("idcard");
        String introduce = request.getParameter("introduce");
        String tel = request.getParameter("tal");

        if (nickname==null||nickname.length()==0||email==null||email.length()==0||idcard==null||idcard.length()==0||introduce==null||introduce.length()==0){
            return "2";
        }
        map.put("nickname",nickname);
        map.put("tel",tel);
        map.put("email",email);
        map.put("idcard",idcard);
        map.put("introduce",introduce);
        int i= userCenterService.updataUser(map);
        AjUser ajUser = new AjUser();
        String mess=null;
        if(i==1) {
            //把用户存到session中
            HttpSession session = request.getSession();
            ajUser= (AjUser) session.getAttribute("ajUser");
            ajUser.setNickname(nickname);
            ajUser.setEmail(email);
            ajUser.setIdcard(idcard);
            ajUser.setIntroduce(introduce);
            session.setAttribute("ajUser",ajUser);
             mess = "1";
        }else {
             mess="0";
        }
        return mess;
    }


}
