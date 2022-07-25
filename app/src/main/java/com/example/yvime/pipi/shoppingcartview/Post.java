package com.example.yvime.pipi.shoppingcartview;

public class Post {
    public String spcproduct;
    public String spcprice;
    public String imgurl;
    public String spcquantity;
    public String log;
    public String name;
    public String phone;
    public String getimgurl() {
        return imgurl;
    }

    public void setimgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getSpcproduct() {
        return spcproduct;
    }

    public void setSpcproduct(String spcproduct) {
        this.spcproduct = spcproduct;
    }

    public String getSpcprice() {
        return spcprice;
    }

    public void setSpcprice(String spcprice) {
        this.spcprice = spcprice;
    }

    public String getSpcquantity() {
        return spcquantity;
    }

    public void setSpcquantity(String spcquantity) {
        this.spcquantity = spcquantity;
    }



    public Post(){

    }
    public Post(String spcproduct, String spcprice,String spcquantity,String imgurl) {
        this.spcproduct=spcproduct;
        this.spcprice=spcprice;
        this.spcquantity=spcquantity;
        this.imgurl=imgurl;
    }


    public String getlog() {
        return log;
    }

    public void setplog(String log ){  this.log = log;   }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Post(String phone,String log,String name){

        this.name = name;
        this.phone = phone;
        this.log = log;
    }

}