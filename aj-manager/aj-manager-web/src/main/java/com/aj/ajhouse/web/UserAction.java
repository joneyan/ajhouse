package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjAdmin;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.UserQuery;
import com.aj.ajhouse.service.AjUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@Scope("prototype")
public class UserAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AjUserService ajUserService;

    //查询指定条件的用户
    @RequestMapping("/user")
    @ResponseBody
    public Result<AjUser> listUserByPage(Page page, Order order, UserQuery query){
        Result<AjUser> result = null;
        try{
                result = ajUserService.listUserByPage(page,order,query);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    //通过id找用户返回修改
    @RequestMapping("/userUpdate/{id}")
    public String findUserById(@PathVariable("id") int id , Model model){
        AjUser user = null;
        try {
            user = ajUserService.findById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        model.addAttribute("user", user);
        return "user-update";
    }

    //修改密码
    @ResponseBody
    @RequestMapping("/updateUser")
    public int updateUser(AjUser ajUser,HttpSession session){
        int mess = 0;
        try {
            AjAdmin admin =(AjAdmin) session.getAttribute("admin");
            ajUser.setOpratorId(admin.getId());
            mess = ajUserService.updateUser(ajUser);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return mess;
    }

}
