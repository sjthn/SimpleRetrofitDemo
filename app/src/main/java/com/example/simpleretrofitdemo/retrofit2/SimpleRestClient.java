package com.example.simpleretrofitdemo.retrofit2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Srijith on 7/8/2015.
 */
public class SimpleRestClient {

    private static final String BASE_URL = "https://api.stackexchange.com/";

    private SimpleRestApi simpleRestApi;

    public SimpleRestClient() {

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        simpleRestApi = retrofit.create(SimpleRestApi.class);

    }

    public SimpleRestApi getSimpleRestApi() {

        return simpleRestApi;

    }

}
