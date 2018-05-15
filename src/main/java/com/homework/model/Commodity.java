package com.homework.model;
public class Commodity {
    private int commodity_id;
    private String title;
    private String image_link;
    private float cur_price;
    private String commodity_abstract;
    private String full_text;
    private int inventory;

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public float getCur_price() {
        return cur_price;
    }

    public void setCur_price(float cur_price) {
        this.cur_price = cur_price;
    }

    public String getCommodity_abstract() {
        return commodity_abstract;
    }

    public void setCommodity_abstract(String commodity_abstract) {
        this.commodity_abstract = commodity_abstract;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

}
