package com.api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class OldProductInfo {
    @Id
    private int oProductId;
    private String oProductName;
    private String oProductDesc;
    private int oProductPrice;

    private int productId;
    private String productName;
    private String productDesc;
    private int productPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public OldProductInfo() {
    }

    public OldProductInfo(int oProductId, String oProductName, String oProductDesc, int oProductPrice, int productId, Date updatedAt) {
        this.oProductId = oProductId;
        this.oProductName = oProductName;
        this.oProductDesc = oProductDesc;
        this.oProductPrice = oProductPrice;
        this.updatedAt = updatedAt;
    }

    public OldProductInfo(int oProductId, String oProductName, String oProductDesc, int oProductPrice, int productId,
                          String productName, String productDesc, int productPrice, Date updatedAt) {
        this.oProductId = oProductId;
        this.oProductName = oProductName;
        this.oProductDesc = oProductDesc;
        this.oProductPrice = oProductPrice;
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.updatedAt = updatedAt;
    }

    public int getoProductId() {
        return oProductId;
    }

    public void setoProductId(int oProductId) {
        this.oProductId = oProductId;
    }

    public String getoProductName() {
        return oProductName;
    }

    public void setoProductName(String oProductName) {
        this.oProductName = oProductName;
    }

    public String getoProductDesc() {
        return oProductDesc;
    }

    public void setoProductDesc(String oProductDesc) {
        this.oProductDesc = oProductDesc;
    }

    public int getoProductPrice() {
        return oProductPrice;
    }

    public void setoProductPrice(int oProductPrice) {
        this.oProductPrice = oProductPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "OldProductInfo {" +
                "oProductId=" + oProductId +
                ", oProductName='" + oProductName + '\'' +
                ", oProductDesc='" + oProductDesc + '\'' +
                ", oProductPrice=" + oProductPrice +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPrice=" + productPrice +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
