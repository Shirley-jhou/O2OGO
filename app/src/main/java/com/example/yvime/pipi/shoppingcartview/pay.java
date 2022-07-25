package com.example.yvime.pipi.shoppingcartview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.yvime.pipi.Informationview.Qrcode;
import com.example.yvime.pipi.MainActivity;
import com.example.yvime.pipi.R;
import com.example.yvime.pipi.Top.Top;
import com.example.yvime.pipi.offline_access;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class pay extends AppCompatActivity {
    private DatabaseReference mm;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Bundle BUNDLE =this.getIntent().getExtras();
        final String log = BUNDLE.getString("log");
        final String name = BUNDLE.getString("NAME");
        final String phone1 = BUNDLE.getString("lPHONE");
        int SUMPRICE = BUNDLE.getInt("SUMPRICE");
        ImageButton bt1=findViewById(R.id.imageButton1);
        ImageButton bt2=findViewById(R.id.imageButton2);
        ImageButton bt3=findViewById(R.id.imageButton3);

        ImageButton buy=findViewById(R.id.buy);
        Button bt6=findViewById(R.id.button6);
        Button bt7=findViewById(R.id.button7);



        mDatabase= FirebaseDatabase.getInstance().getReference();
        mm = FirebaseDatabase.getInstance().getReference("account");





        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gologin = new Intent(pay.this,Top.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(pay.this,Qrcode.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(pay.this,Shoppingcart.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(pay.this,MainActivity.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(pay.this,MainActivity.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
       bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BUY();
            }
        });
    }

    private void BUY() {


        final EditText et = new EditText(this);



        et.setText("台北市中正區貴陽街一段56號");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setMessage("購買人:王小明"+"\n電話:0910123456")
                .setTitle("確認地址")
                .setView(et)





                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {



                        Intent gologin = new Intent(pay.this,offline_access.class);

                        startActivity(gologin);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // 右方按鈕方法
                        // myview.setText("點擊右邊按鈕");
                    }
                });
        AlertDialog about_dialog = builder.create();



        about_dialog.show();


    }
}
