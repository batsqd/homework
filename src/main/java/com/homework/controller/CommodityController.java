package com.homework.controller;

import com.homework.config.Configs;
import com.homework.model.Buyer;
import com.homework.model.Commodity;
import com.homework.model.PurchasedCommodity;
import com.homework.service.IBuyerService;
import com.homework.service.ICommodityService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Scope("prototype")
public class CommodityController {
    @Resource
    private ICommodityService commodityService;
    @Resource
    private IBuyerService iBuyerService;
    @RequestMapping("/getHomePageCommodity.action")
    public ModelAndView getHomePageCommodity(){
        System.out.println("进入getHomePageCommodity");
        byte mark=1;//mark=1 指示该商品需要置于主页
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session=request.getSession();
        Buyer buyer= (Buyer) session.getAttribute("buyer");
        ModelAndView modelAndView=new ModelAndView();
        String pagination="";
        if(buyer!=null){
            List<PurchasedCommodity> homePageCommodities=commodityService.selectCommoditiesHitPurchasedLabelList(buyer.getNickname(),0,Configs.pageSize);
            int commodityRecords=commodityService.selectCommodityRecords();
            int pageCount=commodityRecords%Configs.pageSize==0?commodityRecords/Configs.pageSize:commodityRecords/Configs.pageSize+1;

            /*
            int countRecords=commodityService.selectCommodityRecords();
            int buyerPurchasedRecords=iBuyerService.selectNumsDistinctCommodity(buyer.getNickname());
            int noPurchasedCommodityRecords=countRecords-buyerPurchasedRecords;
            int pageCount=noPurchasedCommodityRecords%Configs.pageSize==0?noPurchasedCommodityRecords/Configs.pageSize:noPurchasedCommodityRecords/Configs.pageSize+1;
           */
            modelAndView.addObject("pageCount",pageCount);
            modelAndView.addObject("pageNow",1);
            modelAndView.addObject("homePageCommoditiesHitPurchasedLabel",homePageCommodities);

        }else{
            /*
            List<Commodity> homePageCommodities =
                    commodityService.selectHomepageCommodities(mark);
                    */
            int commodityRecords=commodityService.selectCommodityRecords();
            int pageCount=(commodityRecords%Configs.pageSize==0)?commodityRecords/Configs.pageSize:commodityRecords/Configs.pageSize+1;
            List<Commodity> homePageCommodities=commodityService.selectCommosityList(0, Configs.pageSize);
            modelAndView.addObject("homePageCommodities",homePageCommodities);
            modelAndView.addObject("pageNow",1);
            modelAndView.addObject("pageCount",pageCount);
        }
        modelAndView.setViewName("homepage");
        return modelAndView;
    }

    @RequestMapping("/getHomePageCommodityPagination.action")
    public ModelAndView getHomePageCommodity(int pageNow){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session=request.getSession();
        Buyer buyer= (Buyer) session.getAttribute("buyer");
        ModelAndView modelAndView=new ModelAndView();
        int pos=(pageNow-1)*Configs.pageSize;
        if(buyer!=null){
            List<PurchasedCommodity> homePageCommodities=commodityService.selectCommoditiesHitPurchasedLabelList(buyer.getNickname(),pos,Configs.pageSize);
            int records=commodityService.selectCommoditiesHitPurchasedLabelRecords(buyer.getNickname());
            int pageCount=records%Configs.pageSize==0?records/Configs.pageSize:records/Configs.pageSize+1;
            modelAndView.addObject("pageCount",pageCount);
            modelAndView.addObject("pageNow",pageNow);
            modelAndView.addObject("homePageCommoditiesHitPurchasedLabel",homePageCommodities);
            modelAndView.setViewName("homepage");
            return modelAndView;
        }else{
            /*
            List<Commodity> homePageCommodities =
                    commodityService.selectHomepageCommodities(mark);
                    */
            int commodityRecords=commodityService.selectCommodityRecords();
            int pageCount=(commodityRecords%Configs.pageSize==0)?commodityRecords/Configs.pageSize:commodityRecords/Configs.pageSize+1;
            List<Commodity> homePageCommodities=commodityService.selectCommosityList(pos, Configs.pageSize);
            modelAndView.addObject("homePageCommodities",homePageCommodities);
            modelAndView.addObject("pageNow",pageNow);
            modelAndView.addObject("pageCount",pageCount);
            modelAndView.setViewName("homepage");
            return modelAndView;
        }

    }
    @RequestMapping("/noPurchasedCommodity.action")
    public ModelAndView noPurchasedCommodity(int pageNow){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session=request.getSession();
        Buyer buyer= (Buyer) session.getAttribute("buyer");
        ModelAndView modelAndView=new ModelAndView();
        int pos=(pageNow-1)*Configs.pageSize;
        //用户一定登录了才能进入这个函数
        if(buyer!=null) {
            List<PurchasedCommodity> noPurchasedCommodity = commodityService.selectNoPurchasedCommodity(buyer.getNickname(), pos, Configs.pageSize);

            int countRecords=commodityService.selectCommodityRecords();
            int buyerPurchasedRecords=iBuyerService.selectNumsDistinctCommodity(buyer.getNickname());
            int noPurchasedCommodityRecords=countRecords-buyerPurchasedRecords;
            int pageCount=noPurchasedCommodityRecords%Configs.pageSize==0?noPurchasedCommodityRecords/Configs.pageSize:noPurchasedCommodityRecords/Configs.pageSize+1;

            //int records = commodityService.selectCountRecordsNoPurchasedCommodity(buyer.getNickname());
           // int pageCount = records % Configs.pageSize == 0 ? records / Configs.pageSize : records / Configs.pageSize + 1;
            modelAndView.addObject("pageCount", pageCount);
            modelAndView.addObject("pageNow", pageNow);
            modelAndView.addObject("homePageCommoditiesHitPurchasedLabel", noPurchasedCommodity);
            modelAndView.addObject("noPurchasedCommodity",true);
            modelAndView.setViewName("homepage");
        }
        return modelAndView;
    }
    @RequestMapping("/commodityDetail.action")
    public ModelAndView   commodityDetail(int commodity_id){
        ModelAndView modelAndView = new ModelAndView();
        Commodity commodity = commodityService.selectCommodityDetail(commodity_id);
        modelAndView.addObject("commodity_detail",commodity);
        modelAndView.setViewName("commodityDetail");
        return modelAndView;
    }



}
