package com.homework.model;

import java.sql.Timestamp;

public class Buy {
    private int id;
    private String buyer_nickname;
    private int commodity_id;
    private float price_buy;
    private int nums_buy;
    private Timestamp timestamp_buy;
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

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public float getPrice_buy() {
        return price_buy;
    }

    public void setPrice_buy(float price_buy) {
        this.price_buy = price_buy;
    }

    public int getNums_buy() {
        return nums_buy;
    }

    public void setNums_buy(int nums_buy) {
        this.nums_buy = nums_buy;
    }

    public Timestamp getTimestamp_buy() {
        return timestamp_buy;
    }

    public void setTimestamp_buy(Timestamp timestamp_buy) {
        this.timestamp_buy = timestamp_buy;
    }


}
