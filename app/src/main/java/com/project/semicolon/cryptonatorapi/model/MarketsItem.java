package com.project.semicolon.cryptonatorapi.model;

import com.google.gson.annotations.SerializedName;

public class MarketsItem {

    @SerializedName("market")
    private String market;

    @SerializedName("volume")
    private double volume;

    @SerializedName("price")
    private String price;

    private String coinName;

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMarket() {
        return market;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getVolume() {
        return volume + " ";
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinName() {
        return coinName;
    }

    @Override
    public String toString() {
        return "MarketsItem{" +
                "market='" + market + '\'' +
                ", volume=" + volume +
                ", price='" + price + '\'' +
                ", coinName='" + coinName + '\'' +
                '}';
    }

}