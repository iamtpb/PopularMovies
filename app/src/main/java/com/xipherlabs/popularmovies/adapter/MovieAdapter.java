package com.xipherlabs.popularmovies.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.xipherlabs.popularmovies.R;
import com.xipherlabs.popularmovies.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {

    public static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185";

    public MovieAdapter(Context context, ArrayList<Movie> data) {
        super(context, R.layout.movie_grid_item, data);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Movie movie = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_grid_item, parent, false);
        ImageView thumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
        Uri posterUri = Uri.parse(IMAGE_BASE_URL + movie.getPosterPath());
        Picasso.with(getContext()).load(posterUri).into(thumbnail);

        return convertView;
    }
}
