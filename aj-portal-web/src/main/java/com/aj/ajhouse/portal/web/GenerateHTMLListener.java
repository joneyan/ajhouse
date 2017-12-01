package com.aj.ajhouse.portal.web;

import com.aj.ajhouse.common.util.JsonUtils;
import com.aj.ajhouse.pojo.po.AjHouse;
import com.aj.ajhouse.pojo.po.AjHouseImages;
import com.aj.ajhouse.pojo.po.AjHouseParamHouse;
import com.aj.ajhouse.pojo.vo.HouseInfo;
import com.aj.ajhouse.service.AjHouseImagesService;
import com.aj.ajhouse.service.AjHouseParamHouseService;
import com.aj.ajhouse.service.AjHouseService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateHTMLListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AjHouseService ajHouseService;
    @Autowired
    private AjHouseParamHouseService ajHouseParamHouseService;
    @Autowired
    private AjHouseImagesService ajHouseImagesService;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Override
    public void onMessage(Message message) {
        try {
            //1接收消息
            TextMessage textMessage = (TextMessage)message;
            String text = textMessage.getText();
            int itemId = Integer.parseInt(text);

            //2根据商品id查询房屋和商品信息
            AjHouse ajHouse = ajHouseService.getById(itemId);
            AjHouseParamHouse ajHouseParamHouse =  ajHouseParamHouseService.getByItemId(itemId);
            List<AjHouseImages> ajHouseImages = ajHouseImagesService.getImages(itemId);

            //讲查询出来的房屋详细信息json字符串转成对象
            String paramData = ajHouseParamHouse.getParamData();

            //3添加数据集
            Map<String, Object> dataModel = new HashMap<String, Object>();
            dataModel.put("item",ajHouse);
            dataModel.put("paramData", paramData);
            dataModel.put("ajHouseImages", ajHouseImages);

            //4获取freemarker的配置对象
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            Template template = configuration.getTemplate("ershoufang_xiangqing.ftl");
            Writer out = new FileWriter("e:/ft/"+itemId+".html");//d:\ft\123.html
            //生成静态页面
            template.process(dataModel,out);
            out.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
