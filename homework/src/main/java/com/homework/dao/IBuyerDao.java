package com.homework.dao;
import com.homework.model.Buyer;

public interface IBuyerDao {
     Buyer selectBuyer(String nickname);
     void registerBuyer(Buyer buyer);
     int selectNumsDistinctCommodity(String buyer_nickname);
}
