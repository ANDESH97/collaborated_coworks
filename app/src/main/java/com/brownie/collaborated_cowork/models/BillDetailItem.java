package com.brownie.collaborated_cowork.models;

import com.google.gson.annotations.SerializedName;

public class BillDetailItem
{
    @SerializedName("seatTotal")
    private int seatTotal;

    @SerializedName("addressCharges")
    private int additionalCharges;

    public BillDetailItem() {
    }

    public BillDetailItem(int seatTotal, int additionalCharges) {
        this.seatTotal = seatTotal;
        this.additionalCharges = additionalCharges;
    }

    public int getSeatTotal() {
        return seatTotal;
    }

    public void setSeatTotal(int seatTotal) {
        this.seatTotal = seatTotal;
    }

    public int getAdditionalCharges() {
        return additionalCharges;
    }

    public void setAdditionalCharges(int additionalCharges) {
        this.additionalCharges = additionalCharges;
    }

    @Override
    public String toString() {
        return "BillDetailItem{" +
                "seatTotal=" + seatTotal +
                ", additionalCharges=" + additionalCharges +
                '}';
    }


}
