package com.homework.model;

import java.sql.Timestamp;

public class PublishCommodity extends Commodity{
    private String seller_nickname;
    private int commodity_id;
    private Timestamp time_publish;
    private int nums_sell_out;
    public String getSeller_nickname() {
        return seller_nickname;
    }

    public void setSeller_nickname(String seller_nickname) {
        this.seller_nickname = seller_nickname;
    }

    @Override
    public int getCommodity_id() {
        return commodity_id;
    }

    @Override
    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public Timestamp getTime_publish() {
        return time_publish;
    }

    public void setTime_publish(Timestamp time_publish) {
        this.time_publish = time_publish;
    }

    public int getNums_sell_out() {
        return nums_sell_out;
    }

    public void setNums_sell_out(int nums_sell_out) {
        this.nums_sell_out = nums_sell_out;
    }



}
