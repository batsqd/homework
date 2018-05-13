package com.homework.dao;
import com.homework.model.Publish;
import com.homework.model.PublishCommodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface IPublishDao {
    void insertPublishRecord(Publish publish)throws DataAccessException;
    List<PublishCommodity> selectPublishCommoodities(@Param("seller_nickname") String seller_nickname,
                                                     @Param("pos") int pos,@Param("nums") int nums);
    int selectPublishCommoditiesRecordsBySeller(String seller_nickname);
    PublishCommodity selectPublishCommoditiesRecordsByCommodityId(int Commodity_id);
    void deleteSellerPublish(@Param("seller_nickname") String seller_nickname,
                             @Param("commodity_id") int commodity_id) throws DataAccessException;

    int selectCommoditySellOutNums(@Param("seller_nickname") String seller_nickname,
                                   @Param("commodity_id") int commodity_id);
    int updateSellOutNums(@Param("nums_buy") int nums_buy,@Param("commodity_id") int commodity_id)throws DataAccessException;
}
