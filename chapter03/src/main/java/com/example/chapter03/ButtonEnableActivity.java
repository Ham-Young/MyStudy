package com.example.chapter03;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.utils.DateUtil;

public class ButtonEnableActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_test;
    private TextView tv_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);

        Button btn_enable = findViewById(R.id.btn_enable);
        Button btn_disable = findViewById(R.id.btn_disable);
        btn_test = findViewById(R.id.btn_test);//鼠标选中此变量，Ctrl+Alt+F，可将此变量设置为全局变量
        tv_result = findViewById(R.id.tv_result);

        btn_enable.setOnClickListener(this);
        btn_disable.setOnClickListener(this);
        btn_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_enable:
                //启用当前控件
                btn_test.setEnabled(true);
                //设置按钮的文字颜色
                btn_test.setTextColor(Color.BLACK);
               break;

            case R.id.btn_disable:
                //禁用当前控件
                btn_test.setEnabled(false);
                //设置按钮的文字颜色
                btn_test.setTextColor(Color.GRAY);
                break;
            case R.id.btn_test:
                String desc=String.format("%s 您点击了按钮： %s", DateUtil.getNowTime(),((Button) v).getText());
                tv_result.setText(desc);
                break;


        }


    }
}