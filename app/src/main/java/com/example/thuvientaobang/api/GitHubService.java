package com.example.thuvientaobang.api;

import com.example.thuvientaobang.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService {

    //https://api.themoviedb.org/3/movie/popular?api_key=ffdb03735928fcc0efda02a0db29b49e&page=1
    @GET("3/movie/popular")
    Call<Movie> getMovies(
            @Query("api_key") String user,
            @Query("page") int page
    );
}
