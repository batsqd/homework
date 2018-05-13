package com.homework.model;

import java.sql.Timestamp;

public class CommodityInShoppingCar extends Commodity{


    private int id;
    private String buyer_nickname;
    private Integer commodity_nums_add_to_shopping_car;
    private Timestamp commodity_timestamp_add_to_shopping_car;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getBuyer_nickname() {
        return buyer_nickname;
    }

    public void setBuyer_nickname(String buyer_nickname) {
        this.buyer_nickname = buyer_nickname;
    }

    public Integer getCommodity_nums_add_to_shopping_car() {
        return commodity_nums_add_to_shopping_car;
    }

    public void setCommodity_nums_add_to_shopping_car(Integer commodity_nums_add_to_shopping_car) {
        this.commodity_nums_add_to_shopping_car = commodity_nums_add_to_shopping_car;
    }

    public Timestamp getCommodity_timestamp_add_to_shopping_car() {
        return commodity_timestamp_add_to_shopping_car;
    }

    public void setCommodity_timestamp_add_to_shopping_car(Timestamp commodity_timestamp_add_to_shopping_car) {
        this.commodity_timestamp_add_to_shopping_car = commodity_timestamp_add_to_shopping_car;
    }

}
