package com.learnjdbc.model.cartmodel;

import com.learnjdbc.model.ProductLotModel;
import com.learnjdbc.model.ProductModel;

public class ItemModel {
    private ProductLotModel productLotModel;
    private int quantity;
    private double price;

    public ItemModel() {
    }

    public ItemModel(ProductLotModel productLotModel, int quantity, double price) {
        this.productLotModel = productLotModel;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductLotModel getProductLotModel() {
        return productLotModel;
    }

    public void setProductLotModel(ProductLotModel productLotModel) {
        this.productLotModel = productLotModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
