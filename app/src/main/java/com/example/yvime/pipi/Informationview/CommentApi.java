package com.example.yvime.pipi.Informationview;

public class CommentApi {
    public String text;
    public String username;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public CommentApi(){

    }
    public CommentApi(String text,String username){
        this.text=text;
        this.username=username;
    }
}
