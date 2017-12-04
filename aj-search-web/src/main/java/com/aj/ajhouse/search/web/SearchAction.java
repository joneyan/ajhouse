package com.aj.ajhouse.search.web;

import com.aj.ajhouse.common.dto.PageBean;
import com.aj.ajhouse.pojo.vo.AjHouseSearchCustom;
import com.aj.ajhouse.pojo.vo.AjHouseSearchCustom2;
import com.aj.ajhouse.service.AjHouseSolrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AjHouseSolrService ajHouseSolrService;

    @RequestMapping("/searchHouse/rs{keyword}/pg{page}")
    public String listHouse(@PathVariable("keyword") String keyword,
                            @PathVariable("page") Integer page, Model model){
        try {
            if (keyword != null) {
                keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");
                //从solr索引库中查询商品
                PageBean<AjHouseSearchCustom2> result = ajHouseSolrService.listHouseByPage(keyword,page,20);
                //把结果传递给页面
                model.addAttribute("query", keyword);
                model.addAttribute("totalPages", result.getTotalPage());
                model.addAttribute("page", page);
                model.addAttribute("recourdCount", result.getTotalCount());
                model.addAttribute("itemList", result.getList());
            }
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return "search";
    }
}
