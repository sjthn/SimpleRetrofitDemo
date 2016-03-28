package com.example.simpleretrofitdemo.ui;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.simpleretrofitdemo.R;
import com.example.simpleretrofitdemo.data.PostsHandler;
import com.example.simpleretrofitdemo.retrofit2.SimpleRestApi;
import com.example.simpleretrofitdemo.retrofit2.SimpleRestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int PAGE_SIZE = 10;
    private static final String PAGE_ORDER = "desc";
    private static final String PAGE_SORT = "activity";
    private static final String SITE = "stackoverflow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getResources().getString(R.string.app_name));
//        collapsingToolbar.setExpandedTitleColor(Color.BLACK);

        loadBackdrop();
        loadListView();


    }

    private void loadBackdrop() {

        ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(R.drawable.retro_scenery).centerCrop().into(imageView);

    }

    private void loadListView() {

        SimpleRestClient restClient = new SimpleRestClient();
        SimpleRestApi simpleRestApi = restClient.getSimpleRestApi();
        Call<PostsHandler> posts = simpleRestApi.getPosts(PAGE_SIZE, PAGE_ORDER, PAGE_SORT, SITE);
        posts.enqueue(new Callback<PostsHandler>() {
            @Override
            public void onResponse(Call<PostsHandler> call, Response<PostsHandler> response) {
                RecyclerView recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
                recyclerview.setHasFixedSize(true);
                recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                SimpleRecyclerViewAdapter simpleRecyclerViewAdapter = new
                        SimpleRecyclerViewAdapter(MainActivity.this, response.body());
                recyclerview.setAdapter(simpleRecyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<PostsHandler> call, Throwable t) {
                Log.d(TAG, "Failure Cause: " + t.getCause());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
