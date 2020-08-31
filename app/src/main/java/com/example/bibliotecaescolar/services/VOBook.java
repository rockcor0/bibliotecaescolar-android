package com.example.bibliotecaescolar.services;

import com.example.bibliotecaescolar.models.Book;

import java.util.List;

public class VOBook {

    private String error;
    private String total;
    private String page;
    private List<Book> books;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
