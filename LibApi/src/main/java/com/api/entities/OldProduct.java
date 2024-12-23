package com.api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class OldProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String oldValue;
    private String newValue;
    private String fieldName;

    private int productId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public OldProduct() {
    }

    public OldProduct(int id, String oldValue, String newValue, String fieldName, int productId) {
        this.id = id;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.fieldName = fieldName;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "OldProduct {" +
                "id=" + id +
                ", oldValue='" + oldValue + '\'' +
                ", newValue='" + newValue + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", productId=" + productId +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
