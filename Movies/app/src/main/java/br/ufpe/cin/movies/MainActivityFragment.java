package br.ufpe.cin.movies;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivityFragment extends Fragment {

    private List<Movie> movies;
    private List<Session> sessions;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        final ListView listview = (ListView) view.findViewById(R.id.movieList);
        movies = new ArrayList<Movie>();

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String url = "http://sonae.sodet.biz/api/v1/movies/all/shopping-1";

        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray moviesList = response.getJSONArray("movie");

                    for(int i=0; i < moviesList.length(); i++){
                        //Criação do Objeto JSon a partir do ArrayList obtido através da API
                        JSONObject movie = moviesList.getJSONObject(i);
                        JSONArray movieSession = movie.getJSONArray("sessions");

                        sessions = new ArrayList<Session>();

                        for (int j=0; j < movieSession.length(); j++){
                            JSONObject session = movieSession.getJSONObject(j);

                            //Transformação de informações de room para um objeto JSon a fim de adiciona-lo no construtor de Session
                            JSONObject room = (JSONObject) session.get("room");

                            //Objeto JSon de session adicionado ao ArrayList de Session
                            sessions.add(new Session(session.getString("day"), session.getString("hour"), session.getBoolean("dubbed"),
                                    session.getBoolean("3D"), room.getString("name"), room.getInt("id")));

                        }

                        //Objetos JSon de movie adicionados a um ArrayList de Movie
                        movies.add(new Movie(movie.getInt("id"), movie.getString("name"), movie.getString("original_name"),
                                movie.getString("sinopse"), movie.getString("director"), movie.getString("classification"),
                                movie.getString("year"), movie.getDouble("imdb_rating"), movie.getString("duration"),
                                movie.getString("writer"), movie.getString("genre"), movie.getString("cast"),
                                movie.getString("imdb_url"), movie.getString("trailer"), movie.getString("poster"),
                                movie.getString("backdrop"), movie.getString("nacional"),
                                movie.getString("originalTitle"), sessions));

                    }

                    //Conversao do ArrayList para um formato de ListView
                    MovieListAdapter adapter = new MovieListAdapter(getActivity(), movies);
                    ((AdapterView<ListAdapter>) listview).setAdapter(adapter);

                }catch(Exception e){
                    Log.e("MainFragment", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });

        requestQueue.add(jsonArrayRequest);

        listview.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Movie item = (Movie) parent.getItemAtPosition(position);
                        NumberFormat form = new DecimalFormat("#0.00");

                        Intent intent = new Intent(getActivity(), MovieDetail.class);
                        intent.putExtra("id", item.getId());
                        intent.putExtra("movieName", item.getName());
                        intent.putExtra("movieOriginalName", item.getOriginalName());
                        intent.putExtra("movieSinopse", item.getSinopse());
                        intent.putExtra("movieDirector", item.getDirector());
                        intent.putExtra("movieClassification", item.getClassification());
                        intent.putExtra("movieYear", item.getYear());
                        intent.putExtra("movieImdbRating", String.valueOf(form.format(item.getImdbRating())));
                        intent.putExtra("movieDuration", item.getDuration());
                        intent.putExtra("movieWriter", item.getWriter());
                        intent.putExtra("movieGenre", item.getGenre());
                        intent.putExtra("movieCast", item.getCast());
                        intent.putExtra("movieImdbUrl", item.getImdbUrl());
                        intent.putExtra("movieTrailer", item.getTrailer());
                        intent.putExtra("moviePoster", item.getPoster());
                        intent.putExtra("movieBackdrop", item.getBackrop());
                        intent.putExtra("movieNational", item.getNational());

                        String sessions = "";
                        for (int s = 0; s < item.getSessions().size(); s++) {
                            sessions += "\nDay: " + item.getSessions().get(s).getDay() + "\nHour: " +
                                    item.getSessions().get(s).getHour()+ "\nRoom: " +
                                    item.getSessions().get(s).getRoom().getName() +
                                    "\nDubbed: ";

                            if (item.getSessions().get(s).getDubbed()) {
                                sessions += "Yes \n";
                            } else {
                                sessions += "No \n";
                            }

                            if (item.getSessions().get(s).getThreeD()) {
                                sessions += "3D: Yes \n";
                            } else {
                                sessions += "3D: No \n";
                            }
                        }

                        intent.putExtra("sessions", sessions);

                        startActivity(intent);

                    }
                }

        );

        return view;


    }



}
