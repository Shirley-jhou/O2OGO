package com.example.yvime.pipi.pre.preorder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yvime.pipi.R;

/**
 * ViewHolder复用的layout id
 */
public class MyViewHolder2 extends RecyclerView.ViewHolder {

    public TextView del,n;
    public ImageView img;


    public MyViewHolder2(View itemView) {
        super(itemView);
       img =  itemView.findViewById(R.id.rimgview);
        del = (TextView) itemView.findViewById(R.id.tv);

    }
}