package com.example.yvime.pipi.Top;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import com.example.yvime.pipi.Informationview.Qrcode;
import com.example.yvime.pipi.MainActivity;
import com.example.yvime.pipi.Model;
import com.example.yvime.pipi.R;
import com.example.yvime.pipi.SelectPage;
import com.example.yvime.pipi.ViewHolder;
import com.example.yvime.pipi.shoppingcartview.Shoppingcart;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Top extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    ArrayAdapter<String> fileDBAdapter;
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;

    private static final int[] pictures = { R.mipmap.ad01,R.mipmap.ad02,R.mipmap.ad03,R.mipmap.ad04};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        ImageButton bt1=findViewById(R.id.imageButton1);
        ImageButton bt2=findViewById(R.id.imageButton2);
        ImageButton bt3=findViewById(R.id.imageButton3);
        ImageButton buy=findViewById(R.id.buy);
        ImageButton bt5=findViewById(R.id.line);
        final Handler handler = new Handler();

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Top.this,SelectPage.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Top.this,Top.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Top.this,Qrcode.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Top.this,Shoppingcart.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Top.this,MainActivity.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(Top.this, 2));
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("itemlist");

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem((viewPager.getCurrentItem() + 1)%4) ;
            }
        };

        List<Integer> list = new ArrayList<Integer>();
        for(int i : pictures){
            list.add(i);
        }

        myPagerAdapter = new MyPagerAdapter(this, list);
        viewPager.setAdapter(myPagerAdapter);

       viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               handler.removeCallbacks(runnable);
               handler.postDelayed(runnable, 2000);
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });





    }
    protected void onStart(){
        super.onStart();
        FirebaseRecyclerAdapter<Model,ViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<Model,ViewHolder>(
                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef
                ){


                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder,  Model model, int position) {
                        viewHolder.setDetails(getApplicationContext(),model.getName(),model.getImage(),model.getPrice());

                    }



                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
