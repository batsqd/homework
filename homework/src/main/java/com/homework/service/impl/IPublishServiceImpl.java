package com.homework.service.impl;
import com.homework.dao.IPublishDao;
import com.homework.model.Publish;
import com.homework.model.PublishCommodity;
import com.homework.service.IPublishService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IPublishServiceImpl implements IPublishService{
   @Resource
   private IPublishDao iPublishDao;

    @Override
    public void insertPublishRecord(Publish publish) throws DataAccessException {
        iPublishDao.insertPublishRecord(publish);
    }

    @Override
    public List<PublishCommodity> selectPublishCommoodities(String seller_nickname,int pos,int nums) {
        return iPublishDao.selectPublishCommoodities(seller_nickname,pos,nums);
    }

    @Override
    public int selectPublishCommoditiesRecordsBySeller(String seller_nickname) {
        return iPublishDao.selectPublishCommoditiesRecordsBySeller(seller_nickname);
    }

    @Override
    public PublishCommodity selectPublishCommoditiesRecordsByCommodityId(int commodity_id) {
        return iPublishDao.selectPublishCommoditiesRecordsByCommodityId(commodity_id);
    }

    @Override
    public void deleteSellerPublish(String seller_nickname, int commodity_id) throws DataAccessException {
        iPublishDao.deleteSellerPublish(seller_nickname,commodity_id);
    }

    @Override
    public int selectCommoditySellOutNums(String seller_nickname, int commodity_id) {

        return iPublishDao.selectCommoditySellOutNums(seller_nickname,commodity_id);
    }

    @Override
    public int updateSellOutNums(int nums_buy, int commodity_id) throws DataAccessException {
        return iPublishDao.updateSellOutNums(nums_buy,commodity_id);
    }


}

