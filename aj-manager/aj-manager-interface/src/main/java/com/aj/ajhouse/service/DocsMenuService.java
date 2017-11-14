package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.common.dto.TreeNode;
import com.aj.ajhouse.pojo.po.AjDocsMenu;
import com.aj.ajhouse.pojo.vo.AjDocsMenuQuery;
import com.aj.ajhouse.pojo.vo.AjDocsMenuView;

import java.util.List;


public interface DocsMenuService {
    Result<AjDocsMenuView> listMenuByPage(Page page, Order order, AjDocsMenuQuery query);

    List<AjDocsMenu> listParent();

    List<TreeNode> listDocMenuByPid(Integer parentid);

}
