package com.example.yvime.pipi;
public class Model {
    private  String id,image,name,price,img ;

    public Model(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price; }

    public void setPrice(String price) {
        this.price = price;
    }

    public Model(String image,String name,String price){
        this.name = name;
        this.price = price;
        this.image=image;

    }

    public Model(String price){

        this.price = price;

    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    private  String add,del,phone ,log;

    public String getadd() {
        return add;
    }

    public void setadd(String add) {
        this.add = add;
    }

    public String getdel() {
        return del;
    }

    public void setdel(String del) {
        this.del = del;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getlog() {
        return log;
    }

    public void setplog(String log ){  this.log = log;   }






}
