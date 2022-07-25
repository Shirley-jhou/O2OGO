package com.example.yvime.pipi.Informationview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yvime.pipi.MainActivity;
import com.example.yvime.pipi.Model;
import com.example.yvime.pipi.R;
import com.example.yvime.pipi.SelectPage;
import com.example.yvime.pipi.Top.Top;
import com.example.yvime.pipi.shoppingcartview.Shoppingcart;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class Vote extends AppCompatActivity {
    Button yesBtn;
    Button noBtn;
    TextView yesText;
    TextView noText;
    private DatabaseReference mm;
    private DatabaseReference mDatabase;
    private String imgurl= "https://firebasestorage.googleapis.com/v0/b/itemlist-f47ab.appspot.com/o/banana.jpg?alt=media&token=d9a2ee40-9e1c-4ea7-bdfc-a35f7adee773";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        Bundle BUNDLE =this.getIntent().getExtras();
        String THINGNAME = BUNDLE.getString("THINGNAME");
        mDatabase= FirebaseDatabase.getInstance().getReference();
        mm = FirebaseDatabase.getInstance().getReference("itemlist");


        final ImageView aaa=findViewById(R.id.aaa);

        Query reference_contacts =mm.orderByChild("id").equalTo(THINGNAME);
        reference_contacts.addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Model itemprice=dataSnapshot.getValue(Model.class);
                imgurl=itemprice.getImage();
                Picasso.get().load(itemprice.getImage()).into(aaa);


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
        ImageButton bt1=findViewById(R.id.imageButton1);
        ImageButton bt2=findViewById(R.id.imageButton2);
        ImageButton bt3=findViewById(R.id.imageButton3);
        ImageButton buy=findViewById(R.id.buy);

        yesText = findViewById(R.id.tv_yes_count);

        noText = findViewById(R.id.tv_no_count);


        yesBtn = findViewById(R.id.btn_yes_vote);

        noBtn = findViewById(R.id.btn_no_vote);

        ImageButton bt5=findViewById(R.id.line);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Vote.this,SelectPage.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Vote.this,Top.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Vote.this,Qrcode.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Vote.this,MainActivity.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Vote.this,Shoppingcart.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });




    }
    public void onYesClicked(View v){
        String yesCount = yesText.getText().toString().trim();
        int count =Integer.parseInt(yesCount);
        count++;
        yesText.setText(String.valueOf(count));

    }
    public void onNoClicked(View v){

        String noCount = noText.getText().toString().trim();
        int count =Integer.parseInt(noCount);
        count++;
        noText.setText(String.valueOf(count));
    }
}