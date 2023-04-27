package com.learnjdbc.dao;

import com.learnjdbc.model.ProductLotModel;

import java.util.List;

public interface IProductLotDAO extends GenericDAO<ProductLotModel>{
    boolean save(ProductLotModel productLotModel);
    ProductLotModel getOne(long id);
    boolean update(ProductLotModel productLotModel);
    boolean delete(long id);
    List<ProductLotModel> getAll();
    List<ProductLotModel> getAllBySale();
    List<ProductLotModel> getByProductIdAndSale(long productId);
}
