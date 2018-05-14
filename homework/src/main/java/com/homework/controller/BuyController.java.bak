package com.homework.controller;

import com.homework.model.PurchasedCommodity;
import com.homework.model.Buyer;
import com.homework.service.IBuyService;
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
import java.util.HashMap;
import java.util.List;

@Controller
@Scope("prototype")
public class BuyController {

    @Resource
    private IBuyService iBuyService;

    @RequestMapping("purchasedCommodity.action")
    public ModelAndView purchasedCommodity(int pageNow){
        int pageSize=10;
        int pageCount=0;
        int pos=(pageNow-1)*pageSize;

        ModelAndView modelAndView=new ModelAndView();
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session=request.getSession();
        String buyer_nickname ="";
        if(session.getAttribute("buyer")!=null){
            buyer_nickname=((Buyer)session.getAttribute("buyer")).getNickname();
            List<PurchasedCommodity> purchasedCommodity=iBuyService.selectPurchasedCommodity(buyer_nickname,pos,pageSize);
            int recordsPurchasedCommodity=iBuyService.selectRecordsPurchasedCommodity(buyer_nickname);
            pageCount=(recordsPurchasedCommodity%pageSize)==0?(recordsPurchasedCommodity/pageSize):(recordsPurchasedCommodity/pageSize)+1;
            modelAndView.addObject("purchasedCommodity",purchasedCommodity);
            modelAndView.addObject("pageNow",pageNow);
            modelAndView.addObject("pageCount",pageCount);
            modelAndView.setViewName("purchasedCommodity");
        }else{
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }
    @RequestMapping("/deletePurchasedCommodityRecord.action")
    public @ResponseBody HashMap deletePurchasedCommodityRecord(int id) {
        HashMap<String, String> res = new HashMap<String, String>();
        //最好判断下用户没有登录，跳转值登录页面
        try {
            iBuyService.deletePurchasedCommodityRecord(id);
        } catch (DataAccessException dae) {
            res.put("delRes", "fail");
            return res;
        }
        res.put("delRes","sucess");
        return res;
    }
}
