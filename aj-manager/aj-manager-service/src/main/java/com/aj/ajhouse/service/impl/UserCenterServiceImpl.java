package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.common.util.FtpUtils;
import com.aj.ajhouse.common.util.IDUtils;
import com.aj.ajhouse.common.util.PropKit;
import com.aj.ajhouse.dao.AjUserCenterCustom;
import com.aj.ajhouse.dao.AjUserMapper;
import com.aj.ajhouse.pojo.po.*;
import com.aj.ajhouse.pojo.vo.AjUserCenterAns;
import com.aj.ajhouse.service.UserCenterService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yiyun
 * @Company:
 * @Package: com.aj.ajhouse.service.impl
 * @Date: 2017-11-23
 * @Time: 22:16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
@Service
public class UserCenterServiceImpl implements UserCenterService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjUserCenterCustom userCenterCustomDao;
    @Autowired
    private AjUserMapper AjUserMapper;

    @Override
    public Result<AjSysnews> getMessages(String tel , Map<String,Object> map) {
        Result<AjSysnews> result = null;
        try {
            //0 创建一个Map封装前台传递过来的参数
            map = new HashMap<String, Object>();
            map.put("tel", tel);
            //1 创建一个响应参数实体类
            result = new Result<AjSysnews>();
            //2 对total进行设值(符合条件的总记录数)
            int total = userCenterCustomDao.countSysnew(map);

            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
            List<AjSysnews> list = userCenterCustomDao.listSysnew(map);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<AjQuestions> questMessages(String tel, Map<String, Object> map) {
        Result<AjQuestions> result = null;
        try {
            //手机号对应的用户id
            int id=0;
            AjUser ajUser = new AjUser();
            ajUser.setTel(tel);
            id=userCenterCustomDao.findUserByTel(ajUser);
            //0 创建一个Map封装前台传递过来的参数
            map = new HashMap<String, Object>();
            map.put("id", id);
            //1 创建一个响应参数实体类
            result = new Result<AjQuestions>();
            //2 对total进行设值(符合条件的总记录数)
            List<AjQuestions> list = userCenterCustomDao.questMessages(map);

//            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
//            List<AjQuestions> list = userCenterCustomDao.listSysnew(map);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<AjUserCenterAns> questAnsMessages(String tel, Map<String, Object> map) {
        Result<AjUserCenterAns> result = null;
        try {
            //手机号对应的用户id
            int id=0;
            AjUser ajUser = new AjUser();
            ajUser.setTel(tel);
            id=userCenterCustomDao.findUserByTel(ajUser);
            //0 创建一个Map封装前台传递过来的参数
            map = new HashMap<String, Object>();
            map.put("id", id);
            //1 创建一个响应参数实体类
            result = new Result<AjUserCenterAns>();
            //2 对total进行设值(符合条件的总记录数)
            List<AjUserCenterAns> list = userCenterCustomDao.questAnsMessages(map);

//            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
//            List<AjUserCenterAns> list = userCenterCustomDao.listSysnew(map);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public AjUser getUserMessages(AjUser u) {
            int id=0;
        try {
             id = userCenterCustomDao.findUserByTel(u);
             u= AjUserMapper.selectByPrimaryKey(id);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }


        return u;

    }

    @Override
    public int updataUser(Map<String, Object> map) {
        int id=0;
        try {
            id = userCenterCustomDao.updataUser(map);

            return 1;
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return 0;

    }

    @Override
    public int cephalicPhase(AjUser u, List<MultipartFile> images) {

        int i=0;
        try{
            //图片的地址，存入数据库
            String houseimageaddress="http://101.132.176.163/images/ajhouse/cephalicPhase";
            //房屋id
            int id=(int)(Math.random()*65535)+1;
            String name="ftp-house.properties";
            String host = PropKit.use(name).get("ftp.address");
            int port = PropKit.use(name).getInt("ftp.port");
            String username = PropKit.use(name).get("ftp.username");
            String password = PropKit.use(name).get("ftp.password");
            String basePath = PropKit.use(name).get("ftp.basePath");
            //创建文件路径：基础路径+文件路径+文件名+扩展名
            String filePath = new DateTime().toString("/yyyy/MM/dd");
            for(int j=0;j<images.size();j++){
                //获取原文件名
                String originalFilename = images.get(j).getOriginalFilename();
                //截取出原文件扩展名
                String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
                String newName= IDUtils.genImageName();
                newName+=fileType;
                InputStream inputStream=null;
                try{
                    inputStream = images.get(j).getInputStream();
                }catch (Exception e){
                    logger.error(e.getMessage(),e);
                    e.printStackTrace();
                }
                boolean bool = FtpUtils.uploadFile(host, port, username, password, basePath, filePath, newName, inputStream);
                System.out.println(bool);
                if(j==0){
                    houseimageaddress=houseimageaddress+filePath+"/"+newName;
                    Map<String, Object> map = new HashMap<>();

                    //存入一张图片地址
                    u.setPhoto(houseimageaddress);
                    if (  u.getPhoto()==null ||("").equals(u.getPhoto())){
                        u.setPhoto("http://101.132.176.163:80/images/lianjiaim_noagent.png");
                    }
                    map.put("tel",u.getTel());
                    map.put("photo",u.getPhoto());
                   i= userCenterCustomDao.cephalicPhase(map);
                }

            }

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public String findUserByTel(Map<String, Object> map) {
        int id=0;
        try {
            return userCenterCustomDao.findUserPhotoByTel(map);


        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return "";
    }

}
