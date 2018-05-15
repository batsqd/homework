package com.homework.dao;

import com.homework.model.Commodity;
import com.homework.model.PurchasedCommodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;

public interface ICommodityDao {
    List<Commodity> selectHomepageCommodities(byte mark);
    List<PurchasedCommodity>selectHomepageCommoditiesHitPurchasedLabel(String buyer_nickname);
    List<Commodity> searchCommodities(String keyWord);
    List<Commodity> selectCommosityList(@Param("pos") int pos,@Param("nums") int nums);
    List<PurchasedCommodity> selectCommoditiesHitPurchasedLabelList(@Param("buyer_nickname") String buyer_nickname, @Param("pos") int pos,@Param("nums") int nums);
    List<PurchasedCommodity> selectNoPurchasedCommodity(@Param("buyer_nickname") String buyer_nickname, @Param("pos") int pos,@Param("nums") int nums);
    int selectCountRecordsNoPurchasedCommodity(String buyer_nickname);
    int selectCommoditiesHitPurchasedLabelRecords(String buyer_nickname);
    int selectCommodityRecords();
    int selectCountSearchCommodities();
    List<Commodity> selectCommodities(HashMap<String,Object> parameter);
    Commodity selectCommodityDetail(int commodity_id);
    void insertCommodity(Commodity commodity);
    void updateCommodityInfo(Commodity commodity) throws DataAccessException;
    void updateCommodityImageLocation(@Param("commodity_id") int commodity_id,
                                      @Param("image_link") String image_link)throws DataAccessException;
    void deleteCommodityByCommodityId(int commodity_id) throws DataAccessException;
    void updateCommodityInventory(@Param("commodity_id") int commodity_id,@Param("buyNums") int buyNums);
}
