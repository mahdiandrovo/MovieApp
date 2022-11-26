package com.drovo.movieapp.Service.Network;

import com.drovo.movieapp.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    //here we can handle out api calls
    //like get, post etc...

    @GET("3/movie/top_rated?api_key=1ca10747f6068ba2b697d51a2e5effc2")
    Call<MovieModel> getMovieList();

}
