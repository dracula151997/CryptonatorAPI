package com.project.semicolon.cryptonatorapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ticker {

    @SerializedName("volume")
    private String volume;

    @SerializedName("markets")
    private List<MarketsItem> markets;

    @SerializedName("price")
    private String price;

    @SerializedName("change")
    private String change;

    @SerializedName("base")
    private String base;

    @SerializedName("target")
    private String target;

    private String coinName;

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getVolume() {
        return volume;
    }

    public void setMarkets(List<MarketsItem> markets) {
        this.markets = markets;
    }

    public List<MarketsItem> getMarkets() {
        return markets;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChange() {
        return change;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getBase() {
        return base;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinName() {
        return coinName;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "volume='" + volume + '\'' +
                ", markets=" + markets +
                ", price='" + price + '\'' +
                ", change='" + change + '\'' +
                ", base='" + base + '\'' +
                ", target='" + target + '\'' +
                ", coinName='" + coinName + '\'' +
                '}';
    }
}