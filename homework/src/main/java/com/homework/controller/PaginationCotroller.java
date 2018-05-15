package com.homework.controller;

import com.homework.model.Commodity;
import com.homework.service.ICommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@Scope("prototype")
public class PaginationCotroller {
    private int pageSize =12;
    private int pageCount;
    private int begin;
    private int end;

    @Resource
    private ICommodityService iCommodityService;
    private final static Logger logger = LoggerFactory.getLogger(PaginationCotroller.class);
    @RequestMapping("/searchCommodities.action")
    public ModelAndView searchCommodities(String keyWord){
        logger.debug("keyWord="+keyWord);
        List<Commodity> commodities =
                iCommodityService.searchCommodities(keyWord);
        int pageCount=iCommodityService.countPageSearchCommodities();
        String pageNow ="1";
        String nextPage="";
        String page_turning="";
        if(pageCount>1){
            nextPage=String.format("<a href='%s?pageNow=%s&keyWord=%s'>下一页</a>",
                    "http://localhost:8080/homework/nextPage.action",pageNow,keyWord);
        }
        page_turning="共"+pageCount+"页，"+nextPage;
        ModelAndView modelAndView =new ModelAndView();
        if(commodities.size()>0){
            modelAndView.addObject("homePageCommodities",commodities);
            modelAndView.addObject("page_turning",page_turning);
        }
        modelAndView.setViewName("homepage");
        return modelAndView;

    }
    @RequestMapping("/nextPage.action")
    public ModelAndView nextPage(int pageNow,String keyWord){
        HashMap<String,Object> parameter=new HashMap<String,Object>();
        int pageSize=12;
        int begin=pageNow * pageSize;
        int incr=pageSize;
        int pageCount=iCommodityService.countPageSearchCommodities();
        ModelAndView modelAndView = new ModelAndView();
        String nextPage="";
        String pre_page="";
        StringBuilder page_turning=new StringBuilder();
        parameter.put("begin",begin);
        parameter.put("incr",incr);
        parameter.put("keyWord",keyWord);
        List<Commodity> homePageCommodities= iCommodityService.searchCommodities(parameter);
        page_turning.append("共"+pageCount+"页");

        if(pageNow>=1){
            pre_page=String.format("<a href='%s?pageNow=%s&keyWord=%s'>上一页</a>",
                    "http://localhost:8080/homework/nextPage.action",(pageNow-1),keyWord);
            page_turning.append(","+pre_page);
        }
        if(pageNow<(pageCount-1)){
            nextPage=String.format("<a href='%s?pageNow=%s&keyWord=%s'>下一页</a>",
                    "http://localhost:8080/homework/nextPage.action",(pageNow+1),keyWord);
            page_turning.append(","+nextPage);
        }
        if(homePageCommodities.size()>0){
            modelAndView.addObject("homePageCommodities",homePageCommodities);
            modelAndView.addObject("page_turning",page_turning);
        }
        modelAndView.setViewName("homepage");
        return modelAndView;
    }


}
