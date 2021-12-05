package com.anagabriela.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MovieCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView movieImage;
    public TextView movietitle;
    public TextView movieState;

    public MovieCardViewHolder(@NonNull View itemView) {
        super(itemView);
        movieImage = itemView.findViewById(R.id.movie_image);
        movietitle = itemView.findViewById(R.id.movie_title);
        movieState = itemView.findViewById(R.id.movie_state);
    }


}
