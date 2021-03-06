package com.aj.ajhouse.web;

import com.aj.ajhouse.common.dto.Order;
import com.aj.ajhouse.common.dto.Page;
import com.aj.ajhouse.common.dto.Result;
import com.aj.ajhouse.pojo.po.AjDocs;
import com.aj.ajhouse.pojo.vo.AjDocsCustom;
import com.aj.ajhouse.service.AjDocsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
public class AjDocsAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AjDocsService ajDocsService;

    /**
     * 严静:新增文章
     * @param ajDocs  传入文章参数
     * @return
     */
    @ResponseBody
    @RequestMapping("/doc")
    public int saveDoc(AjDocs ajDocs){
        int i=0;
        try {
            ajDocsService.docAdd(ajDocs);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
    @ResponseBody
    @RequestMapping("/docs")
    public Result<AjDocsCustom> listDocByPage(Page page, Order order){
        Result<AjDocsCustom> result=null;
        try{
            result=ajDocsService.listDocByPage(page,order);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/docc/findedit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable("id") int id, Model model){
        try{
            AjDocsCustom ajDocs=ajDocsService.getEdit(id);
            System.out.println(ajDocs.getMenuname()+"222222222222222");
            model.addAttribute("ajdocs",ajDocs);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return "doc-edit";
    }

    /**
     * 严静：修改文档
     * @param ajDocs
     * @return
     */
    @ResponseBody
    @RequestMapping("/doc/update")
    public int modifyDoc(AjDocs ajDocs){
        System.out.println(ajDocs.getDocContent()+"dsfaf");
        int i=0;
        try{
            i=ajDocsService.modifyDoc(ajDocs);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
