package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.MessageResult;
import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjHouse;
import com.aj.ajhouse.pojo.vo.AjHouseQuery;
import com.aj.ajhouse.service.AjHouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.List;

@Controller
public class AjHouseAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjHouseService ajHouseService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource
    private Destination topicDestination;

    @ResponseBody
    @RequestMapping("/house")
    public MessageResult addHouse(AjHouse ajHouse, String paramData,@RequestParam("images[]")List<MultipartFile> images){
        MessageResult messageResult = new MessageResult();
        try{
            //1 保存商品
            final int houseId = ajHouseService.addHouse(ajHouse, paramData,images);
            //2 发送消息
            jmsTemplate.send(topicDestination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    TextMessage textMessage = session.createTextMessage(houseId + "");
                    return textMessage;
                }
            });
            messageResult.setSuccess(true);
            messageResult.setMessage("新增房屋信息成功");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return messageResult;
    }

    @ResponseBody
    @RequestMapping("/houses")
    public Result<AjHouse> listHouseByPage(Page page, Order order,AjHouseQuery query){
        Result<AjHouse> list=null;
        try{
            list=ajHouseService.listHouseByPage(page,order,query);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/house/batchstop")
    public int stopHouse(@RequestParam("ids[]") List<Integer> ids){
        int i=0;
        try{
           i= ajHouseService.stopHouse(ids);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
