package com.learnjdbc.model;

import java.math.BigDecimal;

public class ProductModel extends AbstractModel<ProductModel>{
    private String productName;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private int discountQuantity;
    private Boolean discountStatus;
    private Boolean hotStatus;
    private Boolean sellingStatus;
    private String descriptions;
    private Float weight;
    private long categoryId;
    private long supplierId;
    private long quantityInstock;
    private Boolean productStatus;
    private String imageUrl;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getDiscountQuantity() {
        return discountQuantity;
    }

    public void setDiscountQuantity(int discountQuantity) {
        this.discountQuantity = discountQuantity;
    }

    public Boolean getDiscountStatus() {
        return discountStatus;
    }

    public void setDiscountStatus(Boolean discountStatus) {
        this.discountStatus = discountStatus;
    }

    public Boolean getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(Boolean hotStatus) {
        this.hotStatus = hotStatus;
    }

    public Boolean getSellingStatus() {
        return sellingStatus;
    }

    public void setSellingStatus(Boolean sellingStatus) {
        this.sellingStatus = sellingStatus;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public long getQuantityInstock() {
        return quantityInstock;
    }

    public void setQuantityInstock(long quantityInstock) {
        this.quantityInstock = quantityInstock;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}