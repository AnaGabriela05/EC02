package com.anagabriela.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anagabriela.peliculas.network.ImageRequester;
import com.anagabriela.peliculas.network.Movie;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MovieCardRecyclerViewAdapter extends RecyclerView.Adapter<MovieCardViewHolder>{

    private List<Movie> movieList;
    private ImageRequester imageRequester;

    MovieCardRecyclerViewAdapter(List<Movie> movieList) {
        this.movieList = movieList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public MovieCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false);

        return new MovieCardViewHolder(layoutView);
    }
    @Override
    public void onBindViewHolder(@NonNull MovieCardViewHolder holder, int position) {
        if (movieList != null && position < movieList.size()) {
            Movie product = movieList.get(position);
            holder.movietitle.setText(product.title);
            holder.movieState.setText(product.state);
            imageRequester.setImageFromUrl(holder.movieImage, product.url);
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

}
