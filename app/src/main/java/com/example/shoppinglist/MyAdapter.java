package com.example.shoppinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<ShopItem> mDataset;
    LayoutInflater inflater;
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public MyViewHolder(View v){
            super(v);
            textView=(TextView) v.findViewById(R.id.text_view);
        }

    }
    public MyAdapter( ArrayList<ShopItem> myDataset){
        mDataset = myDataset;

    }
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    public void onBindViewHolder(MyViewHolder holder,int position){
        ShopItem selectedProduct = mDataset.get(position);
        holder.textView.setText(mDataset.get(position).getItemName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
