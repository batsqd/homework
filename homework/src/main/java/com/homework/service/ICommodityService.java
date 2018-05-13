package com.homework.service;

import com.homework.model.Commodity;
import com.homework.model.PurchasedCommodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;

public interface ICommodityService {
     List<Commodity> selectHomepageCommodities(byte mark);
     List<PurchasedCommodity> selectHomepageCommoditiesHitPurchasedLabel(String buyer_nickname);
     int selectCountRecordsNoPurchasedCommodity(String buyer_nickname);
     List<PurchasedCommodity> selectNoPurchasedCommodity( String buyer_nickname,int pos,int nums);
     List<Commodity> selectCommosityList(int pos,int nums);
     List<PurchasedCommodity> selectCommoditiesHitPurchasedLabelList(String buyer_nickname, int pos, int nums);
     int selectCommoditiesHitPurchasedLabelRecords(String buyer_nickname);
     int selectCommodityRecords();
     List<Commodity> searchCommodities(String keyWord);
     int countPageSearchCommodities();
     List<Commodity> searchCommodities(HashMap<String,Object> parameter);
     Commodity selectCommodityDetail(int commodity_id);
     void insertCommodity(Commodity commodity)throws DataAccessException;
     void updateCommodityInfo(Commodity commodity)throws DataAccessException;
     void updateCommodityImageLocation(int commodity_id,String image_link);
     void deleteCommodityByCommodityId(int commodity_id) throws DataAccessException;
     void updateCommodityInventory(int commodity_id,int buyNums)throws DataAccessException;
}
