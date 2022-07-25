package com.example.yvime.pipi.Informationview;

public class Api {
    public String caption;
    public String media_url;
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


    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }



    public Api(){

    }
    public Api(String caption,String media_url) {
        this.caption=caption;
        this.media_url=media_url;

    }}