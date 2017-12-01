package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.common.util.FtpUtils;
import com.aj.ajhouse.common.util.IDUtils;
import com.aj.ajhouse.common.util.PropKit;
import com.aj.ajhouse.dao.AjHouseCustomMapper;
import com.aj.ajhouse.dao.AjHouseImagesMapper;
import com.aj.ajhouse.dao.AjHouseMapper;
import com.aj.ajhouse.dao.AjHouseParamHouseMapper;
import com.aj.ajhouse.pojo.po.AjHouse;
import com.aj.ajhouse.pojo.po.AjHouseExample;
import com.aj.ajhouse.pojo.po.AjHouseImages;
import com.aj.ajhouse.pojo.po.AjHouseParamHouse;
import com.aj.ajhouse.pojo.vo.AjHouseQuery;
import com.aj.ajhouse.service.AjHouseService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AjHouseServiceImpl implements AjHouseService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjHouseMapper ajHouseDao;
    @Autowired
    private AjHouseImagesMapper ajHouseImagesDao;
    @Autowired
    private AjHouseParamHouseMapper ajHouseParamHouseDao;
    @Autowired
    private AjHouseCustomMapper ajHouseCustomDao;

    /**
     * 严静：存储发布的房屋，并且将房屋的图片发不到远程图片服务器上，选择一张图片的地址存到数据库，
     * @param ajHouse
     * @param images
     * @return
     */
    @Transactional
    @Override
    public int addHouse(AjHouse ajHouse,String paramData, List<MultipartFile> images) {

        int houseId=0;
        int i = 0;
        try{
            //图片的地址，存入数据库
            String houseimageaddress="http://101.132.176.163/images/ajhouse/houseimage";
            //房屋id
            int id=(int)(Math.random()*65535)+1;
            houseId = id;
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

                    ajHouse.setCreatetime(new Date());
                    ajHouse.setUpdatetime(new Date());
                    System.out.println(id);
                    ajHouse.setId(id);
                    //存入一张图片地址
                    ajHouse.setImage(houseimageaddress);
                    ajHouse.setStatus(1);
                     i = ajHouseDao.insert(ajHouse);
                    //想房屋参数里存入数据
                    AjHouseParamHouse ajHouseParamHouse = new AjHouseParamHouse();
                    ajHouseParamHouse.setHouseId(id);
                    ajHouseParamHouse.setParamData(paramData);
                    ajHouseParamHouse.setCreatetime(new Date());
                    ajHouseParamHouse.setUpdatetime(new Date());
                    i+= ajHouseParamHouseDao.insert(ajHouseParamHouse);
                }
                //新建一个AjHouseImage实体类
                AjHouseImages ajHouseImage = new AjHouseImages();
                //向实体类中添加图片地址和所属房屋id
                ajHouseImage.setHouseId(id);
                ajHouseImage.setPic(houseimageaddress);
                //将所添加的图片存入数据库aj_house_images表
                i+=ajHouseImagesDao.insert(ajHouseImage);
            }

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return houseId;
    }

    @Override
    public Result<AjHouse> listHouseByPage(Page page, Order order, AjHouseQuery query) {
        Result<AjHouse> result=null;
        try{
            Map<String, Object> map = new HashMap<>();
            map.put("page",page);
            map.put("order",order);
            map.put("query",query);
            result= new Result<AjHouse>();
            int total=ajHouseCustomDao.countHouses();

            result.setTotal(total);
            List<AjHouse> list=ajHouseCustomDao.listHouseByPage(map);

            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }
    @Transactional
    @Override
    public int stopHouse(List<Integer> ids) {
        int i=0;
        try{
            AjHouse ajHouse = new AjHouse();
            ajHouse.setStatus(2);
            AjHouseExample example = new AjHouseExample();
            AjHouseExample.Criteria criteria = example.createCriteria();
            for (int j=0;j<ids.size();j++){
                criteria.andIdEqualTo(ids.get(j));
               i+= ajHouseDao.updateByExampleSelective(ajHouse,example);
            }
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public AjHouse getById(int itemId) {
        AjHouse ajHouse=null;
        try {
            ajHouse = ajHouseDao.selectByPrimaryKey(itemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ajHouse;
    }
}
