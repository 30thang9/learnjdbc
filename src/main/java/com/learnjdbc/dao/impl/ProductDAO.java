package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.IProductDAO;
import com.learnjdbc.mapper.ProductMapper;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.paging.Page;

import java.sql.Timestamp;
import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {
    @Override
    public List<ProductModel> findByCategoryId(Long categoryId) {
        String sql = "select * from products where categoryId = ? ";
        return query(sql, new ProductMapper(), categoryId);
    }

    @Override
    public Long save(ProductModel productModel) {
        String query = "INSERT INTO products (productName, price, descriptions, weight, categoryId, supplierId, " +
                "quantityInstock, imageUrl, createBy, updateBy) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(query, productModel.getProductName(), productModel.getPrice(), productModel.getDescriptions(),
                productModel.getWeight(), productModel.getCategoryId(), productModel.getSupplierId(),
                productModel.getQuantityInstock(), productModel.getImageUrl(), productModel.getCreateBy(),
                productModel.getUpdateBy());
    }


    @Override
    public ProductModel findOne(Long id) {
        String sql = "select * from products where id = ? ";
        List<ProductModel> productModel=query(sql,new ProductMapper(),id);
        return productModel.isEmpty()? null: productModel.get(0);
    }

    @Override
    public void update(ProductModel productModel) {
        String query = "UPDATE products SET productName=?, price=?, discountPrice=?, discountQuantity=?, discountStatus=?, " +
                "hotStatus=?, sellingStatus=?, descriptions=?, weight=?, categoryId=?, supplierId=?, quantityInstock=?, " +
                "productStatus=?, imageUrl=?, createBy=?, updateBy=?, updateDate=? WHERE id=?";
        update(query, productModel.getProductName(), productModel.getPrice(), productModel.getDiscountPrice(),
                productModel.getDiscountQuantity(), productModel.getDiscountStatus(), productModel.getHotStatus(),
                productModel.getSellingStatus(), productModel.getDescriptions(), productModel.getWeight(),
                productModel.getCategoryId(), productModel.getSupplierId(), productModel.getQuantityInstock(),
                productModel.getProductStatus(), productModel.getImageUrl(), productModel.getCreateBy(),
                productModel.getUpdateBy(), new Timestamp(System.currentTimeMillis()),
                productModel.getId());
    }


    @Override
    public void delete(long id) {
        String query="delete from products where id=?";
        update(query,id);
    }

    @Override
    public List<ProductModel> findAll(Page page) {
        String sql="";
        sql+="select * from products order by "+page.getSorter().getSortName()+" "+
                    page.getSorter().getSortBy()+" limit ?,?";
        return query(sql, new ProductMapper(),
                page.getOffset(),page.getLimit());
    }

    @Override
    public int getTotalPage(int pageSize) {
        String sql = "select count(*) from products";
        return (int) Math.ceil((double) count(sql)/pageSize);
    }

    @Override
    public List<ProductModel> getAll() {
        String sql="select * from products";
        return query(sql,new ProductMapper());
    }
}
