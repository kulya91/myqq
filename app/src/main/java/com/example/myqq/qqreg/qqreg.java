package com.example.myqq.qqreg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myqq.R;
import com.example.myqq.item.baseactivity;

public class qqreg extends baseactivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qqreg_main);
        Log.e("qqreg", getTheme().toString());
    }
}
