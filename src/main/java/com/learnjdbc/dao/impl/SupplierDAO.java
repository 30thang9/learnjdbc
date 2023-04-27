package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.ISupplierDAO;
import com.learnjdbc.mapper.SupplierMapper;
import com.learnjdbc.model.SupplierModel;

import java.sql.Timestamp;
import java.util.List;

public class SupplierDAO extends AbstractDAO<SupplierModel> implements ISupplierDAO {
    @Override
    public boolean save(SupplierModel supplierModel) {
        String query="INSERT INTO Supplier (name,address,phone,email) " +
                "VALUES (?, ?, ?, ?)";
        return execute(query,supplierModel.getName(),supplierModel.getAddress(),supplierModel.getPhone(),
                supplierModel.getEmail());
    }

    @Override
    public SupplierModel getOne(long id) {
        String sql = "select * from Supplier where id = ? ";
        List<SupplierModel> supplierModel=query(sql,new SupplierMapper(),id);
        return supplierModel.isEmpty()? null: supplierModel.get(0);
    }

    @Override
    public boolean update(SupplierModel supplierModel) {
        String query="update Supplier set name=?,address=?,phone=?,email=? where id=?";
        return execute(query, supplierModel.getName(),supplierModel.getAddress(),supplierModel.getPhone(),
                supplierModel.getEmail(), supplierModel.getId());
    }

    @Override
    public boolean delete(long id) {
        String query="delete from Supplier where id=?";
        return execute(query,id);
    }

    @Override
    public List<SupplierModel> getAll() {
        String sql = "select * from Supplier order by name asc";
        return query(sql,new SupplierMapper());
    }

}
