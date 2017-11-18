package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.vo.AjReginsCustom;

import java.util.List;
import java.util.Map;

public interface AjReginsCustomMapper {
    /**
     * 查询城市中所有的数量
     * @param map
     * @return
     */
    int countRegins(Map<String,Object> map);

    /**
     * 查询指定页码显示记录集合
     * @param map
     * @return
     */
    List<AjReginsCustom> listReginsByPage(Map<String,Object> map);

    void updateByCityIds(List ids);
}
