package com.example.yvime.pipi.shoppingcartview.swipe_adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yvime.pipi.R;

/**
 * ViewHolder复用的layout id
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    View mView;
    int sum =0;
    public TextView mname;

    public TextView textView,del;


    public MyViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.nitem);
        del = (TextView) itemView.findViewById(R.id.tv);
    }


}