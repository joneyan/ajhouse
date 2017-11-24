package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.vo.AjCityCustom;

import java.util.List;
import java.util.Map;

public interface AjCityCustomMapper {
    /**
     * 查询城市中所有的数量
     * @param map
     * @return
     */
    int countCity(Map<String, Object> map);

    /**
     * 查询指定页码显示记录集合
     * @param map
     * @return
     */
    List<AjCityCustom> listCityByPage(Map<String, Object> map);

    /**
     * 查询所有
     * @return
     */
    List<AjCityCustom> listCity();


}
