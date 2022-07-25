package com.example.yvime.pipi.pre.preorder;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.yvime.pipi.R;
import com.example.yvime.pipi.ItemSlideHelper;

import java.util.List;


/**
 *
 */
public class RecyclerAdapter2<T> extends RecyclerView.Adapter implements ItemSlideHelper.Callback {
    private List<T> mData;
    private Context mContext;

    private RecyclerView mRecyclerView;

    public RecyclerAdapter2(List<T> mData, Context context) {
        this.mData = mData;
        this.mContext = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row2, parent, false);
        MyViewHolder2 holder1 = new MyViewHolder2(view);
        setListener(parent, holder1, viewType);
        return holder1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder2 viewHolder = (MyViewHolder2) holder;
        viewHolder.n.setText(mData.get(position).toString());
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
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

    public void remove(int pos) {
        this.notifyItemRemoved(pos);
    }

    protected void setListener(final ViewGroup parent, final MyViewHolder2 viewHolder, int viewType) {
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


    public RecyclerAdapter2.OnItemClickListener<T> mOnItemClickListener;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        mRecyclerView = recyclerView;
        mRecyclerView.addOnItemTouchListener(new ItemSlideHelper(mRecyclerView.getContext(), this));
    }

    @Override
    public int getHorizontalRange(RecyclerView.ViewHolder holder1) {

        if(holder1.itemView instanceof LinearLayout){
            ViewGroup viewGroup = (ViewGroup) holder1.itemView;
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
        void onItemClick(View view, RecyclerView.ViewHolder holder1, T o, int position);

        boolean onItemLongClick(View view, RecyclerView.ViewHolder holder1, T o, int position);

        void delView(View view, RecyclerView.ViewHolder holder1, T o, int position);
    }

    public void setOnItemClickListener(RecyclerAdapter2.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

}