package com.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "old_product_info ")
public class OldProduct {
    @Id
    private int oProductId;
    private String oProductName;
    private String oProductDesc;
    private int oProductPrice;

    private int productId;
    private String productName;
    private String productDesc;
    private int productPrice;

    public OldProduct() {
    }

    public OldProduct(int oProductId, String oProductName, String oProductDesc, int oProductPrice, int productId) {
        this.oProductId = oProductId;
        this.oProductName = oProductName;
        this.oProductDesc = oProductDesc;
        this.oProductPrice = oProductPrice;
        this.productId = productId;
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

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OldProduct{" +
                "oProductId=" + oProductId +
                ", oProductName='" + oProductName + '\'' +
                ", oProductDesc='" + oProductDesc + '\'' +
                ", oProductPrice=" + oProductPrice +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
