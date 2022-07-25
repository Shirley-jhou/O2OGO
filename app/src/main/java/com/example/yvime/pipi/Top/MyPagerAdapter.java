package com.example.yvime.pipi.Top;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.yvime.pipi.R;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Integer> list;
    private LayoutInflater inflater;

    public MyPagerAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }




    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 佈局
        View itemView = inflater
                .inflate(R.layout.fragment_pager_list, container, false);

        // 佈局元件內容
        ImageView imageView = (ImageView)itemView.findViewById(R.id.imageView);
        imageView.setImageResource(list.get(position));

        // 加載
        (container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // LinearLayout 是以 cell_pager_image 主體變更
        container.removeView((LinearLayout) object);
    }

}