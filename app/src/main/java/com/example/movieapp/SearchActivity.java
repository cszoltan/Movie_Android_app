package com.example.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SearchActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView2);
    }

    public void requestById(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String id = editText.getText().toString().trim();

        String API_BASE_URL = "https://api.themoviedb.org/";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit = builder.client(httpClient.build()).build();

        MovieAPI client = retrofit.create(MovieAPI.class);

        Call<MovieResponse> call = client.movieDetails(id);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
                MovieResponse details = response.body();
                textView.setText(details.getMovies().get(0).getOriginal_title());
                String imgSrc = "http://image.tmdb.org/t/p/w185" + details.getMovies().get(0).getPoster_path();
                Picasso.get()
                        .load(imgSrc)
                        .into(imageView);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
            }
        });
    }
}
