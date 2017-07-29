package com.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    private TextView tvTitle,tvDescription;

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvTitle = (TextView) findViewById(R.id.movie_detail_title);
        tvDescription = (TextView) findViewById(R.id.movie_detail_description);

        Intent intent = getIntent();
        if (intent.hasExtra("movie")){
            movie = (Movie) intent.getSerializableExtra("movie");
        }

        tvTitle.setText(movie.getTitle());
        tvDescription.setText(movie.getOverview());
    }
}
