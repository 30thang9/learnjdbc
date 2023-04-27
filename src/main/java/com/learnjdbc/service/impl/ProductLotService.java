package com.learnjdbc.service.impl;

import com.learnjdbc.dao.IProductLotDAO;
import com.learnjdbc.model.ProductLotModel;
import com.learnjdbc.service.IProductLotService;

import javax.inject.Inject;
import java.util.List;

public class ProductLotService implements IProductLotService {

    @Inject
    private IProductLotDAO productLotDAO;

    @Override
    public boolean save(ProductLotModel productLotModel) {
        return productLotDAO.save(productLotModel);
    }

    @Override
    public boolean update(ProductLotModel productLotModel) {
        return productLotDAO.update(productLotModel);
    }

    @Override
    public boolean delete(long[] ids) {
        boolean isDeleted = true;
        for (long id : ids) {
            if (!productLotDAO.delete(id)) {
                isDeleted = false;
            }
        }
        return isDeleted;
    }

    @Override
    public List<ProductLotModel> getAll() {
        return productLotDAO.getAll();
    }

    @Override
    public List<ProductLotModel> getAllBySale() {
        return productLotDAO.getAllBySale();
    }

    @Override
    public ProductLotModel getOne(long id) {
        return productLotDAO.getOne(id);
    }

    @Override
    public List<ProductLotModel> getByProductIdAndSale(long productId) {
        return productLotDAO.getByProductIdAndSale(productId);
    }
}
