package com.example.yvime.pipi.shoppingcartview;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yvime.pipi.DividerItemDecoration;
import com.example.yvime.pipi.Informationview.Qrcode;
import com.example.yvime.pipi.MainActivity;
import com.example.yvime.pipi.Model;
import com.example.yvime.pipi.R;
import com.example.yvime.pipi.SelectPage;
import com.example.yvime.pipi.Top.Top;
import com.example.yvime.pipi.ViewHolder;
import com.example.yvime.pipi.offline_access;
import com.example.yvime.pipi.shoppingcartview.swipe_adapter.RecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Shoppingcart extends AppCompatActivity  {
    DatabaseReference mRef;
    DatabaseReference mRef2;
    private String imgurl;
    private String productprice;
    private String productname;
    FirebaseDatabase mFirebaseDatabase;
    RecyclerView mRecyclerView1;
    private RecyclerAdapter adapter;
    private List<String> list = new ArrayList<>();
int all[] = new int[20];
    int c=0;
    int i=0;

    EditText txtTagContent;
    private DatabaseReference mDatabase;
    private DatabaseReference mm;
    private NfcAdapter nfcAdapter;
    private TextView money;
    private String tagContent;
    private Button dis;
    private Tag tag;
    private  String thing;
    private String num;
    private Parcelable[] parcelables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shoppingcart);

        ImageButton bt1 = findViewById(R.id.imageButton1);
        ImageButton bt2 = findViewById(R.id.imageButton2);
        ImageButton bt3 = findViewById(R.id.imageButton3);
        ImageButton bt = findViewById(R.id.buy222);
        ImageButton buy2 = findViewById(R.id.buy);
        Button buy = findViewById(R.id.button4);
        mRecyclerView1 = findViewById(R.id.okbuy);
        dis = findViewById(R.id.dis);




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView1.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter<String>(list, this);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRecyclerView1.setLayoutManager(new GridLayoutManager(Shoppingcart.this, 1));
        //mRecyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView1.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView1.setHasFixedSize(true);
        mRecyclerView1.setAdapter(adapter);
        mRef = mFirebaseDatabase.getReference("shoppingcart");

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        money = findViewById(R.id.sum);

        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                Toast.makeText(Shoppingcart.this, "onItemClick-->>>" + list.get(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                Toast.makeText(Shoppingcart.this, "onItemLongClick-->>>" + list.get(position), Toast.LENGTH_LONG).show();
                return true;//!!!!!!!!!!!!
            }

            @Override
            public void delView(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                position =holder.getAdapterPosition();

                mRef2 = mFirebaseDatabase.getReference("shoppingcart");


                list.remove(position);
                adapter.remove(position);
               adapter.notifyDataSetChanged();
            }

        });  ImageButton bt5=findViewById(R.id.line);
    bt5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent gologin = new Intent(Shoppingcart.this,SelectPage.class);
            startActivity(gologin);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        }
    });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Shoppingcart.this,offline_access.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Shoppingcart.this, Top.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Shoppingcart.this, Qrcode.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        buy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Shoppingcart.this,MainActivity.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Shoppingcart.this,Shoppingcart.class);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("SUMPRICE",c);
                Intent gologin = new Intent(Shoppingcart.this, pay.class);
                gologin.putExtras(bundle);
                startActivity(gologin);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });


        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                              Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                //NdefMessage ndefMessage = createNdefMessage(txtTagContent.getText()+"");
                readTextFromMessage((NdefMessage) parcelables[0]);
                if(!thing.equals(null)){
                mDatabase.child("shoppingcart").push().setValue(new Post(productname,productprice,num,imgurl));
                    thing=null;}

                NdefMessage ndefMessage = createNdefMessage("000");

               writeNdefMessage(tag, ndefMessage);
            }
        });

    }


    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Post, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Post, ViewHolder>(
                        Post.class,
                        R.layout.row3,
                        ViewHolder.class,
                        mRef
                ) {


                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Post post, int position) {



    int s =viewHolder.setShopping(getApplicationContext(), post.getSpcproduct(), post.getSpcprice(), post.getSpcquantity(),post.getimgurl());
    all[i]=s;
    c+=all[i];
i++;
                        TextView sump= findViewById(R.id.sumprice);

                        Intent intent = new Intent();
                        sump.setText( String.valueOf("$"+c) );

                    }


                };

        mRecyclerView1.setAdapter(firebaseRecyclerAdapter);
    }

    protected void onResume() {
        super.onResume();

        enableForegroundDispatchSystem();
    }
    @Override
    protected void onPause() {
        super.onPause();

        disableForegroundDispatchSystem();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent.hasExtra(NfcAdapter.EXTRA_TAG)) {
            Toast.makeText(this, "NfcIntent!", Toast.LENGTH_SHORT).show();

            //    if(tglReadWrite.isChecked())
            //    {
            parcelables = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            readTextFromMessage((NdefMessage) parcelables[0]);
            if(parcelables != null && parcelables.length > 0)
            {
                //readTextFromMessage((NdefMessage) parcelables[0]);
                tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                //NdefMessage ndefMessage = createNdefMessage(txtTagContent.getText()+"");
                //NdefMessage ndefMessage = createNdefMessage("002");

                //writeNdefMessage(tag, ndefMessage);
            }else{
                Toast.makeText(this, "No NDEF messages found!", Toast.LENGTH_SHORT).show();
            }

        }
