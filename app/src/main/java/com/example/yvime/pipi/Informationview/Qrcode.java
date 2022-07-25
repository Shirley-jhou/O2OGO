package com.example.yvime.pipi.Informationview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.yvime.pipi.MainActivity;
import com.example.yvime.pipi.R;
import com.example.yvime.pipi.SelectPage;
import com.example.yvime.pipi.Top.Top;
import com.example.yvime.pipi.shoppingcartview.Shoppingcart;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Qrcode extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final Activity Activity=this;
        setContentView(R.layout.activity_qrcode);
       ImageButton bt1=findViewById(R.id.imageButton1);
        ImageButton bt2=findViewById(R.id.imageButton2);
        ImageButton bt3=findViewById(R.id.imageButton3);
        ImageButton bt5=findViewById(R.id.line);
        ImageButton buy=findViewById(R.id.buy);
        Button scanbt = findViewById(R.id.qrbtn);

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Qrcode.this,SelectPage.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Qrcode.this,Top.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Qrcode.this,Qrcode.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Qrcode.this,Shoppingcart.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Qrcode.this,MainActivity.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });

        scanbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(Activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null){
            if(result.getContents()==null){
                Toast.makeText(this,"YOU CANCELLED THE SCANNING",Toast.LENGTH_LONG).show(); }
                else {
                Toast.makeText(this,result.getContents(),Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putString("THINGNAME", result.getContents());
                switch ( result.getContents()){
                    case "4718785920203":   Intent intent=new Intent();//创建Intent对象
                        intent.setAction(Intent.ACTION_VIEW);//为Intent设置动作
                        intent.setData(Uri.parse("http://www.pxmart.com.tw/px/ingredients.px?id=93"));//为Intent设置数据
                        startActivity(intent);//将Intent传递给Activity
                        break;
                    case "2011084700838":   Intent intent2=new Intent();//创建Intent对象
                        intent2.setAction(Intent.ACTION_VIEW);//为Intent设置动作
                        intent2.setData(Uri.parse("http://www.pxmart.com.tw/px/ingredients.px?id=83"));//为Intent设置数据
                        startActivity(intent2);//将Intent传递给Activity
                        break;
                    case "2011505000004":   Intent intent3=new Intent();//创建Intent对象
                        intent3.setAction(Intent.ACTION_VIEW);//为Intent设置动作
                        intent3.setData(Uri.parse("http://www.pxmart.com.tw/px/ingredients.px?id=87"));//为Intent设置数据
                        startActivity(intent3);//将Intent传递给Activity
                        break;
                    case "2011031300005":   Intent intent4=new Intent();//创建Intent对象
                        intent4.setAction(Intent.ACTION_VIEW);//为Intent设置动作
                        intent4.setData(Uri.parse("http://www.pxmart.com.tw/px/ingredients.px?id=111"));//为Intent设置数据
                        startActivity(intent4);//将Intent传递给Activity
                        default:
                            Intent THING = new Intent(Qrcode.this,Things_informations.class);
                            THING.putExtras(bundle);
                            startActivity(THING);break;
                }


            }
        }
    else{
            super.onActivityResult(requestCode,resultCode,data);
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
