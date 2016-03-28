package com.example.simpleretrofitdemo.retrofit2;

import com.example.simpleretrofitdemo.data.PostsHandler;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 7/8/2015.
 */
public interface SimpleRestApi {

    @GET("2.2/questions")
    Call<PostsHandler> getPosts(@Query("pagesize") int pagesize,
                                   @Query("order") String order,
                                   @Query("sort") String sort,
                                   @Query("site") String site);

}
