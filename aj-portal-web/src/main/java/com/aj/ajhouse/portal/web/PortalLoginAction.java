package com.aj.ajhouse.portal.web;

import com.aj.ajhouse.common.util.SendsmsUtils;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.service.AjUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class PortalLoginAction {

    @Autowired
    private AjUserService ajUserService;

    //短信接口
    @ResponseBody
    @RequestMapping("/getMessageCode/{tel}")
    public String getMessageCode(@PathVariable("tel") String tel, HttpServletResponse response){
        //SendsmsUtils sendsmsUtils = new SendsmsUtils();
        //String messageCode = sendsmsUtils.getMessageCode(tel);

        String messageCode = "123456";

        Cookie cookie = new Cookie("messageCode",messageCode);
        cookie.setMaxAge(180);
        cookie.setPath("/");
        response.addCookie(cookie);

        System.out.println("短信发送成功,验证码是:"+messageCode);
        return "success";
    }

    //手机快捷登录
    @ResponseBody
    @RequestMapping("/portalLogin")
    public String login(HttpServletRequest request,String tel,String messageCode,String password){

        String msCode = "";

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                if ("messageCode".equals(c.getName())) {
                    msCode = c.getValue();
                }
            }
        }

        System.out.println(password);

        if(msCode.equals(messageCode)) {
            System.out.println("调用service存入数据库");
            AjUser ajUser = null;
            ajUser = ajUserService.findByTel(tel);
            if (ajUser!=null) {//用户已经存在,直接登录
                System.out.println("用户已经存在,直接登录");
            } else {//用户不存在,需要添加,再登录
                System.out.println("用户不存在,需要添加,再登录");
                int i = ajUserService.addUser(tel,password);
                if (i == 1) {
                    System.out.println("添加成功!");
                    ajUser = ajUserService.findByTel(tel);
                } else {
                    System.out.println("添加失败!");
                }
            }
            //System.out.println(ajUser);
            //获取最后登录的时间,并且把时间存到session中
            Date lastloginTime = ajUser.getLastloginTime();
            ajUser.setLastloginTime(new Date());

            //把更新好的最后时间的对象存到数据库e中
            ajUserService.updateUser(ajUser);

            //把用户存到session中
            HttpSession session = request.getSession();
            session.setAttribute("ajUser",ajUser);
            session.setAttribute("lastloginTime",lastloginTime);


            return "0";
        }else{
            return "1";
        }
    }


    //账号密码登录
    @ResponseBody
    @RequestMapping("/portalLogin1")
    public String login1(String tel,String password,HttpServletRequest request) {

        AjUser ajUser = null;
        ajUser = ajUserService.findByTel(tel);
        if(ajUser==null){
            return "1";
        }else if(!password.equals(ajUser.getPassword())){
            return "2";
        }
        //获取最后登录的时间,并且把时间存到session中
        Date lastloginTime = ajUser.getLastloginTime();

        //把更新好的最后时间的对象存到数据库中
        ajUser.setLastloginTime(new Date());
        ajUserService.updateUser(ajUser);

        //把用户存到session中
        HttpSession session = request.getSession();
        session.setAttribute("ajUser",ajUser);
        session.setAttribute("lastloginTime",lastloginTime);

        return "0";
    }

    //用户注册
    @ResponseBody
    @RequestMapping("/portalRegester")
    public String regester(HttpServletRequest request,String tel,String messageCode,String password){

        String msCode = "";

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                if ("messageCode".equals(c.getName())) {
                    msCode = c.getValue();
                }
            }
        }

        if(msCode.equals(messageCode)) {
            System.out.println("调用service");
            AjUser ajUser = null;
            ajUser = ajUserService.findByTel(tel);
            if(ajUser==null){//用户不存在,需要注册,再登录
                System.out.println("用户不存在,需要注册,再登录");
                int i = ajUserService.addUser(tel,password);
                if (i == 1) {
                    System.out.println("注册成功!");
                    ajUser = ajUserService.findByTel(tel);
                    //获取最后登录的时间,并且把时间存到session中
                    Date lastloginTime = ajUser.getLastloginTime();
                    ajUser.setLastloginTime(new Date());

                    //把更新好的最后时间的对象存到数据库e中
                    ajUserService.updateUser(ajUser);

                    //把用户存到session中
                    HttpSession session = request.getSession();
                    session.setAttribute("ajUser",ajUser);
                    session.setAttribute("lastloginTime",lastloginTime);
                } else {
                    System.out.println("注册成功失败!");
                }
            }else{
                return "2"; //用户已经存在,不能再注册了
            }
            return "0";
        }else{
            return "1";
        }
    }


    //用户注销
    @ResponseBody
    @RequestMapping("/portalLogout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("ajUser");
        return "success";
    }


}
