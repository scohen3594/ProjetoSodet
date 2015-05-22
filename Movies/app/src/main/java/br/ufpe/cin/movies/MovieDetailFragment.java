package br.ufpe.cin.movies;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import org.w3c.dom.Text;

public class MovieDetailFragment extends Fragment {

    private Movie movie;

    public MovieDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        Intent intent = getActivity().getIntent();

        getActivity().setTitle(intent.getStringExtra("movieName"));

        //Criação dos ImageView e TextView onde as informaçoes da API sao escritas na tela

        ImageView imagePoster = (ImageView) view.findViewById(R.id.imgPoster);
        Ion.with(imagePoster).placeholder(R.drawable.icon).error(R.drawable.icon).load(intent.getStringExtra("moviePoster"));

        TextView movieOriginalName = (TextView) view.findViewById(R.id.movieOriginalName);
        movieOriginalName.setText("\n" + intent.getStringExtra("movieOriginalName"));

        TextView movieSinopse = (TextView) view.findViewById(R.id.movieSinopse);
        movieSinopse.setText("\n" + intent.getStringExtra("movieSinopse"));

        TextView movieDirector = (TextView) view.findViewById(R.id.movieDirector);
        movieDirector.setText("\n" + intent.getStringExtra("movieDirector"));

        TextView movieClassification = (TextView) view.findViewById(R.id.movieClassification);
        movieClassification.setText("\n" + intent.getStringExtra("movieClassification"));

        TextView movieYear = (TextView) view.findViewById(R.id.movieYear);
        movieYear.setText("\n" + intent.getStringExtra("movieYear"));

        TextView movieImdbRating = (TextView) view.findViewById(R.id.movieImdbRating);
        movieImdbRating.setText("\n" + intent.getStringExtra("movieImdbRating"));

        TextView movieDuration = (TextView) view.findViewById(R.id.movieDuration);
        movieDuration.setText("\n" + intent.getStringExtra("movieDuration"));

        TextView movieWriter = (TextView) view.findViewById(R.id.movieWriter);
        movieWriter.setText("\n" + intent.getStringExtra("movieWriter"));

        TextView movieGenre = (TextView) view.findViewById(R.id.movieGenre);
        movieGenre.setText("\n" + intent.getStringExtra("movieGenre"));

        TextView movieCast = (TextView) view.findViewById(R.id.movieCast);
        movieCast.setText("\n" + intent.getStringExtra("movieCast"));

        TextView movieNational = (TextView) view.findViewById(R.id.movieNational);
        if ((intent.getStringExtra("movieNational")).equals("false")) {
            movieNational.setText("\nNo");
        } else if ((intent.getStringExtra("movieNational")).equals("false")) {
            movieNational.setText("\nYes");
        } else {
            movieNational.setText("\n");
        }

        TextView movieImdbUrl = (TextView) view.findViewById(R.id.movieImdbUrl);
        movieImdbUrl.setText("\n" + intent.getStringExtra("movieImdbUrl"));

        TextView movieTrailer = (TextView) view.findViewById(R.id.movieTrailer);
        movieTrailer.setText("\n" + intent.getStringExtra("movieTrailer") + "\n");

        ImageView imageBackdrop = (ImageView) view.findViewById(R.id.imgBackdrop);
        Ion.with(imageBackdrop).placeholder(R.drawable.icon).error(R.drawable.icon).load(intent.getStringExtra("movieBackdrop"));

        TextView sessions = (TextView) view.findViewById(R.id.sessions);
        sessions.setText("\n" + intent.getStringExtra("sessions"));

        return view;
    }
}