//            else{
//                Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
//                NdefMessage ndefMessage = createNdefMessage(txtTagContent.getText()+"");
//
//                writeNdefMessage(tag, ndefMessage);
//            }

    }
    //  }
    private void readTextFromMessage(NdefMessage ndefMessage) {

        NdefRecord[] ndefRecords = ndefMessage.getRecords();

        if(ndefRecords != null && ndefRecords.length>0){

            NdefRecord ndefRecord = ndefRecords[0];

            tagContent = getTextFromNdefRecord(ndefRecord);
            thing=tagContent;
            mDatabase=FirebaseDatabase.getInstance().getReference();
            mm = FirebaseDatabase.getInstance().getReference("itemlist");
            Query reference_contacts =mm.orderByChild("id").equalTo(thing);
            reference_contacts.addChildEventListener(new ChildEventListener() {


                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Model itemprice=dataSnapshot.getValue(Model.class);
                    imgurl=itemprice.getImage();
                    productprice=itemprice.getPrice();
                    productname=itemprice.getName();
                    num="1";


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
            // tvtvtv.setText(tagContent);


        }else
        {
            Toast.makeText(this, "No NDEF records found!", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void enableForegroundDispatchSystem() {

        Intent intent = new Intent(this, Shoppingcart.class).addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        IntentFilter[] intentFilters = new IntentFilter[]{};

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilters, null);
    }

    private void disableForegroundDispatchSystem() {
        nfcAdapter.disableForegroundDispatch(this);
    }

    private void formatTag(Tag tag, NdefMessage ndefMessage) {
        try {

            NdefFormatable ndefFormatable = NdefFormatable.get(tag);

            if (ndefFormatable == null) {
                Toast.makeText(this, "Tag is not ndef formatable!", Toast.LENGTH_SHORT).show();
                return;
            }


            ndefFormatable.connect();
            ndefFormatable.format(ndefMessage);
            ndefFormatable.close();

            Toast.makeText(this, "Tag writen!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e("formatTag", e.getMessage());
        }

    }

    private void writeNdefMessage(Tag tag, NdefMessage ndefMessage) {

        try {

            if (tag == null) {
                Toast.makeText(this, "Tag object cannot be null", Toast.LENGTH_SHORT).show();
                return;
            }

            Ndef ndef = Ndef.get(tag);

            if (ndef == null) {
                // format tag with the ndef format and writes the message.
                formatTag(tag, ndefMessage);
            } else {
                ndef.connect();

                if (!ndef.isWritable()) {
                    Toast.makeText(this, "Tag is not writable!", Toast.LENGTH_SHORT).show();

                    ndef.close();
                    return;
                }

                ndef.writeNdefMessage(ndefMessage);
                ndef.close();

                Toast.makeText(this, "Tag writen!", Toast.LENGTH_SHORT).show();

            }

        } catch (Exception e) {
            Log.e("writeNdefMessage", e.getMessage());
        }

    }


    private NdefRecord createTextRecord(String content) {
        try {
            byte[] language;
            language = Locale.getDefault().getLanguage().getBytes("UTF-8");

            final byte[] text = content.getBytes("UTF-8");
            final int languageSize = language.length;
            final int textLength = text.length;
            final ByteArrayOutputStream payload = new ByteArrayOutputStream(1 + languageSize + textLength);

            payload.write((byte) (languageSize & 0x1F));
            payload.write(language, 0, languageSize);
            payload.write(text, 0, textLength);

            return new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, new byte[0], payload.toByteArray());

        } catch (UnsupportedEncodingException e) {
            Log.e("createTextRecord", e.getMessage());
        }
        return null;
    }


    private NdefMessage createNdefMessage(String content) {

        NdefRecord ndefRecord = createTextRecord(content);

        NdefMessage ndefMessage = new NdefMessage(new NdefRecord[]{ndefRecord});

        return ndefMessage;
    }


    public void tglReadWriteOnClick(View view){
        txtTagContent.setText("");
    }


    public String getTextFromNdefRecord(NdefRecord ndefRecord)
    {
        String tagContent = null;
        try {
            byte[] payload = ndefRecord.getPayload();
            String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";
            int languageSize = payload[0] & 0063;
            tagContent = new String(payload, languageSize + 1,
                    payload.length - languageSize - 1, textEncoding);
        } catch (UnsupportedEncodingException e) {
            Log.e("getTextFromNdefRecord", e.getMessage(), e);
        }
        return tagContent;
    }
}