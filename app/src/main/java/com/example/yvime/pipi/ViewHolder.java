package com.example.yvime.pipi;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {
    View mView;
   public int all=0;
    int sum =0;
    public TextView mname;
    public ViewHolder(View itemView) {
        super(itemView);

        mView=itemView;
    }
    //set details to recycler view
    public void setDetails(Context ctx, String name, String img,String price){
        TextView mProduct=mView.findViewById(R.id.rproduct);
        ImageView mImg=mView.findViewById(R.id.rimgview);
        TextView mprice=mView.findViewById(R.id.rprice);

        //ser data to views
        mProduct.setText(name);
        Picasso.get().load(img).into(mImg);
       mprice.setText("$"+price);

    }


    public void setPreorder(Context ctx, String img,String price,String name){
        ImageView mImg=mView.findViewById(R.id.rimgview);

        //ser data to views
        Picasso.get().load(img).into(mImg);


    }
    public int setShopping(Context ctx,  String spcproduct, String spcprice, String spcquantity, String img ){
        ImageView img4 = mView.findViewById(R.id.img);
        TextView np=mView.findViewById(R.id.np);
        TextView mname=mView.findViewById(R.id.nitem);
        TextView mcp=mView.findViewById(R.id.num);
        TextView mprice=mView.findViewById(R.id.pri);


int a , b =0;


        a=Integer.parseInt(spcprice);
        b=Integer.parseInt(spcquantity);
        sum=a*b;
        np.setText(spcquantity);
        mname.setText(spcproduct);
        mcp.setText("$"+spcprice);
       mprice.setText("$"+sum);
        Picasso.get().load(img).into(img4);
all+=sum;

return all;
    }


    public void setonlineShopping2(Context ctx,  String name,String price, String img ){
        ImageView img4 = mView.findViewById(R.id.img4);

        TextView mname=mView.findViewById(R.id.nitem4);

        TextView mprice=mView.findViewById(R.id.pri4);



        mname.setText(name);
        mprice.setText("$"+price);
        Picasso.get().load(img).into(img4);

    }
    public int setShopping123(Context ctx, String add, String del, String name, String phone ){

        TextView add1=mView.findViewById(R.id.address);
        TextView del1=mView.findViewById(R.id.del);
        TextView name1=mView.findViewById(R.id.name);
        TextView phone1=mView.findViewById(R.id.phone);

        name1.setText(name);
        add1.setText(add);
        del1.setText(del);
        phone1.setText(phone);


        return 0;
    }

}
