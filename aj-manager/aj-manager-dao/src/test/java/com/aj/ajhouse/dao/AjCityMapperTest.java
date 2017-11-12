package com.aj.ajhouse.dao;

import com.aj.ajhouse.pojo.po.AjCity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao-test.xml")
public class AjCityMapperTest {
    @Autowired
    private AjCityMapper cityMapper;
    @Test
    public void testSelectByPrimaryKey() throws Exception {
        //System.out.print(cityMapper);
        //System.out.print("332232332");
        AjCity ajCity = cityMapper.selectByPrimaryKey(1);
        System.out.print(ajCity.getName());
    }

}