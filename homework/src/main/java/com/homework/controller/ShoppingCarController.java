package com.homework.controller;

import com.homework.dao.IShoppingCarDao;
import com.homework.model.Buy;
import com.homework.model.Buyer;
import com.homework.model.CommodityInShoppingCar;
import com.homework.model.ShoppingCar;
import com.homework.service.ICommodityService;
import com.homework.service.IPublishService;
import com.homework.service.IShoppingCarService;
import com.homework.service.impl.ICommodityServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@Scope("prototype")
public class ShoppingCarController {
    @Resource
    private IShoppingCarService iShoppingCarService;
    @Resource
    private ICommodityService iCommodityService;
    @Resource
    private IPublishService iPublishService;
    @RequestMapping("/addCommodityToShoppingCar.action")
    public @ResponseBody HashMap<String,String> addCommodityToShoppingCar(int commodityId, int addShoppingCarCmdyNums){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session=request.getSession();
        String buyer_nickname ="";
        int numsOfCommoditiesInShoppingCar=0;
        HashMap<String,String> res=new HashMap<String,String>();
        if(session.getAttribute("buyer")!=null){
            buyer_nickname=((Buyer)session.getAttribute("buyer")).getNickname();
        }else{
            res.put("isLogin","no");
            return res;
        }

        ShoppingCar shoppingCar =new ShoppingCar();
        shoppingCar.setBuyer_nickname(buyer_nickname);
        shoppingCar.setCommodity_id(commodityId);
        shoppingCar.setCommodity_nums_add_to_shopping_car(addShoppingCarCmdyNums);

        try {
            iShoppingCarService.commodityAddToShoppingCar(shoppingCar);
            numsOfCommoditiesInShoppingCar=
                    iShoppingCarService.selectNumsOfCommoditiesInShoppingCar(buyer_nickname);
            res.put("numsOfCommoditiesInShoppingCar",numsOfCommoditiesInShoppingCar+"");
        }catch (DataAccessException ex){
            //捕获数据插入异常，
            res.put("dataSaveSucess","no");
            return res;
        }
        res.put("dataSaveSucess","yes");
        return res;
    }

    @RequestMapping("/mumsOfCommoditiesInShoppingCar.action")
    public @ResponseBody HashMap<String,String> mumsOfCommoditiesInShoppingCar(){
        HashMap<String,String> res =new HashMap<String,String>();
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session=request.getSession();
        String buyer_nickname ="";
        if(session.getAttribute("buyer")!=null){
            buyer_nickname=((Buyer)session.getAttribute("buyer")).getNickname();
            int mumsOfCommoditiesInShoppingCar=iShoppingCarService.selectNumsOfCommoditiesInShoppingCar(buyer_nickname);
            res.put("mumsOfCommoditiesInShoppingCar",mumsOfCommoditiesInShoppingCar+"");
        }else{
            res.put("mumsOfCommoditiesInShoppingCar","0");

        }
        return res;
    }

    @RequestMapping("/buyCommodities.action")
    public @ResponseBody HashMap<String,String> buyCommodities(int commodityId,int buynums,float price){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session=request.getSession();
        String buyer_nickname ="";
        HashMap<String,String> insertRes=new HashMap<String,String>();
        if(session.getAttribute("buyer")!=null){
            buyer_nickname=((Buyer)session.getAttribute("buyer")).getNickname();
        }else{
            insertRes.put("isLogin","no");
            return insertRes;
        }
        Buy buy =new Buy();
        buy.setBuyer_nickname(buyer_nickname);
        buy.setCommodity_id(commodityId);
        buy.setNums_buy(buynums);
        buy.setPrice_buy(price);
        try {
            iShoppingCarService.buyCommodities(buy);
            iPublishService.updateSellOutNums(buynums,commodityId);
            iCommodityService.updateCommodityInventory(commodityId,buynums);
        }catch(DataAccessException daex){
            insertRes.put("dataSaveSucess","no");
            return insertRes;
        }
        insertRes.put("dataSaveSucess","yes");
        return insertRes;
    }

    @RequestMapping("/deleteCommodityInShoppingCar.action")
    public @ResponseBody HashMap<String,String>deleteCommodityInShoppingCar(int shoppingCarId){
        HashMap<String,String> res=new HashMap<String,String>();
        try{
            iShoppingCarService.deleteCommodityInShoppingCar(shoppingCarId);
        }catch (DataAccessException dae){
            res.put("delRes","fail");
        }
        res.put("delRes","sucess");
        return res;
    }

    @RequestMapping("/goShoppingCar.action")
    public ModelAndView goShoppingCar(int pageNow){
        int pageSize=10;
        int pageCount=0;
        int pos=(pageNow-1)*pageSize;
        ModelAndView modelAndView=new ModelAndView();
        List<CommodityInShoppingCar> commodities=null;
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session=request.getSession();
        if(session.getAttribute("buyer")!=null){
           Buyer buyer= (Buyer) session.getAttribute("buyer");
            commodities=iShoppingCarService
                    .selectCommodityInShoppingCar(buyer.getNickname(),pos,pageSize);
            int commodityRecordsInCar=iShoppingCarService.selectCommodityRecordsInShoppingCar(buyer.getNickname());
            pageCount=commodityRecordsInCar%pageSize==0?(commodityRecordsInCar/pageSize):((commodityRecordsInCar/pageSize)+1);
            modelAndView.addObject("commodities",commodities);
            modelAndView.addObject("pageNow",pageNow);
            modelAndView.addObject("pageCount",pageCount);
            modelAndView.setViewName("shoppingCar");
        }else{
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
