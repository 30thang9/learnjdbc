package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.ICategoryDAO;
import com.learnjdbc.dao.ISupplierDAO;
import com.learnjdbc.mapper.CategoryMapper;
import com.learnjdbc.mapper.SupplierMapper;
import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.SupplierModel;

import java.sql.Timestamp;
import java.util.List;

public class SupplierDAO extends AbstractDAO<SupplierModel> implements ISupplierDAO {
    @Override
    public Long save(SupplierModel supplierModel) {
        String query="INSERT INTO suppliers (supplierName,address,phone,email, createBy, updateBy) " +
                "VALUES (?, ?, ?)";
        return insert(query,supplierModel.getSupplierName(),supplierModel.getAddress(),supplierModel.getPhone(),
                supplierModel.getEmail(),supplierModel.getCreateBy(),supplierModel.getUpdateBy());
    }

    @Override
    public SupplierModel findOne(Long id) {
        String sql = "select * from suppliers where id = ? ";
        List<SupplierModel> supplierModel=query(sql,new SupplierMapper(),id);
        return supplierModel.isEmpty()? null: supplierModel.get(0);
    }

    @Override
    public void update(SupplierModel supplierModel) {
        String query="update suppliers set supplierName=?,address=?,phone=?,email=?,createBy=?," +
                "updateBy=?, updateDate=? where id=?";
        update(query,supplierModel.getSupplierName(),supplierModel.getAddress(),supplierModel.getPhone(),
                supplierModel.getEmail(),supplierModel.getCreateBy(),supplierModel.getUpdateBy(),
                new Timestamp(System.currentTimeMillis()),supplierModel.getId());
    }

    @Override
    public void delete(long id) {
        String query="delete from suppliers where id=?";
        update(query,id);
    }

    @Override
    public List<SupplierModel> findAll() {
        String sql = "select * from suppliers order by supplierName asc";
        return query(sql,new SupplierMapper());
    }

}
