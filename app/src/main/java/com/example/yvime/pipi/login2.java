package com.example.yvime.pipi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.yvime.pipi.shoppingcartview.Post;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class login2 extends AppCompatActivity {
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    private String name;
    private String phone1;
    private String phone22;
    private String del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        ImageButton buy=findViewById(R.id.buy);
        ImageButton bt5=findViewById(R.id.line);
        Button LOGIN = findViewById(R.id.login);
        final EditText phone = findViewById(R.id.editText);
//        phone22=Integer.parseInt(phone.getText().toString());
        mFirebaseDatabase = FirebaseDatabase.getInstance();

        mRef = FirebaseDatabase.getInstance().getReference("account");




        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(login2.this,MainActivity.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(login2.this,SelectPage.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
       LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone22= String.valueOf(phone.getText());
                Query reference_contacts =mRef.orderByChild("phone").equalTo(phone22);
                reference_contacts.addChildEventListener(new ChildEventListener() {


                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        Post itemprice=dataSnapshot.getValue(Post.class);

                        name =itemprice.getName();
                        phone1=itemprice.getphone();


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


                if(phone22.equals(phone1)) {

                    Bundle bundle = new Bundle();
                    bundle.putString("NAME",name);
                    bundle.putString("PHONE",phone1);

                    Intent gologin = new Intent(login2.this, LOGIN.class);
                    gologin.putExtras(bundle);
                    startActivity(gologin);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


                }

            }
        });



    }
}
