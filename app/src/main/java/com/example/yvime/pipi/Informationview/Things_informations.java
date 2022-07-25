package com.example.yvime.pipi.Informationview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Things_informations extends AppCompatActivity {

    private TextView commentTextViewResult;
    private TextView captionTextViewResult;
    private RequestQueue cmtQueue;
    private String imgurl= "https://firebasestorage.googleapis.com/v0/b/itemlist-f47ab.appspot.com/o/banana.jpg?alt=media&token=d9a2ee40-9e1c-4ea7-bdfc-a35f7adee773";
    private String productprice;
    private String productname;
  //  private Long abc;
    private String productquality;
    private DatabaseReference mDatabase;
    private DatabaseReference mm;
    private int ii=0;
    private String caption;
    private String media_url;
    private String text;
    private String username;
    private int  i=0,sum=0;

    private Intent inin;








    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_informations);
        Bundle BUNDLE =this.getIntent().getExtras();
        final String log = BUNDLE.getString("log");
        final String name = BUNDLE.getString("NAME");
        final String phone1 = BUNDLE.getString("lPHONE");
       final String THINGNAME = BUNDLE.getString("THINGNAME");
       //  abc=Long.parseLong(THINGNAME);


        final TextView th = findViewById(R.id.thingsname);

        captionTextViewResult=findViewById(R.id.caption);
        commentTextViewResult = findViewById(R.id.comment);
        commentTextViewResult.setMovementMethod(new ScrollingMovementMethod());
        captionTextViewResult.setMovementMethod(new ScrollingMovementMethod());
        cmtQueue = Volley.newRequestQueue(this);
        jsonParse();
       mDatabase=FirebaseDatabase.getInstance().getReference();
         mm = FirebaseDatabase.getInstance().getReference("itemlist");

        final TextView price =(TextView)findViewById(R.id.itemprice);
        final ImageView imageView=findViewById(R.id.thingimageView);

        inin = getIntent();



        Query reference_contacts =mm.orderByChild("id").equalTo(THINGNAME);
        reference_contacts.addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Model itemprice=dataSnapshot.getValue(Model.class);
                imgurl=itemprice.getImage();
                productprice=itemprice.getPrice();
                productname=itemprice.getName();
                price.setText(itemprice.getPrice());
                th.setText(itemprice.getName());
                Picasso.get().load(itemprice.getImage()).into(imageView);


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


        ii=ii+3;
        ImageButton bt1=findViewById(R.id.imageButton1);
        ImageButton bt2=findViewById(R.id.imageButton2);
        ImageButton bt3=findViewById(R.id.imageButton3);

        Button vote = findViewById(R.id.vote);
        ImageButton buy = findViewById(R.id.buy);

        ImageButton bt5=findViewById(R.id.line);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gologin = new Intent(    Things_informations.this,SelectPage.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Things_informations.this,Top.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Things_informations.this,Qrcode.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Things_informations.this,Shoppingcart.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Things_informations.this,MainActivity.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("THINGNAME",THINGNAME);
                Intent gologin = new Intent(Things_informations.this,Vote.class);
                gologin.putExtras(bundle);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
//        PUT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                BUY();
//            }
//        });





    }
    private void jsonParse(){
        String url="https://graph.facebook.com/v2.10/17841408166242504/media?fields=media_type,owner,caption,media_url,comments{username,text}&access_token=EAAEByTKXlC0BALruGj7wE1eiUiMuexShhoNBWyandX3qUMlP3jWCei5F0bJYu9Gi0fiZCZCVW4a8zgk7bRafcXVO8nAQOdHJA96fBnUkSuTBfcOm8gForOvkZADl2s3Ao2QmGGatIZAQg6KdL26u3haTs7ZAcedv1CTQ85e3xZBDK68upSxAhhOfzZBqy9bUWMZD";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray abc =response.getJSONArray("data");
                            for (int i = 0; i < abc.length(); i++) {
                                JSONObject jsonObject1 = abc.getJSONObject(i);
                                caption =jsonObject1.getString("caption");
                                media_url =jsonObject1.getString("media_url");
                                mDatabase.child("instagram").child(String.valueOf(i)).setValue(new Api(caption,media_url));
                                JSONObject data = jsonObject1.getJSONObject("comments");
                                JSONArray commentarray =data.getJSONArray("data");
                                for (int j = 0; j < commentarray.length(); j++){
                                    JSONObject jsonObject2 = commentarray.getJSONObject(j);
                                    text =jsonObject2.getString("text");
                                    username =jsonObject2.getString("username");
                                    mDatabase.child("instagram").child(String.valueOf(i)).child("comments").child(String.valueOf(j)).setValue(new CommentApi(text,username));
                                    if( caption.contains( ""+productname+"" )== true){
                                        captionTextViewResult.append(caption + "\n\n");
                                        commentTextViewResult.append(username+" : " +text + "\n\n");
                                    }

                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        cmtQueue.add(request);
    }
  //
//    private void BUY() {
//
//
//            final EditText et = new EditText(this);
//
//            et.setText("1");
//            et.setInputType(InputType.TYPE_CLASS_NUMBER);
//
//
//
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//             productquality=et.getText().toString();
//
//            builder.setMessage("選擇數量")
//                   .setTitle("   (商品:"+productname+"   單價:  "+productprice+")")
//                    .setView(et)
//
//
//
//
//                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            productquality=et.getText().toString();
//                            mDatabase.child("shoppingcart").push().setValue(new Post(productname,productprice,productquality,imgurl));
//
//
////                            Intent gologin = new Intent(Things_informations.this,Shoppingcart.class);
////                            startActivity(gologin);
////                            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//                        }
//                    })
//                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            // 右方按鈕方法
//                            // myview.setText("點擊右邊按鈕");
//                        }
//                    });
//            AlertDialog about_dialog = builder.create();
//
//
//
//            about_dialog.show();
//
//
//        }
}