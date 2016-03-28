package com.example.simpleretrofitdemo.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.simpleretrofitdemo.R;
import com.example.simpleretrofitdemo.data.PostsHandler;

/**
 * Created by admin on 7/8/2015.
 */
public class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<SimpleRecyclerViewAdapter.SimpleViewHolder> {

    private final PostsHandler posts;
    private Context context;

    public SimpleRecyclerViewAdapter(MainActivity context, PostsHandler items) {
        this.context = context;
        posts = items;
    }

    @Override
    public SimpleRecyclerViewAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.post_item_layout, viewGroup, false);
        return new SimpleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder viewHolder, int position) {

        viewHolder.title.setText("Q: " + posts.getItems().get(position).getTitle());
        viewHolder.tags.setText("Tags: " + posts.getItems().get(position).getTagsAsString());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return posts.getItems().size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        TextView title, tags;

        SimpleViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            tags = (TextView) itemView.findViewById(R.id.tags);
        }
    }

}
