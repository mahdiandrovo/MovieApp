package com.drovo.movieapp.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.drovo.movieapp.R;
import com.drovo.movieapp.Service.Model.Result;

import org.w3c.dom.Text;

import java.util.List;

public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.MyViewHolder>{

    private Context context;
    private List<Result> movieList;

    public TopMovieListAdapter(Context context, List<Result> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_movie_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.movieName.setText(movieList.get(position).getTitle());
        holder.movieRating.setText(""+movieList.get(position).getVoteAverage());
        holder.movieReleaseDate.setText(movieList.get(position).getReleaseDate());

        //for image
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+movieList.get(position).getPosterPath()).into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        if (this.movieList != null){
            return movieList.size();
        } else {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView movieImage;
        TextView movieName;
        TextView movieRating;
        TextView movieReleaseDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movieImage);
            movieName = itemView.findViewById(R.id.movieName);
            movieRating = itemView.findViewById(R.id.movieRating);
            movieReleaseDate = itemView.findViewById(R.id.movieReleaseDate);
        }
    }

}
