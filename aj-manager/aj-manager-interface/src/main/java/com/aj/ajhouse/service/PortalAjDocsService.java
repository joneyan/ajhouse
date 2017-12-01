package com.aj.ajhouse.service;

import com.aj.ajhouse.pojo.po.AjDocs;

import java.util.List;

public interface PortalAjDocsService {

    List<AjDocs> listDocById(Integer docid);

    AjDocs getDocContent(Integer docid);
}
