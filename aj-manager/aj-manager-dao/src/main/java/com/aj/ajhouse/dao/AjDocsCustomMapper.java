package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.vo.AjDocsCustom;

import java.util.HashMap;
import java.util.List;

public interface AjDocsCustomMapper {
    int countItems();

    List<AjDocsCustom> listDocByPage(HashMap<String, Object> map);


    List<AjDocsCustom> selectByExampleWithBLOBs(int id);
}
