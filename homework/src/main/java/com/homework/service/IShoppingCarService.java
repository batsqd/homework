package com.homework.service;

import com.homework.model.Buy;
import com.homework.model.CommodityInShoppingCar;
import com.homework.model.ShoppingCar;
import org.springframework.dao.DataAccessException;

import java.sql.Timestamp;
import java.util.List;

public interface IShoppingCarService {
    void commodityAddToShoppingCar(ShoppingCar shoppingCar) throws DataAccessException;
    void buyCommodities(Buy buy) throws DataAccessException;
    int selectNumsOfCommoditiesInShoppingCar(String buyer_nickname);
    List<CommodityInShoppingCar> selectCommodityInShoppingCar(String buyer_nickname,int pos,int nums);
    int selectCommodityRecordsInShoppingCar(String buyer_nickname);
    void deleteCommodityInShoppingCar(int shoppingCarId) throws DataAccessException;
    void deleteCommodityInCarByCommodityId(int commodity_id) throws DataAccessException;
}
