package com.retrofit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by syed on 27/7/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

//    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
//        this.movies = movies;
//        this.rowLayout = rowLayout;
//        this.context = context;
//    }

    public MoviesAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

//    public MoviesAdapter(Context context, List<Movie> movies) {
//
//        this.movies = movies;
//        this.context = context;
//
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;

        public MyViewHolder(View itemView) {
            super(itemView); moviesLayout = (LinearLayout) itemView.findViewById(R.id.movies_layout);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            data = (TextView) itemView.findViewById(R.id.subtitle);
            movieDescription = (TextView) itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);


        }
    }


    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.MyViewHolder holder, final int position) {

        final Movie movie = movies.get(position);

        holder.movieTitle.setText(movie.getTitle());
        holder.data.setText(movie.getReleaseDate());
        holder.movieDescription.setText(movie.getOverview());
        holder.rating.setText(movie.getVoteAverage().toString());
        holder.moviesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MovieDetailActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("movie",movie);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        if (movies == null) return 0;
        return movies.size();
    }


}
