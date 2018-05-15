package com.homework.service;

import com.homework.model.Seller;

public interface ISellerService {
    Seller selectSeller(String nickname);
    void registerSeller(Seller seller);
}
