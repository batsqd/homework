package com.homework.service.impl;

import com.homework.dao.IBuyDao;
import com.homework.model.PurchasedCommodity;
import com.homework.service.IBuyService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IBuyServiceImpl implements IBuyService{
    @Resource
    private IBuyDao iBuyDao;

    @Override
    public List<PurchasedCommodity> selectPurchasedCommodity(String buyer_nickname,int pos,int nums) {
        return iBuyDao.selectPurchasedCommodity(buyer_nickname,pos,nums);
    }

    @Override
    public int selectRecordsPurchasedCommodity(String buyer_nickname) {
        return  iBuyDao.selectRecordsPurchasedCommodity(buyer_nickname);
    }

    @Override
    public void deletePurchasedCommodityRecord(int id) throws DataAccessException {
        iBuyDao.deletePurchasedCommodityRecord(id);
    }


}
