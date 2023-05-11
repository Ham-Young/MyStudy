package com.example.chapter03.utils;

import android.content.Context;

public class Utils {
    //px=dip*dpi/160,dip即dp(设备独立像素，跟设备密度有关)，dpi像素密度（指屏幕上每英寸距离中有多少像素点）
    //dp:显示到屏幕上的头像都是以px为单位，dp是我们开发中使用的长度单位，最后需要转化成px，计算这个设备上1dp等于多少px
    public static int dptopx(Context context, float dpValue) {

        //获取当前手机的像素密度（1个dp对应几个px）

        float scale=context.getResources().getDisplayMetrics().density;

        return (int)(dpValue*scale+0.5f);


    }
}
