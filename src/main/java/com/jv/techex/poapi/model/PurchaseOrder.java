package com.jv.techex.poapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long itemId;
    private Integer quantity;
    private String comment;

    protected PurchaseOrder() { }

    public PurchaseOrder(Long itemId, Integer quantity, String comment) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.comment = comment;
    }

    public PurchaseOrder(PurchaseOrder purchaseOrder) {
        this.itemId = purchaseOrder.itemId;
        this.quantity = purchaseOrder.quantity;
        this.comment = purchaseOrder.comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", comment='" + comment + '\'' +
                '}';
    }
}
