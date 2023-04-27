package com.learnjdbc.model.statisticalmodel;

import com.learnjdbc.model.AbstractModel;

import java.util.List;

public class RevenueModel extends AbstractModel<RevenueModel> {
    private  double sumMoney;
    private  int sumQuantity;
    private int month;
    private long productId;
    private RevenueModel revenueModel, revenueModel1,revenueModel2;
    private List<RevenueModel> revenueModel3;

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public int getSumQuantity() {
        return sumQuantity;
    }

    public void setSumQuantity(int sumQuantity) {
        this.sumQuantity = sumQuantity;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public RevenueModel getSum(){return revenueModel;}
    public void setSum(RevenueModel revenueModel){this.revenueModel = revenueModel;}
    public RevenueModel getSumOnCurrentDay(){return revenueModel1;}
    public void setSumOnCurrentDay(RevenueModel revenueModel){this.revenueModel1 = revenueModel;}
    public RevenueModel getSumOnCurrentMonth(){return revenueModel2;}
    public void setSumOnCurrentMonth(RevenueModel revenueModel){this.revenueModel2 = revenueModel;}
    public List<RevenueModel> getSumOnMonth(){return revenueModel3;}
    public void setSumOnMonth(List<RevenueModel> revenueModel){this.revenueModel3 = revenueModel;}
}
