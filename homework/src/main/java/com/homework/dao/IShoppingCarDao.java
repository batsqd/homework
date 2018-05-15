package com.homework.dao;

import com.homework.model.Buy;
import com.homework.model.CommodityInShoppingCar;
import com.homework.model.ShoppingCar;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public interface IShoppingCarDao {
    void commodityAddToShoppingCar(ShoppingCar shoppingCar) throws DataAccessException;
    void buyCommodities(Buy buy)throws DataAccessException;
    int selectNumsOfCommoditiesInShoppingCar(String buyer_nickname);
    List<CommodityInShoppingCar> selectCommodityInShoppingCar(@Param("buyer_nickname")String buyer_nickname,
                                                              @Param("pos") int pos, @Param("nums") int nums);
    int selectCommodityRecordsInShoppingCar(String buyer_nickname);
    void deleteCommodityInShoppingCar(int shoppingCarId) throws DataAccessException;
    void deleteCommodityInCarByCommodityId(int commodity_id) throws DataAccessException;
}
