package com.sevent.seventapp;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Gizmo on 12/11/2016.
 */
public class Timeline {
    private String title,lokasi,tanggal;
    private int imageView;
    Timeline(){

    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setLokasi(String lokasi){
        this.lokasi = lokasi;
    }
    public String getLokasi(){
        return lokasi;
    }
    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    public String getTanggal(){
        return tanggal;
    }
    public void setImage(int imageView){
        this.imageView = imageView;
    }
    public int getImage(){
        return imageView;
    }
}