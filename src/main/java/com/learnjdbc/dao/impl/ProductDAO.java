package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.IProductDAO;
import com.learnjdbc.mapper.ProductImageMapper;
import com.learnjdbc.mapper.ProductMapper;
import com.learnjdbc.model.ProductImageModel;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.paging.Page;

import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {
    @Override
    public List<ProductModel> getByCategoryId(long categoryId) {
        String sql = "select * from Product where categoryId = ? ";
        return query(sql, new ProductMapper(), categoryId);
    }

    @Override
    public boolean save(ProductModel productModel) {
        String query = "INSERT INTO Product (name, importPrice,exportPrice, discountPrice, descriptions, weight, categoryId," +
                "imageUrl) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return execute(query, productModel.getName(), productModel.getImportPrice(),productModel.getExportPrice(),
                productModel.getDiscountPrice(), productModel.getDescriptions(), productModel.getWeight(),
                productModel.getCategoryId(), productModel.getImageUrl());
    }

    @Override
    public long saveGetId(ProductModel productModel) {
        String query = "INSERT INTO Product (name, importPrice,exportPrice, discountPrice, descriptions, weight, categoryId," +
                "imageUrl) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return insertGetId(query, productModel.getName(), productModel.getImportPrice(),productModel.getExportPrice(),
                productModel.getDiscountPrice(), productModel.getDescriptions(), productModel.getWeight(),
                productModel.getCategoryId(), productModel.getImageUrl());
    }

    @Override
    public ProductModel getOne(long id) {
        String sql = "select * from Product where id = ? ";
        List<ProductModel> productModel=query(sql,new ProductMapper(),id);
        return productModel.isEmpty()? null: productModel.get(0);
    }

    @Override
    public boolean update(ProductModel productModel) {
        String query = "UPDATE Product SET name=?, importPrice=?, exportPrice=?, discountPrice=?, " +
                " descriptions=?, weight=?, categoryId=?, " +
                " imageUrl=? WHERE id=?";
        return execute(query,productModel.getName(), productModel.getImportPrice(),productModel.getExportPrice(),
                productModel.getDiscountPrice(), productModel.getDescriptions(), productModel.getWeight(),
                productModel.getCategoryId(), productModel.getImageUrl(), productModel.getId());
    }


    @Override
    public boolean delete(long id) {
        String q = "select * from ProductImage where productId = ?";
        List<ProductImageModel> piModel = query(q, new ProductImageMapper(), id);
        if (!piModel.isEmpty()) {
            boolean result = execute("delete from ProductImage where productId=?", id);
            if (!result) {
                return false;
            }
        }
        String query = "delete from Product where id=?";
        return execute(query, id);
    }

    @Override
    public List<ProductModel> getByPage(Page page) {
        String sql="";
        sql+="select * from Product ";
        if(page.getSearch()!=null&&!page.getSearch().equals("")){
            sql+=" join Category on Product.categoryId=Category.id ";
            sql+=" where Product.name like '%"+page.getSearch().trim()+"%' or Category.name like '%"+page.getSearch().trim()+"%' ";
        }
        sql+=" order by Product."+page.getSorter().getSortName()+" "+
                page.getSorter().getSortBy();
        sql+=" limit " +page.getOffset()+","+page.getLimit();
        return query(sql, new ProductMapper());
    }

    @Override
    public int getTotalPage(Page page) {
        String sql = "select count(*) from Product ";
        if(page.getSearch()!=null&&!page.getSearch().equals("")){
            sql+=" inner join Category on Product.categoryId=Category.id ";
            sql+=" where Product.name like '%"+page.getSearch().trim()+"%' or Category.name like '%"+page.getSearch().trim()+"%' ";
        }
        return (int) Math.ceil((double) count(sql)/page.getLimit());
    }

    @Override
    public List<ProductModel> getAll() {
        String sql="select * from Product order by id desc";
        return query(sql,new ProductMapper());
    }

    @Override
    public List<ProductModel> getBySearch(String search) {
        String sql="select * from Product ";
        if(search!=null&&!search.equals("")){
            sql+=" join Category on Product.categoryId=Category.id ";
            sql+=" where Product.name like '%"+search.trim()+"%' or Category.name like '%"+search.trim()+"%' ";
        }
        sql+=" limit 0,5";
        return query(sql,new ProductMapper());
    }
}
