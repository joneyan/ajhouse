package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjAdmin;
import com.aj.ajhouse.pojo.vo.AdminQuery;

import java.util.List;


public interface AdminService {

    AjAdmin findByAcountnum(AjAdmin ajAdmin);
    int addAdmin(AjAdmin ajAdmin);
    Result<AjAdmin> listAdminByPage(Page page, Order order, AdminQuery query);
    int update(AjAdmin ajAdmin);
    int updateBatch(List<Integer> ids);
    AjAdmin findById(int id);
}
