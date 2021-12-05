package com.anagabriela.peliculas.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.anagabriela.peliculas.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Movie {
    private static final String TAG = Movie.class.getSimpleName();

    public final String title;
    public final Uri dynamicUrl;
    public final String url;
    public final String state;
    public final String description;

    public Movie(
            String title, String dynamicUrl, String url, String state, String description) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.state = state;
        this.description = description;
    }

    public static List<Movie> initMovieList(Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.movie);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception) {
            Log.e(TAG, "Error writing/reading from the JSON file.", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Error closing the input stream.", exception);
            }
        }
        String jsonProductsString = writer.toString();
        Gson gson = new Gson();
        Type movieListType = new TypeToken<ArrayList<Movie>>() {
        }.getType();
        return gson.fromJson(jsonProductsString, movieListType);
    }
}