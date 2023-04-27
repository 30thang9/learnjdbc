package com.learnjdbc.dao;

import com.learnjdbc.model.CustomerModel;
import com.learnjdbc.model.SupplierModel;

import java.util.List;

public interface ICustomerDAO extends GenericDAO<CustomerModel>{
    boolean save(CustomerModel customerModel);
    CustomerModel getOne(long id);
    boolean update(CustomerModel customerModel);
    boolean delete(long id);
    List<CustomerModel> getAll();
    List<CustomerModel> getByUsername(String username);
    Long saveGetId(CustomerModel customerModel);
}
