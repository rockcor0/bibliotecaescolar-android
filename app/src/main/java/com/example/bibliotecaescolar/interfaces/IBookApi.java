package com.example.bibliotecaescolar.interfaces;

import com.example.bibliotecaescolar.models.Book;
import com.example.bibliotecaescolar.services.VOBook;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IBookApi {

    @GET("1.0/search/{keyword}")
    public Call<VOBook> find(@Path("keyword") String keyword);

}
