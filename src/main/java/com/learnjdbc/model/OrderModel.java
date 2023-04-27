package com.learnjdbc.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderModel extends AbstractModel<OrderModel>{
    private long id;
    private long productLotId;
    private double price;
    private int quantity;
    private String username;
    private Timestamp orderDate;
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductLotId() {
        return productLotId;
    }

    public void setProductLotId(long productLotId) {
        this.productLotId = productLotId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
