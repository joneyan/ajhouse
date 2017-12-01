package com.aj.ajhouse.service.impl;

import com.aj.ajhouse.dao.AjHouseImagesMapper;
import com.aj.ajhouse.pojo.po.AjHouseImages;
import com.aj.ajhouse.pojo.po.AjHouseImagesExample;
import com.aj.ajhouse.service.AjHouseImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjHouseImagesServiceImpl implements AjHouseImagesService {

    @Autowired
    private AjHouseImagesMapper AjHouseImagesDao;

    @Override
    public List<AjHouseImages> getImages(int itemId) {

        AjHouseImagesExample ajHouseImagesExample = new AjHouseImagesExample();

        AjHouseImagesExample.Criteria criteria = ajHouseImagesExample.createCriteria();

        criteria.andHouseIdEqualTo(itemId);

        List<AjHouseImages> ajHouseImages = AjHouseImagesDao.selectByExample(ajHouseImagesExample);

        return ajHouseImages;
    }
}
