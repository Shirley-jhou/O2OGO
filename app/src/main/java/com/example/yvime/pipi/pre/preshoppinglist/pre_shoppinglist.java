package com.example.yvime.pipi.pre.preshoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.yvime.pipi.R;
import com.example.yvime.pipi.SelectPage;
import com.example.yvime.pipi.pre.preorder.Preorder;

public class pre_shoppinglist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_shoppinglist);
        ImageButton bt1=findViewById(R.id.imageButton1);

        ImageButton bt3=findViewById(R.id.imageButton3);
        ImageButton bt5=findViewById(R.id.line);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(pre_shoppinglist.this,SelectPage.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(pre_shoppinglist.this,Preorder.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(pre_shoppinglist.this,pre_shoppinglist.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

    }
}
