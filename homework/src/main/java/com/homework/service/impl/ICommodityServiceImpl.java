package com.homework.service.impl;

import com.homework.dao.ICommodityDao;
import com.homework.model.Commodity;
import com.homework.model.PurchasedCommodity;
import com.homework.service.ICommodityService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ICommodityServiceImpl implements ICommodityService{


    @Resource
    private ICommodityDao commodityDao;

    @Override
    public void insertCommodity(Commodity commodity) throws DataAccessException{
        commodityDao.insertCommodity(commodity);
    }

    @Override
    public void updateCommodityInfo(Commodity commodity) throws DataAccessException {
        commodityDao.updateCommodityInfo(commodity);
    }

    @Override
    public void updateCommodityImageLocation(int commodity_id, String image_link) {
        commodityDao.updateCommodityImageLocation(commodity_id,image_link);
    }

    @Override
    public void deleteCommodityByCommodityId(int commodity_id) throws DataAccessException {
        commodityDao.deleteCommodityByCommodityId(commodity_id);
    }

    @Override
    public void updateCommodityInventory(int commodity_id, int buyNums) throws DataAccessException{
        commodityDao.updateCommodityInventory(commodity_id,buyNums);
    }

    @Override
    public List<Commodity> selectHomepageCommodities(byte mark) {

        return commodityDao.selectHomepageCommodities(mark);
    }

    @Override
    public List<PurchasedCommodity> selectHomepageCommoditiesHitPurchasedLabel(String buyer_nickname) {
        return commodityDao.selectHomepageCommoditiesHitPurchasedLabel(buyer_nickname);
    }

    @Override
    public int selectCountRecordsNoPurchasedCommodity(String buyer_nickname) {
        return commodityDao.selectCountRecordsNoPurchasedCommodity(buyer_nickname);
    }

    @Override
    public List<PurchasedCommodity> selectNoPurchasedCommodity(String buyer_nickname, int pos, int nums) {
        return commodityDao.selectNoPurchasedCommodity(buyer_nickname,pos,nums);
    }

    @Override
    public List<Commodity> selectCommosityList(int pos, int nums) {
        return commodityDao.selectCommosityList(pos,nums);
    }

    @Override
    public List<PurchasedCommodity> selectCommoditiesHitPurchasedLabelList(String buyer_nickname, int pos, int nums) {
        return commodityDao.selectCommoditiesHitPurchasedLabelList(buyer_nickname,pos,nums);
    }

    @Override
    public int selectCommoditiesHitPurchasedLabelRecords(String buyer_nickname) {
        return  commodityDao.selectCommoditiesHitPurchasedLabelRecords(buyer_nickname);
    }

    @Override
    public int selectCommodityRecords() {
        return commodityDao.selectCommodityRecords();
    }

    @Override
    public List<Commodity> searchCommodities(String keyWord) {
        return commodityDao.searchCommodities(keyWord);
    }

    @Override
    public int countPageSearchCommodities() {
        int numsOfSearchRes=commodityDao.selectCountSearchCommodities();
        return numsOfSearchRes%12==0?(numsOfSearchRes/12):((numsOfSearchRes/12)+1);
    }

    @Override
    public List<Commodity> searchCommodities(HashMap<String, Object> parameter) {
        return commodityDao.selectCommodities(parameter);
    }

    @Override
    public Commodity selectCommodityDetail(int commodity_id) {
        return commodityDao.selectCommodityDetail(commodity_id);
    }
}
