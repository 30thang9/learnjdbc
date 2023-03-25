package com.learnjdbc.service;


import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.ProductModel;

import java.util.List;

public interface ICategoryService {
	CategoryModel save(CategoryModel categoryModel);

	CategoryModel update(CategoryModel categoryModel);

	void delete(long[] ids);

	List<CategoryModel> findAll();
}
