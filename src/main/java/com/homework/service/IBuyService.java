package com.homework.service;

import com.homework.model.PurchasedCommodity;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface IBuyService {
    List<PurchasedCommodity> selectPurchasedCommodity(String buyer_nickname,int pos,int nums);
    int selectRecordsPurchasedCommodity(String buyer_nickname);
    void deletePurchasedCommodityRecord(int id) throws DataAccessException;
}
