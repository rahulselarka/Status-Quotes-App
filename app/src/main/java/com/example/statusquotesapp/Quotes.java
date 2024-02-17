package com.example.statusquotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Quotes extends AppCompatActivity {

    private TextView quoteTxt, writerName;
    private final List<QuotesList> quotesLists= new ArrayList<>();
    private int currentQuotePosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        getSupportActionBar().hide();

        final TextView categoryName=findViewById(R.id.categoryName);
        quoteTxt=findViewById(R.id.quoteTxt);
        writerName=findViewById(R.id.writerName);

        final Button prevBtn = findViewById(R.id.prevBtn);
        final Button nextBtn = findViewById(R.id.nextBtn);
        final ImageView copyBtn = findViewById(R.id.copyBtn);

        //get categoryName from categoriesAdapter
        final String getName =getIntent().getStringExtra("name");

        //set categoryName
        categoryName.setText(getName);
        //check category name and get the quotes
        if (getName.equals("Life")){
            quotesLists.addAll(QuotesData.getLifeQuotes());
        } else if (getName.equals("Motivation")) {
            quotesLists.addAll(QuotesData.getMotivationQuotes());
        } else if (getName.equals("Success")) {
            quotesLists.addAll(QuotesData.getSuccessQuotes());
        } else if (getName.equals("English")) {
            quotesLists.addAll(QuotesData.getEnglishQuotes());
        } else if (getName.equals("Love")) {
            quotesLists.addAll(QuotesData.getLoveQuotes());
        }

        setQuoteToTextView();

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuotePosition--;
                if (currentQuotePosition<0){
                    currentQuotePosition=quotesLists.size()-1;
                }
                setQuoteToTextView();
            }
        });

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager= (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData= ClipData.newPlainText("quote",quotesLists.get(currentQuotePosition).getQuote()+"\nby "+quotesLists.get(currentQuotePosition).getWriter());
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(Quotes.this,"Copied to clipboard",Toast.LENGTH_LONG).show();

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuotePosition++;
                if (currentQuotePosition >= quotesLists.size()){
                    currentQuotePosition=0;

                }
                setQuoteToTextView();
            }
        });
    }

    private void setQuoteToTextView(){
        quoteTxt.setText(quotesLists.get(currentQuotePosition).getQuote());
        writerName.setText(quotesLists.get(currentQuotePosition).getWriter());

    }
}