package br.ufpe.cin.movies;

import android.content.Context;
import br.ufpe.cin.movies.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Simone Cohen on 20/05/2015.
 */
public class MovieListAdapter extends ArrayAdapter<Movie> {


    private List<Movie> movies;

    public MovieListAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
        this.movies = movies;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView text1 = (TextView) convertView.findViewById(android.R.id.text1);

        Movie movie = getItem(position);
        text1.setText(movie.getName());

        return convertView;
    }

    public Movie getItem(int position){
        return movies.get(position);
    }

}
