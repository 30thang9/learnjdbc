package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.IRevenueDAO;
import com.learnjdbc.mapper.RevenueMapper;
import com.learnjdbc.model.statisticalmodel.RevenueModel;

import java.util.List;

public class RevenueDAO extends AbstractDAO<RevenueModel> implements IRevenueDAO {

    @Override
    public RevenueModel getSum() {
        String sql="SELECT SUM(totalMoney) AS sumMoney, SUM(SaleDetail.quantity) AS sumQuantity " +
                " FROM Sale " +
                " INNER JOIN SaleDetail ON Sale.id = SaleDetail.saleId ";
        List<RevenueModel> list= query(sql,new RevenueMapper());
        return list.isEmpty()? null: list.get(0);
    }
    @Override
    public RevenueModel getSumOnCurrentDay() {
        String sql="SELECT \n" +
                "  SUM(totalMoney) AS sumMoney, \n" +
                "  SUM(SaleDetail.quantity) AS sumQuantity\n" +
                "FROM Sale \n" +
                "INNER JOIN SaleDetail ON Sale.id = SaleDetail.saleId \n" +
                "WHERE DATE(saleDate) = CURDATE()";
        List<RevenueModel> list= query(sql,new RevenueMapper());
        return list.isEmpty()? null: list.get(0);
    }

    @Override
    public RevenueModel getSumOnCurrentMonth() {
        String sql="SELECT \n" +
                "  SUM(totalMoney) AS sumMoney, \n" +
                "  SUM(SaleDetail.quantity) AS sumQuantity\n" +
                "FROM Sale \n" +
                "INNER JOIN SaleDetail ON Sale.id = SaleDetail.saleId \n" +
                "WHERE YEAR(saleDate) = YEAR(CURDATE()) AND MONTH(saleDate) = MONTH(CURDATE())";
        List<RevenueModel> list= query(sql,new RevenueMapper());
        return list.isEmpty()? null: list.get(0);
    }
    @Override
    public List<RevenueModel> getSumOnMonth(){
        String sql="SELECT months.month, COALESCE(SUM(s.totalMoney), 0) AS sumMoney, COALESCE(SUM(sd.quantity), 0) AS sumQuantity\n" +
                "FROM (\n" +
                "    SELECT 1 AS month\n" +
                "    UNION SELECT 2\n" +
                "    UNION SELECT 3\n" +
                "    UNION SELECT 4\n" +
                "    UNION SELECT 5\n" +
                "    UNION SELECT 6\n" +
                "    UNION SELECT 7\n" +
                "    UNION SELECT 8\n" +
                "    UNION SELECT 9\n" +
                "    UNION SELECT 10\n" +
                "    UNION SELECT 11\n" +
                "    UNION SELECT 12\n" +
                ") AS months\n" +
                "LEFT JOIN Sale s ON MONTH(s.saleDate) = months.month AND YEAR(s.saleDate) = YEAR(CURDATE())\n" +
                "LEFT JOIN SaleDetail sd ON s.id = sd.saleId\n" +
                "GROUP BY months.month;";
        return query(sql,new RevenueMapper());
    }
}
