package com.example.yvime.pipi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.yvime.pipi.Informationview.Qrcode;
import com.example.yvime.pipi.Top.Top;
import com.example.yvime.pipi.shoppingcartview.Shoppingcart;
import com.example.yvime.pipi.shoppingcartview.swipe_adapter.RecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class offline_access extends AppCompatActivity {
    DatabaseReference mRef;
    DatabaseReference mRef2;
    RecyclerView mRecyclerView1;
    FirebaseDatabase mFirebaseDatabase;
    private RecyclerAdapter adapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_access);
        ImageButton bt1 = findViewById(R.id.imageButton1);
        ImageButton bt2 = findViewById(R.id.imageButton2);
        ImageButton bt3 = findViewById(R.id.imageButton3);
        ImageButton buy = findViewById(R.id.buy);
        ImageButton line = findViewById(R.id.line);
        mRecyclerView1 = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView1.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter<String>(list, this);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRecyclerView1.setLayoutManager(new GridLayoutManager(offline_access.this, 1));
        //mRecyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView1.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView1.setHasFixedSize(true);
        mRecyclerView1.setAdapter(adapter);
        mRef = mFirebaseDatabase.getReference("account");


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(offline_access.this, Top.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(offline_access.this, Qrcode.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(offline_access.this,MainActivity.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(offline_access.this, SelectPage.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(offline_access.this,Shoppingcart.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }

    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                       Model.class,
                        R.layout.list,
                        ViewHolder.class,
                        mRef
                ) {


                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model post, int position) {
                        viewHolder.setShopping123(getApplicationContext(), post.getadd(), post.getdel(), post.getName(),post.getphone());

                    }


                };
        mRecyclerView1.setAdapter(firebaseRecyclerAdapter);
    }
}
