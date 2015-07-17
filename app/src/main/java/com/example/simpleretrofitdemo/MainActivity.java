package com.example.simpleretrofitdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.simpleretrofitdemo.adapter.SimpleRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getResources().getString(R.string.app_name));
        collapsingToolbar.setExpandedTitleColor(Color.BLACK);

        String user_name = getIntent().getStringExtra("user_name");
        if(user_name != null || user_name.equals("")){

            Snackbar.make(toolbar, "Hello "+ user_name, Snackbar.LENGTH_LONG).show();

        }

        loadBackdrop();
        loadListView();


    }

    private void loadBackdrop() {

        ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(R.drawable.img_smartphones).centerCrop().into(imageView);

    }

    private void loadListView() {

        String[] list = new String[20];
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = "String listview item " + i;
        }

        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter = new SimpleRecyclerViewAdapter(this, list);
        recyclerview.setAdapter(simpleRecyclerViewAdapter);

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
