package com.example.myqq.chat;

import android.widget.ImageView;
import android.widget.TextView;

public class chat_picture {
    public boolean left_right;
    public int imageView;
    public String textView;
    public chat_picture(String textView,int imageView,boolean left_right){
        this.imageView=imageView;
        this.textView=textView;
        this.left_right=left_right;
    }
    public int getImageView(){
        return imageView;
    }
    public boolean getLeft_right(){
        return left_right;
    }
    public String getTextView(){
        return textView;
    }
}
