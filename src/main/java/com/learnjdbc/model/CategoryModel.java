package com.learnjdbc.model;



public class CategoryModel extends AbstractModel<CategoryModel> {
    private String categoryName;
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}