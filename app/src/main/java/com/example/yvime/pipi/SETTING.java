package com.example.yvime.pipi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SETTING extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ImageButton buy=findViewById(R.id.buy);
        ImageButton bt5=findViewById(R.id.line);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(SETTING.this,MainActivity.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(SETTING.this,SelectPage.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
    }
}
