package com.example.chapter04;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
public class ActFinishActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_finish);

        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.btn_finish).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.iv_back||v.getId()==R.id.btn_finish){
            //结束当前活动页面
        finish();

        }

    }
}