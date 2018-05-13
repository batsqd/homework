package com.homework.dao;

import com.homework.model.Seller;

public interface ISellerDao {
    Seller selectSeller(String nickname);
    void registerSeller(Seller seller);
}
