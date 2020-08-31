package com.example.bibliotecaescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bibliotecaescolar.interfaces.IBookApi;
import com.example.bibliotecaescolar.models.Adapter;
import com.example.bibliotecaescolar.models.Book;
import com.example.bibliotecaescolar.services.VOBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView lvBooks;
    private Adapter adapter;
    private Button btnBuscar;
    private EditText txtKeyword;
    private ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new Adapter(getContext(), getBooks());

        btnBuscar = findViewById(R.id.btnSearch);
        txtKeyword = findViewById(R.id.txtSearch);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    findBooks(txtKeyword.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }


                //Log.i("Cantidad de libros", books.size()+" ");
//                lvBooks = (ListView) findViewById(R.id.lvItems);
//                adapter = new Adapter(getContext(), (ArrayList<Book>) books);
//                lvBooks.setAdapter(adapter);
            }
        });

    }

    private MainActivity getContext() {
        return this;
    }

    private void findBooks(String keyword) throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.itbook.store/").addConverterFactory(GsonConverterFactory.create()).build();

        IBookApi bookApi = retrofit.create(IBookApi.class);
        Call<VOBook> call = bookApi.find(keyword);

        /*if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        VOBook voBook = call.execute().body();

        while(voBook.getBooks().size() < Integer.parseInt(voBook.getTotal())){
            Log.i("Cantidad libros array", voBook.getBooks().size()+" ");
        }

            books = (ArrayList<Book>) voBook.getBooks();

            Log.i("tag", voBook.getTotal());

*/
        call.enqueue(new Callback<VOBook>() {
            @Override
            public void onResponse(Call<VOBook> call, Response<VOBook> response) {
                try {
                    if (response.isSuccessful()) {
                        VOBook voBook = response.body();
                        //books = new ArrayList<Book>();
                        books = (ArrayList<Book>) voBook.getBooks();

                        for (Book book : books) {
                            Log.i("Book ", book.getTitle());
                        }

                        Log.i("tag", "Éxito al consultar libros");

                        lvBooks = (ListView) findViewById(R.id.lvItems);
                        adapter = new Adapter(getContext(), books);
                        lvBooks.setAdapter(adapter);

                        return;

                    }
                } catch (Exception e) {
                    //Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.i("tag", "Falla al consultar libros");
                }
            }

            @Override
            public void onFailure(Call<VOBook> call, Throwable t) {
                //Toast.makeText(MainActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                Log.i("tag", "onFailure al consultar libros");
            }
        });

    }

    private ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("A Developer's Guide to Data Modeling for SQL Server", "Covering SQL Server 2005 and 2008", "9780321497642", "$6.15", "https://itbook.store/img/books/9780321497642.png", "https://itbook.store/books/9780321497642"));
        books.add(new Book("Oracle PL/SQL Language Pocket Reference, 4th Edition", "A Guide to Oracle's PL/SQL Language Fundamentals", "9780596514044", "$5.98", "https://itbook.store/img/books/9780596514044.png", "https://itbook.store/books/9780596514044"));
        books.add(new Book("Learning SQL, 2nd Edition", "Master SQL Fundamentals", "9780596520830", "$14.50", "https://itbook.store/img/books/9780596520830.png", "https://itbook.store/books/9780596520830"));
        books.add(new Book("SQL and Relational Theory", "How to Write Accurate SQL Code", "9780596523060", "$3.50", "https://itbook.store/img/books/9780596523060.png", "https://itbook.store/books/9780596523060"));
        books.add(new Book("A Developer's Guide to Data Modeling for SQL Server", "Covering SQL Server 2005 and 2008", "9780321497642", "$6.15", "https://itbook.store/img/books/9780321497642.png", "https://itbook.store/books/9780321497642"));
        books.add(new Book("Oracle PL/SQL Language Pocket Reference, 4th Edition", "A Guide to Oracle's PL/SQL Language Fundamentals", "9780596514044", "$5.98", "https://itbook.store/img/books/9780596514044.png", "https://itbook.store/books/9780596514044"));
        books.add(new Book("Learning SQL, 2nd Edition", "Master SQL Fundamentals", "9780596520830", "$14.50", "https://itbook.store/img/books/9780596520830.png", "https://itbook.store/books/9780596520830"));
        books.add(new Book("SQL and Relational Theory", "How to Write Accurate SQL Code", "9780596523060", "$3.50", "https://itbook.store/img/books/9780596523060.png", "https://itbook.store/books/9780596523060"));
        books.add(new Book("A Developer's Guide to Data Modeling for SQL Server", "Covering SQL Server 2005 and 2008", "9780321497642", "$6.15", "https://itbook.store/img/books/9780321497642.png", "https://itbook.store/books/9780321497642"));
        books.add(new Book("Oracle PL/SQL Language Pocket Reference, 4th Edition", "A Guide to Oracle's PL/SQL Language Fundamentals", "9780596514044", "$5.98", "https://itbook.store/img/books/9780596514044.png", "https://itbook.store/books/9780596514044"));
        books.add(new Book("Learning SQL, 2nd Edition", "Master SQL Fundamentals", "9780596520830", "$14.50", "https://itbook.store/img/books/9780596520830.png", "https://itbook.store/books/9780596520830"));
        books.add(new Book("SQL and Relational Theory", "How to Write Accurate SQL Code", "9780596523060", "$3.50", "https://itbook.store/img/books/9780596523060.png", "https://itbook.store/books/9780596523060"));
        books.add(new Book("A Developer's Guide to Data Modeling for SQL Server", "Covering SQL Server 2005 and 2008", "9780321497642", "$6.15", "https://itbook.store/img/books/9780321497642.png", "https://itbook.store/books/9780321497642"));
        books.add(new Book("Oracle PL/SQL Language Pocket Reference, 4th Edition", "A Guide to Oracle's PL/SQL Language Fundamentals", "9780596514044", "$5.98", "https://itbook.store/img/books/9780596514044.png", "https://itbook.store/books/9780596514044"));
        books.add(new Book("Learning SQL, 2nd Edition", "Master SQL Fundamentals", "9780596520830", "$14.50", "https://itbook.store/img/books/9780596520830.png", "https://itbook.store/books/9780596520830"));
        books.add(new Book("SQL and Relational Theory", "How to Write Accurate SQL Code", "9780596523060", "$3.50", "https://itbook.store/img/books/9780596523060.png", "https://itbook.store/books/9780596523060"));

        return books;

    }


}