package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjQuestionAns;
import com.aj.ajhouse.pojo.po.AjQuestions;
import com.aj.ajhouse.pojo.po.AjSysnews;
import com.aj.ajhouse.pojo.po.AjUser;
import com.aj.ajhouse.pojo.vo.AjUserCenterAns;

import java.util.List;
import java.util.Map; /**
 * @Author: yiyun
 * @Company:
 * @Package: com.aj.ajhouse.dao
 * @Date: 2017-11-25
 * @Time: 9:22
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public interface AjUserCenterCustom {

    int countSysnew(Map<String, Object> map);

    List<AjSysnews> listSysnew(Map<String, Object> map);


    int findUserByTel(AjUser ajUser);

    List<AjQuestions> questMessages(Map<String, Object> map);

    List<AjUserCenterAns> questAnsMessages(Map<String, Object> map);

    int updataUser(Map<String, Object> map);

    int cephalicPhase(Map<String, Object> map);

    String findUserPhotoByTel(Map<String, Object> map);
}
