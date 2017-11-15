package com.aj.ajhouse.service;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjDocs;
import com.aj.ajhouse.pojo.vo.AjDocsCustom;

public interface AjDocsService {

    int docAdd(AjDocs ajdocs);

    Result<AjDocsCustom> listDocByPage(Page page, Order order);
}
