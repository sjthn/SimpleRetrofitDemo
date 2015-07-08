package com.example.simpleretrofitdemo.restcallback;

import com.example.simpleretrofitdemo.resthandler.SimpleResponseHandler;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by admin on 7/8/2015.
 */
public abstract class SimpleRestCallback<T> implements Callback<T> {

    public abstract void failure(SimpleResponseHandler responseHandler);

    @Override
    public void failure(RetrofitError error) {

    }
}
