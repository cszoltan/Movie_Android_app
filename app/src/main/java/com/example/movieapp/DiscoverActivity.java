package com.example.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiscoverActivity extends AppCompatActivity {
    private EditText editView;
    private RadioGroup radio;
    private RadioButton selected;
    private ListView movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        editView = (EditText) findViewById(R.id.editText2);
        radio = (RadioGroup) findViewById(R.id.radioGroup);
        movies = (ListView) findViewById(R.id.listView);
    }

    public void requestByQuery(View view) {
        Integer year = Integer.parseInt(editView.getText().toString().trim());
        String API_BASE_URL = "https://api.themoviedb.org/";
        int selectedId = radio.getCheckedRadioButtonId();
        selected = (RadioButton) findViewById(selectedId);
        String sortBy = selected.getText().toString().trim().toLowerCase() + ".desc";
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit = builder.client(httpClient.build()).build();

        DiscoverAPI client = retrofit.create(DiscoverAPI.class);

        Call<DiscoverResponse> call = client.movieDetails("73fc903f862d78126b18ed88a8013f59", sortBy, year);

        call.enqueue(new Callback<DiscoverResponse>() {
            @Override
            public void onResponse(Call<DiscoverResponse> call, Response<DiscoverResponse> response) {
                List<Discover> results = response.body().getResults();
                if (results.size() > 10) {
                    results.subList(10, results.size()).clear();
                }
                movies.setAdapter(new DiscoverAdapter(DiscoverActivity.this, results));
            }

            @Override
            public void onFailure(Call<DiscoverResponse> call, Throwable t) {

            }
        });
    }
}
