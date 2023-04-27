package com.learnjdbc.model.cartmodel;

import java.util.ArrayList;
import java.util.List;

public class CartModel {
    private List<ItemModel> listItems;

    public CartModel() {
        listItems=new ArrayList<ItemModel>();
    }

    public CartModel(List<ItemModel> listItems) {
        this.listItems = listItems;
    }

    public List<ItemModel> getListItems() {return this.listItems;}
    private ItemModel getItemById(long id) {
        for (ItemModel item:listItems){
            if(item.getProductLotModel().getId()==id){
                return item;
            }
        }
        return null;
    }

    public int getQuantityById(long id) {
        ItemModel item = getItemById(id);
        if (item != null) {
            return item.getQuantity();
        } else {
            return 0;
        }
    }

    public void addItem(ItemModel item) {
        ItemModel existingItem = getItemById((int) item.getProductLotModel().getId());
        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            listItems.add(item);
        }
    }

    public void updateItem(ItemModel item) {
        ItemModel existingItem = getItemById((int) item.getProductLotModel().getId());
        if (existingItem != null) {
            existingItem.setQuantity(item.getQuantity());
            existingItem.setPrice(item.getPrice());
        }
    }
    public void removeItem(long id) {
        ItemModel item = getItemById(id);
        if (item != null) {
            listItems.remove(item);
        }
    }

    public double getTotalMoney() {
        double totalMoney = 0;
        for (ItemModel item : listItems) {
            totalMoney += item.getQuantity() * item.getPrice();
        }
        return totalMoney;
    }
}
