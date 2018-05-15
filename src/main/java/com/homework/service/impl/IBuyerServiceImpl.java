package com.homework.service.impl;

import com.homework.dao.IBuyerDao;
import com.homework.model.Buyer;
import com.homework.service.IBuyerService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class IBuyerServiceImpl implements IBuyerService{
    @Resource
    private IBuyerDao buyerDao;

    @Override
    public Buyer selectBuyer(String nickname) {
        return buyerDao.selectBuyer(nickname);
    }

    @Override
    public void registerBuyer(Buyer buyer) {
         buyerDao.registerBuyer(buyer);
    }

    @Override
    public int selectNumsDistinctCommodity(String buyer_nickname) {
        return buyerDao.selectNumsDistinctCommodity(buyer_nickname);
    }
}
