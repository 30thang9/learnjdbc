package com.learnjdbc.service;


import com.learnjdbc.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
	boolean save(CategoryModel categoryModel);

	boolean update(CategoryModel categoryModel);

	boolean delete(long[] ids);

	List<CategoryModel> getAll();
}
