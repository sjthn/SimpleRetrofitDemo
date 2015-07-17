package com.example.simpleretrofitdemo.restapi;

import com.example.simpleretrofitdemo.resthandler.SimpleResponseHandler;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by admin on 7/8/2015.
 */
public interface SimpleRestApi {

    @GET("----- ENTER URL PARAMETERS ------")
    public void getSimpleResponse(@Query("user_name") String username,
                                  @Query("user_password") String password,
                                  Callback<SimpleResponseHandler> handlerCallback);

}
