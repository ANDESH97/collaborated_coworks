package com.brownie.collaborated_cowork.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class C2C implements Serializable {

    @SerializedName("c2cName")
    private String c2cName;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("description")
    private String cafeDesc;

    @SerializedName("latitude")
    private Double latitude;

    @SerializedName("longitude")
    private Double longitude;

    public C2C() {
    }

    public C2C(String c2cName, String imageUrl, String cafeDesc, Double latitude, Double longitude) {
        this.c2cName = c2cName;
        this.imageUrl = imageUrl;
        this.cafeDesc = cafeDesc;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getC2cName() {
        return c2cName;
    }

    public void setC2cName(String c2cName) {
        this.c2cName = c2cName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCafeDesc() {
        return cafeDesc;
    }

    public void setCafeDesc(String cafeDesc) {
        this.cafeDesc = cafeDesc;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "C2C{" +
                "c2cName='" + c2cName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", cafeDesc='" + cafeDesc + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
