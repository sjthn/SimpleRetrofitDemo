package com.example.simpleretrofitdemo.resthandler;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 7/8/2015.
 */

public class SimpleResponseHandler {

    @Expose
    private Integer success;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @Expose
    private String message;

    /**
     *
     * @return
     * The success
     */
    public Integer getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Integer success) {
        this.success = success;
    }

    /**
     *
     * @return
     * The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     * The user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
