package com.learnjdbc.model;

public class SaleDetailModel extends AbstractModel<SaleDetailModel>{
    private long saleId;
    private long productLotId;

    private double paymentPrice;
    private int quantity;

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long salesId) {
        this.saleId = salesId;
    }

    public long getProductLotId() {
        return productLotId;
    }

    public void setProductLotId(long productLotId) {
        this.productLotId = productLotId;
    }

    public double getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(double price) {
        this.paymentPrice = price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
