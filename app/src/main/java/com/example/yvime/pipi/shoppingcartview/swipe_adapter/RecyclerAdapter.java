package com.example.yvime.pipi.shoppingcartview.swipe_adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.yvime.pipi.ItemSlideHelper;
import com.example.yvime.pipi.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;


/**
 *
 */
public class RecyclerAdapter<T> extends RecyclerView.Adapter implements ItemSlideHelper.Callback {
    private ItemSlideHelper.Callback mcallback;
    private  int pos;
    private List<T> mData;
    private Context mContext;
    DatabaseReference mRef;
    private RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;

    public RecyclerAdapter(List<T> mData, Context context) {
        this.mData = mData;
        this.mContext = context;

    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row3, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        setListener(parent, holder, viewType);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
     pos= position;
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.textView.setText(mData.get(position).toString());
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "textView-onClick->>>" + mData.get(position).toString(), Toast.LENGTH_LONG).show();

            }
        });

        /*viewHolder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mData.remove(position);
                RecyclerAdapter.this.remove(position);
                //RecyclerAdapter.this.notifyDataSetChanged();
                //Toast.makeText(mContext, "del-onClick->>>" + mData.get(position).toString(), Toast.LENGTH_LONG).show();

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void remove(int model) {
        this.notifyItemRemoved(pos);
    }

    protected void setListener(final ViewGroup parent, final MyViewHolder viewHolder, int viewType) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    mOnItemClickListener.onItemClick(v, viewHolder, mData.get(position), position);
                }
            }
        });

        viewHolder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mOnItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    mOnItemClickListener.delView(v, viewHolder, mData.get(position), position);
                }


            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    return mOnItemClickListener.onItemLongClick(v, viewHolder, mData.get(position), position);
                }
                return false;
            }
        });
    }


    public OnItemClickListener<T> mOnItemClickListener;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        mRecyclerView = recyclerView;
        mRecyclerView.addOnItemTouchListener(new ItemSlideHelper(mRecyclerView.getContext(), this));
    }

    @Override
    public int getHorizontalRange(RecyclerView.ViewHolder holder) {

        if(holder.itemView instanceof LinearLayout){
            ViewGroup viewGroup = (ViewGroup) holder.itemView;
            if(viewGroup.getChildCount() == 2){
                return viewGroup.getChildAt(1).getLayoutParams().width;
            }
        }


        return 0;
    }

    @Override
    public RecyclerView.ViewHolder getChildViewHolder(View childView) {
        return mRecyclerView.getChildViewHolder(childView);
    }

    @Override
    public View findTargetView(float x, float y) {
        return mRecyclerView.findChildViewUnder(x, y);
    }

    @Override
    public void updateItem() {


        Log.e("666666","7777777777777");
        this.notifyDataSetChanged();
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View view, RecyclerView.ViewHolder holder, T o, int position);

        boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, T o, int position);

        void delView(View view, RecyclerView.ViewHolder holder, T o, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

}