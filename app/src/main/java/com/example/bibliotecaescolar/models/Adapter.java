package com.example.bibliotecaescolar.models;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bibliotecaescolar.R;
import com.example.bibliotecaescolar.models.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Book> books;

    public Adapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Book book = (Book) getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.activity_show_books, null);
        ImageView imgBook = (ImageView) view.findViewById(R.id.imgFoto);
        TextView tvTitulo = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvSubtitulo = (TextView) view.findViewById(R.id.tvSubtitle);
        TextView tvIsbn = (TextView) view.findViewById(R.id.tvIsbn13);

        Picasso.get().load(book.getImage()).into(imgBook);
        tvTitulo.setText(book.getTitle());
        tvSubtitulo.setText(book.getSubtitle());
        tvIsbn.setText(book.getTitle());


        return view;
    }
}

