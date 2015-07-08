package com.example.simpleretrofitdemo.restapi;

import com.example.simpleretrofitdemo.restcallback.SimpleRestCallback;
import com.example.simpleretrofitdemo.resthandler.SimpleResponseHandler;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Query;

/**
 * Created by admin on 7/8/2015.
 */
public interface SimpleRestApi {

    @GET("/ObjectTracking/login.php/")
    public void getSimpleResponse(@Query("username") String username,
                                  @Query("pwd") String password,
                                  Callback<SimpleResponseHandler> handlerCallback);

    @Multipart
    @POST("/ObjectTracking/login.php")
    public void postSimpleRequest(@Part("username") String username,
                                  @Part("password") String password,
                                  SimpleRestCallback<SimpleResponseHandler> simpleRestCallback);

}
