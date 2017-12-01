package com.aj.ajhouse.service;

import com.aj.ajhouse.pojo.po.AjDocsMenu;

import java.util.List;

public interface PortalDocMenuService {
    List<AjDocsMenu> listDocMenuByParentId(Integer parentid);
}
