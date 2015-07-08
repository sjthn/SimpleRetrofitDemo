package com.example.simpleretrofitdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by admin on 7/8/2015.
 */
public class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<SimpleRecyclerViewAdapter.SimpleViewHolder> {

    String[] items;
    Context context;

    public SimpleRecyclerViewAdapter(Context context, String[] items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public SimpleRecyclerViewAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        SimpleViewHolder simpleViewHolder = new SimpleViewHolder(v, context);
        return simpleViewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder simpleViewHolder, int i) {

        simpleViewHolder.itemNmae.setText(items[i]);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        TextView itemNmae;

        SimpleViewHolder(View itemView, Context context) {
            super(itemView);
            itemNmae = (TextView) itemView;
        }
    }

}
