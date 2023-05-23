package com.example.chapter04;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActReceiveActivity extends AppCompatActivity {

    private TextView tv_recevie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_receive);

        tv_recevie = findViewById(R.id.tv_receive);
        //从上一个页面传来的意图中获取包裹

        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request_time");
        String request_content = bundle.getString("request_content");
        String desc = String.format("收到请求消息：\n请求时间为%s\n请求内容为%s", request_time, request_content);
        tv_recevie.setText(desc);


    }
}