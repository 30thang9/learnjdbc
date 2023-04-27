package com.learnjdbc.service.impl;

import com.learnjdbc.dao.ICustomerDAO;
import com.learnjdbc.dao.ISupplierDAO;
import com.learnjdbc.model.CustomerModel;
import com.learnjdbc.model.SupplierModel;
import com.learnjdbc.service.ICustomerService;
import com.learnjdbc.service.ISupplierService;

import javax.inject.Inject;
import java.util.List;

public class CustomerService implements ICustomerService {

    @Inject
    private ICustomerDAO customerDAO;

    @Override
    public boolean save(CustomerModel customerModel) {
        return customerDAO.save(customerModel);
    }

    @Override
    public Long saveGetId(CustomerModel customerModel) {
        return customerDAO.saveGetId(customerModel);
    }

    @Override
    public boolean update(CustomerModel customerModel) {
        return customerDAO.update(customerModel);
    }

    @Override
    public boolean delete(long[] ids) {
        boolean isDeleted = true;
        for (long id : ids) {
            if (!customerDAO.delete(id)) {
                isDeleted = false;
            }
        }
        return isDeleted;
    }

    @Override
    public List<CustomerModel> getAll() {
        return customerDAO.getAll();
    }

    @Override
    public CustomerModel getOne(long id) {
        return customerDAO.getOne(id);
    }

    @Override
    public List<CustomerModel> getByUsername(String username) {
        return customerDAO.getByUsername(username);
    }
}
