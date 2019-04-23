package com.example.myqq.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myqq.R;
import com.example.myqq.item.baseactivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class chat extends baseactivity {
    private List<chat_picture> list = new ArrayList<>();
    private myadpater myadpater;
    private RecyclerView recyclerView;
    private static final String TAG = "chat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_main);
        chat_picture chat_picture = new chat_picture("床前明月光" +
                "，疑是地上霜。举头望明月，低头思故乡。", R.drawable.d_27, false);
        list.add(chat_picture);
        final EditText editText = findViewById(R.id.chat_main_text);
        Button button = findViewById(R.id.chat_main_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                if(str.equals("下线")){
                    Intent intent=new Intent("com.example.myqq.XIA_XIAN");
                    sendBroadcast(intent);
                }
                if (!str.equals("")) {
                    IntPicture(str);
                    save(str);
                }
                editText.setText("");
            }
        });
        recyclerView = findViewById(R.id.chat_recyclerview);

        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(400);
        animator.setRemoveDuration(400);
        recyclerView.setItemAnimator(animator);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);//初始化聊天记录出现在最底部
        recyclerView.setLayoutManager(layoutManager);
        init();
        myadpater = new myadpater(list);

        recyclerView.setAdapter(myadpater);




    }

    private void IntPicture(String str) {
//
        chat_picture chat_picture = new chat_picture(str, R.drawable.d_27, true);
        list.add(chat_picture);
        //数据刷新
        //  myadpater.notifyItemChanged(list.size() - 1);
        //  myadpater.notifyDataSetChanged();
        myadpater.notifyItemInserted(list.size() - 1);
        //跳转到最后一行
        recyclerView.smoothScrollToPosition(list.size() - 1);

    }
    private void save(String str) {
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try {
            out=openFileOutput("chat_data",MODE_APPEND);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(str+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (writer!=null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private List<String> load(){
        List<String> list2=new ArrayList<>();
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();
        try {
            in=openFileInput("chat_data");
            reader=new BufferedReader(new InputStreamReader(in));
            String str;
            while((str=reader.readLine())!=null){
                list2.add(str);
                Log.w(TAG, "init: 通过"+str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list2;
    }
    private void init(){
        List<String> list3=load();
for(String a:list3){
    chat_picture chat_picture = new chat_picture(a, R.drawable.d_27, true);
    list.add(chat_picture);}
    }
}
