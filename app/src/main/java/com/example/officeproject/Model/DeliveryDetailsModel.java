package com.example.officeproject.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserDeliveryDetails")
public class DeliveryDetailsModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "orderID")
    private String orderID;
    @ColumnInfo(name = "Quality")
    private String Quality;
    @ColumnInfo(name = "Amount")
    private String Amount;
    @ColumnInfo(name = "AnyDamageReason")
    private String AnyDamageReason;
    @ColumnInfo(name = "save_image")
    private String save_image;

    public DeliveryDetailsModel(String quality, String amount, String anyDamageReason, String save_image) {
        Quality = quality;
        Amount = amount;
        AnyDamageReason = anyDamageReason;
        this.save_image = save_image;
    }

    public DeliveryDetailsModel(String orderID, String quality, String amount, String anyDamageReason, String save_image) {
        this.orderID = orderID;
        Quality = quality;
        Amount = amount;
        AnyDamageReason = anyDamageReason;
        this.save_image = save_image;
    }

    @Override
    public String toString() {
        return "DeliveryDetailsModel{" +
                "id=" + id +
                ", orderID='" + orderID + '\'' +
                '}';
    }

    public DeliveryDetailsModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getQuality() {
        return Quality;
    }

    public void setQuality(String quality) {
        Quality = quality;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getAnyDamageReason() {
        return AnyDamageReason;
    }

    public void setAnyDamageReason(String anyDamageReason) {
        AnyDamageReason = anyDamageReason;
    }

    public String getSave_image() {
        return save_image;
    }

    public void setSave_image(String save_image) {
        this.save_image = save_image;
    }
}
