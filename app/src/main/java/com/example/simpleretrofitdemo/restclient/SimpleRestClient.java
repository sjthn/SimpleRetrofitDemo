package com.example.simpleretrofitdemo.restclient;

import com.example.simpleretrofitdemo.constants.Constants;
import com.example.simpleretrofitdemo.restapi.SimpleRestApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Srijith on 7/8/2015.
 */
public class SimpleRestClient {

    private SimpleRestApi simpleRestApi;

    public SimpleRestClient() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(Constants.BASE_URL)
                .build();

        simpleRestApi = restAdapter.create(SimpleRestApi.class);

    }

    public SimpleRestApi getSimpleRestApi() {

        return simpleRestApi;

    }

}
