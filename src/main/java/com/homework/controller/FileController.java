package com.homework.controller;

import com.homework.config.Configs;
import com.homework.model.Commodity;
import com.homework.model.Publish;
import com.homework.model.Seller;
import com.homework.service.ICommodityService;
import com.homework.service.IPublishService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;

@Controller
public class FileController {
    @Resource
    private IPublishService iPublishService;
    @Resource
    private ICommodityService iCommodityService;

    @RequestMapping(value="/uploadCommodityData.action",method = RequestMethod.POST)
    public @ResponseBody HashMap<String,String> uploadCommodityData(@Param("file") MultipartFile file,
                                                            @Param("title") String title, @Param("cur_price") float cur_price,
                                                            @Param("commodity_abstract") String commodity_abstract, @Param("full_text") String full_text,
                                                            @Param("inventory") int inventory,HttpServletRequest request){


        HttpSession session=request.getSession();
        Seller seller= (Seller) session.getAttribute("seller");
        HashMap<String,String> res=new HashMap<String,String>();
        boolean isUplode=true;
        System.out.println("title: "+title+"cur_price "+cur_price+" commodity_abstract"+commodity_abstract+" "+full_text+" "+inventory);
            try {
                //这里应该需要回滚，暂时不考虑
                Commodity commodity=new Commodity();
                commodity.setCommodity_abstract(commodity_abstract);
                commodity.setCur_price(cur_price);
                commodity.setFull_text(full_text);
                commodity.setTitle(title);
                commodity.setImage_link("");
                commodity.setInventory(inventory);
                iCommodityService.insertCommodity(commodity);
                System.out.println(commodity.getCommodity_id()+"title: "+title+"cur_price "+cur_price+" commodity_abstract"+commodity_abstract+" "+full_text+" "+inventory);

                String image_link=Configs.images_loction_prefix +commodity.getCommodity_id()+".jpg";
                iCommodityService.updateCommodityImageLocation(commodity.getCommodity_id(),image_link);

                //将数据插入publish
                Publish publish=new Publish();
                publish.setCommodity_id(commodity.getCommodity_id());
                publish.setSeller_nickname(seller.getNickname());
                //注意异常处理
                iPublishService.insertPublishRecord(publish);
                String fileName=commodity.getCommodity_id()+".jpg";
                String imagePath=request.getSession().getServletContext().getRealPath("/images");
                File dir=new File(imagePath,fileName);
                if(dir.exists()){
                    System.out.println("删除原来的图片...");
                    dir.delete();
                }
                dir.mkdirs();
                file.transferTo(dir);
            } catch (Exception e) {
                System.out.println("异常："+e.getMessage());
                res.put("fail","Data saving failure...");
                isUplode=false;
            }finally {
                if(isUplode==true){
                    res.put("sucess","sucess");
                }
            }
        return res;
    }


    @RequestMapping(value = "/updateCommodityData.action" ,method = RequestMethod.POST)
    public @ResponseBody HashMap<String,String> updateCommodityData(@Param("file") MultipartFile file,
                                                      @Param("title") String title, @Param("cur_price") float cur_price,@Param("commodity_id") int commodity_id,
                                                      @Param("commodity_abstract") String commodity_abstract, @Param("full_text") String full_text,
                                                      @Param("inventory") int inventory,HttpServletRequest request){
        HashMap<String,String> res=new HashMap<String,String>();
        String fileName=commodity_id+".jpg";
        String image_link=Configs.images_loction_prefix + fileName;
        String imagePath=request.getSession().getServletContext().getRealPath("/images");
        File dir=new File(imagePath,fileName);
        boolean isUpload=true;
        System.out.println("title: "+title+"cur_price "+cur_price+" commodity_abstract"+commodity_abstract+" "+full_text+" "+inventory+" "+image_link);
            try {
                if (dir.exists()){
                    //一定存在
                    dir.delete();
                }
                dir.mkdirs();
                //这里应该需要回滚，暂时不考虑
                //图片上传
                file.transferTo(dir);
                //修改commodity
                Commodity commodity=new Commodity();
                commodity.setCommodity_id(commodity_id);
                commodity.setTitle(title);
                commodity.setInventory(inventory);
                commodity.setImage_link(image_link);
                commodity.setCur_price(cur_price);
                commodity.setFull_text(full_text);
                commodity.setCommodity_abstract(commodity_abstract);
                iCommodityService.updateCommodityInfo(commodity);
            } catch (Exception e) {
                res.put("fail","Data saving failure...");
                isUpload=false;
            }finally {
                if(isUpload==true){
                    res.put("sucess","sucess");
                }
            }
            return res;
    }
}
