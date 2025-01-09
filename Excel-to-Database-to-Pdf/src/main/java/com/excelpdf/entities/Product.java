package com.excelpdf.entities;


import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySGenerator")
    @SequenceGenerator(name = "mySGenerator", sequenceName = "mySsGeneratorName", allocationSize = 1)
    private int productId;
    private String productName;
    private String productDesc;
    private int productPrice;
    private int quantity;

    public Product() {
    }

    public Product(int productId, String productName, String productDesc, int productPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product {" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                '}';
    }
}
