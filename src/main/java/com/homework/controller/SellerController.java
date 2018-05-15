package com.homework.controller;

import com.homework.model.PublishCommodity;
import com.homework.model.Seller;
import com.homework.service.ICommodityService;
import com.homework.service.IPublishService;
import com.homework.service.IShoppingCarService;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@Scope("prototype")
public class SellerController {
    @Resource
    private IPublishService iPublishService;
    @Resource
    private ICommodityService iCommodityService;
    @Resource
    private IShoppingCarService iShoppingCarService;

    @RequestMapping("/sellerEditCommodity.action")
    public ModelAndView sellEditContent(int commodity_id){
        ModelAndView modelAndView=new ModelAndView();
        PublishCommodity publishCommodity=iPublishService.selectPublishCommoditiesRecordsByCommodityId(commodity_id);
        modelAndView.addObject("publishCommodity",publishCommodity);
        modelAndView.setViewName("sellerEditCommodity");
        return modelAndView;
    }

    @RequestMapping("/sellerManage.action")
    public ModelAndView sellerManage(int pageNow){
        int pageSize=10;
        int pageCount=0;
        int pos=(pageNow-1)*pageSize;
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session=request.getSession();
        //用户肯定登录了
        Seller seller=(Seller) session.getAttribute("seller");
        String seller_nickname=seller.getNickname();
        int publishCommoditiesRecordsBySeller=iPublishService.selectPublishCommoditiesRecordsBySeller(seller_nickname);
        pageCount=(publishCommoditiesRecordsBySeller%pageSize==0)?publishCommoditiesRecordsBySeller/10:publishCommoditiesRecordsBySeller/10+1;
        ModelAndView modelAndView=new ModelAndView();
        List<PublishCommodity> publishCommodities=iPublishService.selectPublishCommoodities(seller_nickname,pos,pageSize);
        modelAndView.addObject("publishCommodities",publishCommodities);
        modelAndView.addObject("pageNow",pageNow);
        modelAndView.addObject("pageCount",pageCount);
        modelAndView.setViewName("sellerManage");
        return modelAndView;
    }
    @RequestMapping("/deletePublish.action")
    public @ResponseBody HashMap<String,String> deletePublish(int commodity_id){
        HashMap<String,String> res=new HashMap<String,String>();
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session=request.getSession();
        Seller seller= (Seller) session.getAttribute("seller");
        int sell_out_nums=iPublishService.selectCommoditySellOutNums(seller.getNickname(),commodity_id);
        if(sell_out_nums>0){
            res.put("notAllow","This record is not allowed to be deleted");
            return res;
        }
        boolean exception=false;
        try{
            //这里可以借助数据库，删除主表数据，从表自动删除，暂不考虑
            //删除用户的购物车
            iShoppingCarService.deleteCommodityInCarByCommodityId(commodity_id);
            iPublishService.deleteSellerPublish(seller.getNickname(),commodity_id);
            //考虑事务，两条记录操作同时成功
            iCommodityService.deleteCommodityByCommodityId(commodity_id);
            //不要忘记删除图片
        }catch (DataAccessException dae){
            res.put("fail","operation failed !");
            exception=true;
        }finally {
            if (!exception){
                res.put("sucess","Successful operation");
            }
        }
        return res;
    }
    @RequestMapping("/sellerPublish.action")
    public void sellerPublish(HttpServletRequest request , HttpServletResponse response){
        try {
            request.getRequestDispatcher("/WEB-INF/views/sellerPublish.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
