package com.homework.service;

import com.homework.model.Publish;
import com.homework.model.PublishCommodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface IPublishService {
    void insertPublishRecord(Publish publish) throws  DataAccessException;
    List<PublishCommodity> selectPublishCommoodities(String seller_nickname,int pos, int nums);
    int selectPublishCommoditiesRecordsBySeller(String seller_nickname);
    PublishCommodity selectPublishCommoditiesRecordsByCommodityId(int commodity_id);
    void deleteSellerPublish(String seller_nickname,int commodity_id) throws DataAccessException;
    int selectCommoditySellOutNums(String seller_nickname,int commodity_id);
    int updateSellOutNums( @Param("nums_buy") int nums_buy, @Param("commodity_id") int commodity_id)throws DataAccessException;

}
