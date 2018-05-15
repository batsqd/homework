package com.homework.service.impl;

import com.homework.dao.ISellerDao;
import com.homework.model.Seller;
import com.homework.service.ISellerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ISellerServiceImpl implements ISellerService{
    @Resource
    private ISellerDao iSellerDao;
    @Override
    public Seller selectSeller(String nickname) {
        return iSellerDao.selectSeller(nickname);
    }

    @Override
    public void registerSeller(Seller seller) {
        iSellerDao.registerSeller(seller);
    }
}
