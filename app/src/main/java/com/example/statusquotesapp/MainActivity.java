package com.example.statusquotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.statusquotesapp.categories.CategoriesAdapter;
import com.example.statusquotesapp.categories.CategoriesList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<CategoriesList> categoriesLists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        final RecyclerView categoriesRecycleView = findViewById(R.id.categoriesRecyclerView);

        categoriesRecycleView.setHasFixedSize(true);
        categoriesRecycleView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));

        // adding categories to category activity (categoriesLists)
        CategoriesList loveCategory =new CategoriesList("Love",R.drawable.screen_1);
        categoriesLists.add(loveCategory);

        CategoriesList motivationCategory =new CategoriesList("Motivation",R.drawable.screen_2);
        categoriesLists.add(motivationCategory);

        CategoriesList englishCategory =new CategoriesList("English",R.drawable.screen_3);
        categoriesLists.add(englishCategory);

        CategoriesList successCategory =new CategoriesList("Success",R.drawable.screen_4);
        categoriesLists.add(successCategory);

        CategoriesList lifeCategory =new CategoriesList("Life",R.drawable.screen_5);
        categoriesLists.add(lifeCategory);

        //set adapter to recyclerview
        categoriesRecycleView.setAdapter(new CategoriesAdapter(categoriesLists,MainActivity.this));
    }
}