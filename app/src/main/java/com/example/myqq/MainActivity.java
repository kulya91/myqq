package com.example.myqq;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myqq.chat.chat;
import com.example.myqq.item.baseactivity;
import com.example.myqq.qqreg.qqreg;

public class MainActivity extends baseactivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        ActionBar actionBar = getSupportActionBar();
        Button button = findViewById(R.id.login_button);
        TextView textView = findViewById(R.id.login_tips2);
        final EditText id = findViewById(R.id.login_id);
        final EditText key = findViewById(R.id.login_key);
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        id.setText(pref.getString("id",""));
        key.setText(pref.getString("key",""));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"666",Toast.LENGTH_SHORT).show();
                Log.w(TAG, "onClick: "+view.getContext().toString() );
                String str_id = id.getText().toString();
                String str_key = key.getText().toString();
                if (str_id.equals("hwj") && str_key.equals("123")) {
                    Intent intent = new Intent(MainActivity.this, chat.class);
                    startActivity(intent);
                    SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putString("id",str_id);
                    editor.putString("key",str_key);
                    editor.apply();
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this,"密码错误！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, qqreg.class);
                startActivity(intent);
                Log.w(TAG, "onClick: " +MainActivity.this.toString()+"哈"+qqreg.class.toString());
            }
        });
    }
}
