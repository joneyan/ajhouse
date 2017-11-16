package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjUser;

import java.util.List;
import java.util.Map;

public interface AjUserCustomMapper {

    int countUsers(Map<String,Object> map);

    List<AjUser> listUsersByPage(Map<String,Object> map);

}
