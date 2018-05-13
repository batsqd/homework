package com.homework.service;

import com.homework.model.Buyer;

public interface IBuyerService {
    Buyer selectBuyer(String nickname);
    void registerBuyer(Buyer buyer);
    int selectNumsDistinctCommodity(String buyer_nickname);

}
