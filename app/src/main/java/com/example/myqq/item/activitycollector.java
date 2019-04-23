package com.example.myqq.item;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class activitycollector {
    public static List<Activity> activityList=new ArrayList<>();
    public static void addactivity(Activity activity){
        activityList.add(activity);
    }
    public static void removeactivity(Activity activity){
        activityList.remove(activity);
    }
    public static void finishall() {
    for(Activity a:activityList){
        removeactivity(a);
    }
    activityList.clear();
    }
}
