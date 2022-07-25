package com.example.yvime.pipi.pre.preorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.yvime.pipi.DividerItemDecoration;
import com.example.yvime.pipi.Model;
import com.example.yvime.pipi.R;
import com.example.yvime.pipi.SelectPage;
import com.example.yvime.pipi.ViewHolder;
import com.example.yvime.pipi.pre.preshoppinglist.pre_shoppinglist;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Preorder extends AppCompatActivity {
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mPRE;

    private RecyclerAdapter2 adapter2;
    private List<String> list2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder);
        mRecyclerView = findViewById(R.id.Preorder);


        adapter2 = new RecyclerAdapter2<>(list2, this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(Preorder.this, 1));
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mPRE = mFirebaseDatabase.getReference("online");
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter2);

        ImageButton bt1=findViewById(R.id.imageButton1);

        ImageButton bt3=findViewById(R.id.imageButton3);
        adapter2.setOnItemClickListener(new RecyclerAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder1, Object o, int position) {
                Toast.makeText(Preorder.this, "onItemClick-->>>"+list2.get(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder1, Object o, int position) {
                Toast.makeText(Preorder.this, "onItemLongClick-->>>"+list2.get(position), Toast.LENGTH_LONG).show();
                return true;//!!!!!!!!!!!!
            }

            @Override
            public void delView(View view, RecyclerView.ViewHolder holder1, Object o, int position) {
                list2.remove(position);
                //adapter.remove(position);
                //adapter.notifyDataSetChanged();
            }

        });
        ImageButton bt5=findViewById(R.id.line);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Preorder.this,SelectPage.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Preorder.this,Preorder.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Preorder.this,pre_shoppinglist.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

    }




    protected void onStart(){
        super.onStart();
        FirebaseRecyclerAdapter<Model,ViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<Model,ViewHolder>(
                        Model.class,
                        R.layout.row2,
                        ViewHolder.class,
                        mPRE
                ){


                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder,  Model model, int position) {
                        viewHolder.setPreorder(getApplicationContext(),model.getImg(),model.getPrice(),model.getName());

                    }



                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

}
