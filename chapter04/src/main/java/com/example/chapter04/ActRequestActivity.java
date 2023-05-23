package com.example.chapter04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter04.utils.DateUtil;

public class ActRequestActivity extends AppCompatActivity implements View.OnClickListener {
    private String mRequest = "你睡了吗？";
    private ActivityResultLauncher<Intent> register;
    private TextView tv_response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_request);

        TextView tv_request = findViewById(R.id.tv_request);
        tv_request.setText("待发送的消息：" + mRequest);
        tv_response = findViewById(R.id.tv_response);
        findViewById(R.id.btn_request).setOnClickListener(this);

        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result != null) {
                            Intent intent = result.getData();
                            if (intent != null && result.getResultCode() == Activity.RESULT_OK) {
                                Bundle bundle = intent.getExtras();
                                String response_time = bundle.getString("response_time");
                                String response_content = bundle.getString("response_content");
                                String desc = String.format("收到返回消息：\n应答时间为%s\n应答内容为%s", response_time, response_content);
                                //将返回的消息信息显示在文本视图上
                                tv_response.setText(desc);
                            }

                        }

                    }
                });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActResponseActivity.class);
        //创建一个新包裹
        //创建一个新包裹
        Bundle bundle = new Bundle();
        bundle.putString("request_time", DateUtil.getNowTime());
        bundle.putString("request_content", mRequest);
        intent.putExtras(bundle);
        register.launch(intent);


    }
}