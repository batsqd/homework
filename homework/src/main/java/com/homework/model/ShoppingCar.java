package com.homework.model;
import java.sql.Timestamp;
public class ShoppingCar {
    private String buyer_nickname;
    private int commodity_id;
    private Integer commodity_nums_add_to_shopping_car;
    private Timestamp commodity_timestamp_add_to_shopping_car;

    public Timestamp getCommodity_timestamp_add_to_shopping_car() {
        return commodity_timestamp_add_to_shopping_car;
    }

    public void setCommodity_timestamp_add_to_shopping_car(Timestamp commodity_timestamp_add_to_shopping_car) {
        this.commodity_timestamp_add_to_shopping_car = commodity_timestamp_add_to_shopping_car;
    }

    public String getBuyer_nickname() {
        return buyer_nickname;
    }
    public void setBuyer_nickname(String buyer_nickname) {
        this.buyer_nickname = buyer_nickname;
    }
    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public Integer getCommodity_nums_add_to_shopping_car() {
        return commodity_nums_add_to_shopping_car;
    }

    public void setCommodity_nums_add_to_shopping_car(Integer commodity_nums_add_to_shopping_car) {
        this.commodity_nums_add_to_shopping_car = commodity_nums_add_to_shopping_car;
    }



}
