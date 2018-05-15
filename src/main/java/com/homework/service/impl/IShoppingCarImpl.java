package com.homework.service.impl;

import com.homework.dao.IShoppingCarDao;
import com.homework.model.Buy;
import com.homework.model.CommodityInShoppingCar;
import com.homework.model.ShoppingCar;
import com.homework.service.IShoppingCarService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IShoppingCarImpl implements IShoppingCarService {


    @Resource
    private IShoppingCarDao iShoppingCarDao;

    @Override
    public List<CommodityInShoppingCar> selectCommodityInShoppingCar(String buyer_nickname, int pos, int nums) {
        return iShoppingCarDao.selectCommodityInShoppingCar(buyer_nickname,pos,nums);
    }

    @Override
    public int selectCommodityRecordsInShoppingCar(String buyer_nickname) {
        return iShoppingCarDao.selectCommodityRecordsInShoppingCar(buyer_nickname);
    }

    @Override
    public void deleteCommodityInShoppingCar(int shoppingCarId) throws DataAccessException {
        iShoppingCarDao.deleteCommodityInShoppingCar(shoppingCarId);
    }

    @Override
    public void deleteCommodityInCarByCommodityId(int commodity_id) throws DataAccessException {
        iShoppingCarDao.deleteCommodityInCarByCommodityId(commodity_id);
    }


    @Override
    public void commodityAddToShoppingCar(ShoppingCar shoppingCar) throws DataAccessException {
        iShoppingCarDao.commodityAddToShoppingCar(shoppingCar);
    }

    @Override
    public void buyCommodities(Buy buy) throws DataAccessException {
        iShoppingCarDao.buyCommodities(buy);
    }

    @Override
    public int selectNumsOfCommoditiesInShoppingCar(String buyer_nickname) {

        return iShoppingCarDao.selectNumsOfCommoditiesInShoppingCar(buyer_nickname);
    }
}
