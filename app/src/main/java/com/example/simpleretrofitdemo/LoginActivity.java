package com.example.simpleretrofitdemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.simpleretrofitdemo.restapi.SimpleRestApi;
import com.example.simpleretrofitdemo.restclient.SimpleRestClient;
import com.example.simpleretrofitdemo.resthandler.SimpleResponseHandler;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by admin on 7/8/2015.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout emailTextInputLayout;
    TextInputLayout passwordTextInputLayout;
    SimpleRestApi simpleRestApi;
    ProgressBar progressBar;

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
                getLoginDetails();
            }
        });

    }

    @Override
    public void onClick(View v) {
        /*switch (v.getId()) {

            case R.id.login_btn:
                Toast.makeText(getBaseContext(), "Click!", Toast.LENGTH_LONG).show();
                getLoginDetails();
                break;

        }*/
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

        progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);

        simpleRestApi = new SimpleRestClient().getSimpleRestApi();
        simpleRestApi.getSimpleResponse(email, password, new Callback<SimpleResponseHandler>() {
            @Override
            public void success(SimpleResponseHandler responseHandler, Response response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {

                    Toast.makeText(LoginActivity.this, "Username: " + responseHandler.getEmail()
                            + " Password: " + responseHandler.getPassword(), Toast.LENGTH_SHORT).show();
                    Snackbar.make(LoginActivity.this.findViewById(android.R.id.content),
                            "Username: " + responseHandler.getEmail()
                                    + " Password: " + responseHandler.getPassword(),
                            Snackbar.LENGTH_LONG).show();

                } else {
                    Toast.makeText(LoginActivity.this, "Username or Password is incorrect. Try again.", Toast.LENGTH_SHORT).show();
                    Snackbar.make(LoginActivity.this.findViewById(android.R.id.content),
                            "Username or Password is incorrect. Try again.", Snackbar.LENGTH_LONG).show();

                }

            }

            @Override
            public void failure(RetrofitError error) {
                progressBar.setVisibility(View.GONE);
                Snackbar.make(LoginActivity.this.findViewById(android.R.id.content),
                        "Something went wrong. Please try again.", Snackbar.LENGTH_LONG).show();
            }
        });

    }
}
