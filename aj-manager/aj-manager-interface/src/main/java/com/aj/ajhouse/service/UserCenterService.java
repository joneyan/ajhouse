package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.AjUserCenterAns;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Author: yiyun
 * @Company:
 * @Package: com.aj.ajhouse.service
 * @Date: 2017-11-23
 * @Time: 22:15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public interface UserCenterService {

    Result<AjSysnews> getMessages(String tel, Map<String, Object> map);

    Result<AjQuestions> questMessages(String tel, Map<String, Object> map);

    Result<AjUserCenterAns> questAnsMessages(String tel, Map<String, Object> map);

    AjUser getUserMessages(AjUser u);

    int updataUser(Map<String, Object> map);

    int cephalicPhase(AjUser u, List<MultipartFile> images);

    String findUserByTel(Map<String, Object> map);
}
