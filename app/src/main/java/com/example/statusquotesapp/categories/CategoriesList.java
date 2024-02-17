package com.example.statusquotesapp.categories;

public class CategoriesList {

    private final String categoryName;
    private final int categoryImg;

    public CategoriesList(String categoryName, int categoryImg) {
        this.categoryName = categoryName;
        this.categoryImg = categoryImg;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryImg() {
        return categoryImg;
    }
}
