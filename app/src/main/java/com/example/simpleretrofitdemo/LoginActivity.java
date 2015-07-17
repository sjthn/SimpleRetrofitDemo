package com.example.simpleretrofitdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

import com.example.simpleretrofitdemo.restapi.SimpleRestApi;
import com.example.simpleretrofitdemo.restclient.SimpleRestClient;
import com.example.simpleretrofitdemo.resthandler.SimpleResponseHandler;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by admin on 7/8/2015.
 */
public class LoginActivity extends AppCompatActivity {

    TextInputLayout emailTextInputLayout;
    TextInputLayout passwordTextInputLayout;
    SimpleRestApi simpleRestApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_login);
        emailTextInputLayout = (TextInputLayout) findViewById(R.id.email_text_input_layout);
        emailTextInputLayout.setErrorEnabled(true);
        passwordTextInputLayout = (TextInputLayout) findViewById(R.id.password_text_input_layout);
        passwordTextInputLayout.setErrorEnabled(true);

        findViewById(R.id.user_login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                getLoginDetails();
            }
        });

    }

    private void getLoginDetails() {

        AutoCompleteTextView emailAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.email_edit_text);
        AutoCompleteTextView passwordAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.password_edit_text);
        String email = emailAutoCompleteTextView.getText().toString();
        String password = passwordAutoCompleteTextView.getText().toString();
        if (email.equals("")) {
            emailTextInputLayout.setError("email required!");
            return;
        }
        if (password.equals("")) {
            passwordTextInputLayout.setError("Password required!");
            return;
        }

        getLoginResponse(email, password);

    }

    private void getLoginResponse(String email, String password) {

        final ProgressDialog progress = new ProgressDialog(this);

        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);

        simpleRestApi = new SimpleRestClient().getSimpleRestApi();
        simpleRestApi.getSimpleResponse(email, password, new Callback<SimpleResponseHandler>() {
            @Override
            public void success(SimpleResponseHandler responseHandler, Response response) {
                progress.dismiss();
                Log.e("CLASS", "JSON: " + responseHandler.getUserName());
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("user_name", responseHandler.getUserName());
                startActivity(intent);
            }

            @Override
            public void failure(RetrofitError error) {
                progress.dismiss();
                Log.e("CLASS", "JSON: " + error.getCause());
            }
        });

    }
}
