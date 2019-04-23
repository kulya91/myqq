package com.example.myqq.item;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.View;

import com.example.myqq.MainActivity;

import java.lang.reflect.Field;


public class baseactivity extends AppCompatActivity {
    private XiaXianReceiver xiaxian;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitycollector.addactivity(this);
    }
    /**********************在onresume和onpause中注册和取消注册广播接收器*************************/
    /*********************因为仅需要处在栈顶的活动接收的广播，不在栈顶的活动则取消注册**************************/
    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.myqq.XIA_XIAN");
        xiaxian=new XiaXianReceiver();
        registerReceiver(xiaxian,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (xiaxian!=null){
            unregisterReceiver(xiaxian);
            xiaxian=null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activitycollector.removeactivity(this);
    }

    class XiaXianReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, final Intent intent) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setMessage("您已被强制下线!");
            dialog.setCancelable(false);
            dialog.setPositiveButton("重新登陆", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    activitycollector.finishall();
                    Intent intent1 = new Intent(context, MainActivity.class);
                    context.startActivity(intent1);
                }
            });
            dialog.show();

        }
    }
}
