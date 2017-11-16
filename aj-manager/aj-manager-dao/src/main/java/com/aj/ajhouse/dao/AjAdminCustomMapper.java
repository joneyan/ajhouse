package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjAdmin;

import java.util.List;
import java.util.Map;

public interface AjAdminCustomMapper {

    AjAdmin selectByAcountnum(String acountnum);
    int countAdmins(Map<String,Object> map);
    List<AjAdmin> listAdminsByPage(Map<String,Object> map);
    int updateAdmin(AjAdmin ajAdmin);

}
