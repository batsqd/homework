package com.homework.dao;

import com.homework.model.PurchasedCommodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface IBuyDao {
  List<PurchasedCommodity> selectPurchasedCommodity(@Param("buyer_nickname") String buyer_nickname,
                                                    @Param("pos")int pos, @Param("nums")int nums);
 int selectRecordsPurchasedCommodity(String buyer_nickname);
 void deletePurchasedCommodityRecord(int id) throws DataAccessException;

}
