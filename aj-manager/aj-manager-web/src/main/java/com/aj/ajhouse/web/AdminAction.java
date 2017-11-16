package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjAdmin;
import com.aj.ajhouse.pojo.vo.AdminQuery;
import com.aj.ajhouse.service.AdminService;
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
import java.util.Date;
import java.util.List;

@Controller
@Scope("prototype")
public class AdminAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminService adminService;

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public int login(AjAdmin ajAdmin,HttpSession session){
        int mess = 0;
        try{
            if (ajAdmin!=null){
                if (ajAdmin.getAcountnum().equals("")){
                    mess=0;//账户名不为空
                }else if (ajAdmin.getPassword().equals("")){
                    mess=1;//密码不能为空
                }else{
                    AjAdmin admin = null;
                    try {
                        admin = adminService.findByAcountnum(ajAdmin);
                        if (admin==null){
                            mess = 2;//账户名不存在
                        }else if (!admin.getIsUse()){
                            mess = 3;//账户不可用
                        }else if (!admin.getPassword().equals(ajAdmin.getPassword())){
                            mess = 4;//账户名与密码不一致
                        }else if(admin.getRoleId()==1){
                            mess = 5;//管理员登录成功
                            session.setAttribute("admin",admin);
                        }else{
                            mess = 6;//超级管理员登录成功
                            session.setAttribute("admin",admin);
                        }
                    }catch (Exception e){
                        logger.error(e.getMessage(), e);
                        e.printStackTrace();
                    }
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return mess;
    }

    //退出
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("admin");
        return "login";
    }

    //新增管理员
    @RequestMapping("/addAdmin")
    @ResponseBody
    public int addAdmin(AjAdmin ajAdmin){
        int mess = 0;
        ajAdmin.setCreateTime(new Date());
        try{
            mess = adminService.addAdmin(ajAdmin);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return mess;
    }

    //指定条件查询管理员
    @RequestMapping("/admin")
    @ResponseBody
    public Result<AjAdmin> listAjAdminByPage(Page page, Order order, AdminQuery query){
        Result<AjAdmin> result = null;
        try{
            result = adminService.listAdminByPage(page,order,query);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    //修改管理员资料
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public int  updateAjAdmin(AjAdmin ajAdmin,HttpSession session){
        int i = 0;
        try{
            ajAdmin.setUpdateTime(new Date());
            AjAdmin admin =new AjAdmin();
            admin = (AjAdmin)session.getAttribute("admin");
            ajAdmin.setOperatorId(admin.getId());
            i = adminService.update(ajAdmin);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    //删除用户
    @ResponseBody
    @RequestMapping("/admin/batch")
    public int removeAdmin(@RequestParam("ids[]") List<Integer> ids){
        int i = 0;
        try {
            i = adminService.updateBatch(ids);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    //通过id找管理员
    @RequestMapping("/adminUpdate/{id}")
    public String findAdminById(@PathVariable("id") int id , Model model){
        AjAdmin ajAdmin = null;

        try {
            ajAdmin = adminService.findById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        model.addAttribute("ajAdmin", ajAdmin);
        return "admin-update";
    }

}
