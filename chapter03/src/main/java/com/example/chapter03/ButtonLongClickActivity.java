package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter03.utils.DateUtil;

public class ButtonLongClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_long_click);

      TextView tv_result = findViewById(R.id.tv_result);
        Button btn_long_click=findViewById(R.id.btn_long_click);
        btn_long_click.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String desc=String.format("%s 您点击了按钮： %s", DateUtil.getNowTime(),((Button) v).getText());
                tv_result.setText(desc);
                return true;
            }
        });


    }
}