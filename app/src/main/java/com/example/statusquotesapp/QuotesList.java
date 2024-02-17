package com.example.statusquotesapp;

public class QuotesList {

    private final String quote;
    private final String writer;

    public QuotesList(String quote, String writer) {
        this.quote = quote;
        this.writer = writer;
    }

    public String getQuote() {
        return quote;
    }

    public String getWriter() {
        return writer;
    }
}
