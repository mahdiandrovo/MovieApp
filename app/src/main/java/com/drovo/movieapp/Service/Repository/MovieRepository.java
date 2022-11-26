package com.drovo.movieapp.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.drovo.movieapp.Service.Model.MovieModel;
import com.drovo.movieapp.Service.Model.Result;
import com.drovo.movieapp.Service.Network.ApiServices;
import com.drovo.movieapp.Service.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static Context mContext;
    private static MovieRepository instance;

    private MovieModel movieModel;
    private List<Result> mResult;

    private MutableLiveData mutableLiveData;


    public static MovieRepository getInstance(Context context){
        if (instance == null){
            mContext = context;
            instance = new MovieRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Result>> movieResult(){
        if(mutableLiveData == null){
            mutableLiveData = new MutableLiveData();
        }
        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);
        Call<MovieModel> call = apiServices.getMovieList();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                movieModel = response.body();
                mResult = movieModel.getResults();
                mutableLiveData.postValue(mResult);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
