package com.dayal.moviedirectory.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dayal.moviedirectory.R;
import com.dayal.moviedirectory.activities.MainActivity;
import com.dayal.moviedirectory.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Movie> movieList;

    public MovieRecyclerViewAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public MovieRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row,parent,false);
        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(MovieRecyclerViewAdapter.ViewHolder holder, int position) {
       Movie movie=movieList.get(position);
        String posterLink=movie.getMoviePoster();
        holder.title.setText(movie.getmovieTitle());
        holder.year.setText(movie.getMovieYear());
        holder.type.setText(movie.getMovieType());
        Picasso.with(context)
                .load(posterLink)
                .placeholder(android.R.drawable.ic_dialog_info)
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
       return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        TextView year;
        ImageView poster;
        TextView type;
        public ViewHolder(View itemView,Context ctx) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.movieTitleID);
            year=(TextView)itemView.findViewById(R.id.movieReleasedID);
            type=(TextView)itemView.findViewById(R.id.categoryID);
            poster=(ImageView)itemView.findViewById(R.id.moviePosterID);

        }

        @Override
        public void onClick(View view) {

        }
    }
}

