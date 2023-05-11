package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter03.utils.DateUtil;
/*
* 监听器，意思是专门监听控件的动作行为。只有控件发生了指定的动作，监听器才会触发开关去执行对应的代码逻辑
*
*按钮控件有两种常用的监听器
*
* 点击监听器：通过setOnClickListener方法设置，按钮被按住少于500毫秒时，会触发点击时间。
*
* 长按监听器:通过设置setOnLongClickListener方法设置，按钮被按住超过500毫秒时，会触发长按事件
*
* */
public class ButtonClickActivity extends AppCompatActivity implements View.OnClickListener {
//公共按钮，ButtonClickActivity实现View.OnClickListener接口，重写onClick方法
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);
        tv_result = findViewById(R.id.tv_result);
      Button  btn_click_single=findViewById(R.id.btn_click_single);
    btn_click_single.setOnClickListener(new MyOnClickListener(tv_result));
//公共按钮设置监听
          Button btn_click_public=findViewById(R.id.btn_click_public);
          btn_click_public.setOnClickListener(this);

    }
//公共按钮的重写方法
    @Override
    public void onClick(View v) {
       if (v.getId()==R.id.btn_click_public){
           String desc=String.format("%s 您点击了按钮： %s", DateUtil.getNowTime(),((Button) v).getText());
           tv_result.setText(desc);


       }

    }

    static class MyOnClickListener implements  View.OnClickListener{


        private final TextView tv_result;

        public MyOnClickListener(TextView tv_result) {
          this.tv_result=tv_result;
      }

      @Override
        public void onClick(View v) {
            String desc=String.format("%s 您点击了按钮： %s", DateUtil.getNowTime(),((Button) v).getText());
            tv_result.setText(desc);
        }
    }
}