package com.example.simpleretrofitdemo.resthandler;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 7/8/2015.
 */
public class SimpleResponseHandler {

    @SerializedName("Name")
    public String mUserName;

    @SerializedName("Password")
    private String mPassword;

    public SimpleResponseHandler(String mUserName, String mPassword) {
        this.mUserName = mUserName;
        this.mPassword = mPassword;

    }

    public String getEmail() {
        return mUserName;
    }

    public String getPassword() {
        return mPassword;
    }

}
