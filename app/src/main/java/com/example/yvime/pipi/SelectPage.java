package com.example.yvime.pipi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.yvime.pipi.Top.Top;
import com.example.yvime.pipi.pre.preorder.Preorder;
import com.example.yvime.pipi.pre.preshoppinglist.pre_shoppinglist;
import com.example.yvime.pipi.shoppingcartview.Post;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SelectPage extends AppCompatActivity {
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    private String login="on" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_page);
        ImageButton bt1 = findViewById(R.id.imageButton);
        ImageButton bt2 = findViewById(R.id.imageButton2);
        ImageButton bt3 = findViewById(R.id.imageButton3);
        ImageButton bt4 = findViewById(R.id.imageButton4);
        ImageButton bt5 = findViewById(R.id.imageButton5);
        ImageButton bt6 = findViewById(R.id.imageButton6);

        mFirebaseDatabase = FirebaseDatabase.getInstance();

        mRef = FirebaseDatabase.getInstance().getReference("loggg").child("0").child("name");
       mRef.addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Post itemprice=dataSnapshot.getValue(Post.class);
                login = itemprice.getName();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qrc = new Intent(SelectPage.this,Top.class);
                startActivity(qrc);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

       bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qrc = new Intent(SelectPage.this,Preorder.class);
                startActivity(qrc);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

       bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qrc = new Intent(SelectPage.this,pre_shoppinglist.class);
                startActivity(qrc);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });



        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();//创建Intent对象
                intent.setAction(Intent.ACTION_VIEW);//为Intent设置动作
                intent.setData(Uri.parse("http://www.pxmart.com.tw/px/recipe.px"));//为Intent设置数据
                startActivity(intent);//将Intent传递给Activity

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qrc = new Intent(SelectPage.this,SETTING.class);
                startActivity(qrc);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login.equals("off")){ Intent qrc = new Intent(SelectPage.this,login2.class);
                    startActivity(qrc);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);}
                    else{
                Intent qrc = new Intent(SelectPage.this,LOGIN.class);
                startActivity(qrc);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);}
            }
        });
    }
}
