package com.dayal.moviedirectory.activities;


import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dayal.moviedirectory.R;
import com.dayal.moviedirectory.data.MovieRecyclerViewAdapter;
import com.dayal.moviedirectory.model.Movie;
import com.dayal.moviedirectory.util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieRecyclerViewAdapter adapter;
    private List<Movie> movieList;
    private RequestQueue queue;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue= Volley.newRequestQueue(this);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieList=new ArrayList<>();
        movieList = getMovies("");
        adapter = new MovieRecyclerViewAdapter(getApplicationContext(),movieList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    public List<Movie> getMovies(String searchTerm){
        movieList.clear();
//        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
//        progressBar.setVisibility(View.VISIBLE);
        JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.GET, Constants.URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray movieArray=response.getJSONArray("search");
                      for (int i=0;i<movieArray.length();i++){
                          JSONObject jsonObject = movieArray.getJSONObject(i);
                          Movie movie=new Movie();
                          movie.setmovieTitle(jsonObject.getString("title"));
                          movie.setMovieYear("Year: " + jsonObject.getString("userId"));
                          movie.setMovieID(jsonObject.getString("id"));
                          movie.setMoviePoster(Constants.POSTER_URL);
                          movie.setMovieType("Type: " + "movie");
                          Log.w("log",movie.getmovieTitle());
                          movieList.add(movie);
//                          progressBar.setVisibility(View.INVISIBLE);
                      }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Server not responding",Toast.LENGTH_LONG).show();
            }
        });
        queue.add(objectRequest);
        return movieList;
    }

}
