package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.ICustomerDAO;
import com.learnjdbc.mapper.CustomerMapper;
import com.learnjdbc.model.CustomerModel;

import java.util.List;

public class CustomerDAO extends AbstractDAO<CustomerModel> implements ICustomerDAO {
    @Override
    public boolean save(CustomerModel customerModel) {
        String query="";
        if(customerModel.getUsername()==null ||customerModel.getUsername().equals("")){
            query="INSERT INTO Customer (name,address,phone,email) " +
                    "VALUES (?, ?, ?, ?)";
            return execute(query,customerModel.getName(),customerModel.getAddress(),customerModel.getPhone(),
                    customerModel.getEmail());
        }else {
            query="INSERT INTO Customer (name,address,phone,email,username) " +
                    "VALUES (?, ?, ?, ?, ?)";
            return execute(query,customerModel.getName(),customerModel.getAddress(),customerModel.getPhone(),
                    customerModel.getEmail(),customerModel.getUsername());
        }
    }

    @Override
    public CustomerModel getOne(long id) {
        String sql = "select * from Customer where id = ? ";
        List<CustomerModel> customerModel=query(sql,new CustomerMapper(),id);
        return customerModel.isEmpty()? null: customerModel.get(0);
    }

    @Override
    public boolean update(CustomerModel customerModel) {
        String query="";
        if(customerModel.getUsername()==null ||customerModel.getUsername().equals("")){
            query+="update Customer set name=?,address=?,phone=?,email=? where id=?";
        }else{
            query+="update Customer set name=?,address=?,phone=?,email=?,username='"+customerModel.getUsername()+ "' where id=?";
        }
        return execute(query, customerModel.getName(),customerModel.getAddress(),customerModel.getPhone(),
                customerModel.getEmail(), customerModel.getId());
    }

    @Override
    public boolean delete(long id) {
        String query="delete from Customer where id=?";
        return execute(query,id);
    }

    @Override
    public List<CustomerModel> getAll() {
        String sql = "select * from Customer order by name asc";
        return query(sql,new CustomerMapper());
    }

    @Override
    public List<CustomerModel> getByUsername(String username) {
        String sql = "select * from Customer where username=?";
        return query(sql,new CustomerMapper(),username);
    }

    @Override
    public Long saveGetId(CustomerModel customerModel) {
        String query="";
        if(customerModel.getUsername()==null ||customerModel.getUsername().equals("")){
            query="INSERT INTO Customer (name,address,phone,email) " +
                    "VALUES (?, ?, ?, ?)";
            return insertGetId(query,customerModel.getName(),customerModel.getAddress(),customerModel.getPhone(),
                    customerModel.getEmail());
        }else {
            query="INSERT INTO Customer (name,address,phone,email,username) " +
                    "VALUES (?, ?, ?, ?, ?)";
            return insertGetId(query,customerModel.getName(),customerModel.getAddress(),customerModel.getPhone(),
                    customerModel.getEmail(),customerModel.getUsername());
        }
    }

    @Override
    public int getCount() {
        String sql = "select count(*) from Customer";
        return count(sql);
    }

}
