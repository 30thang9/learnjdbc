package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.IProductLotDAO;
import com.learnjdbc.dao.ISupplierDAO;
import com.learnjdbc.mapper.ProductLotMapper;
import com.learnjdbc.mapper.SupplierMapper;
import com.learnjdbc.model.ProductLotModel;
import com.learnjdbc.model.SupplierModel;

import java.util.List;

public class ProductLotDAO extends AbstractDAO<ProductLotModel> implements IProductLotDAO {
    @Override
    public boolean save(ProductLotModel productLotModel) {
        String query="INSERT INTO ProductLot (productId,productionDate,expirationDate,quantity) " +
                "VALUES (?, ?, ?, ?)";
        return execute(query,productLotModel.getProductId(),productLotModel.getProductionDate(),
                productLotModel.getExpirationDate(), productLotModel.getQuantity());
    }

    @Override
    public ProductLotModel getOne(long id) {
        String sql = "select * from ProductLot where id = ? ";
        List<ProductLotModel> productLotModels=query(sql,new ProductLotMapper(),id);
        return productLotModels.isEmpty()? null: productLotModels.get(0);
    }

    @Override
    public boolean update(ProductLotModel productLotModel) {
        String query="update ProductLot set productId=?,productionDate=?,expirationDate=?,quantity=? where id=?";
        return execute(query,productLotModel.getProductId(),productLotModel.getProductionDate(),
                productLotModel.getExpirationDate(), productLotModel.getQuantity(),productLotModel.getId());
    }

    @Override
    public boolean delete(long id) {
        String query="delete from ProductLot where id=?";
        return execute(query,id);
    }

    @Override
    public List<ProductLotModel> getAll() {
        String sql = "SELECT * FROM ProductLot ORDER BY expirationDate DESC";
        return query(sql, new ProductLotMapper());
    }

    @Override
    public List<ProductLotModel> getAllBySale() {
        String sql = "SELECT * FROM ProductLot WHERE DATE(expirationDate) > CURDATE() AND quantity > 0 ORDER BY expirationDate DESC";
        return query(sql, new ProductLotMapper());
    }

    @Override
    public List<ProductLotModel> getByProductIdAndSale(long productId) {
        String sql = "select * from ProductLot where productId=? and DATE(expirationDate) > CURDATE() AND quantity > 0 order by expirationDate desc";
        return query(sql,new ProductLotMapper(),productId);
    }

}
