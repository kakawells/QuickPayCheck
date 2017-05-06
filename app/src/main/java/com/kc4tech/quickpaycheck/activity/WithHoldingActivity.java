package com.kc4tech.quickpaycheck.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kc4tech.quickpaycheck.R;

import static com.kc4tech.quickpaycheck.R.id.btn_back;

public class WithHoldingActivity extends AppCompatActivity {

    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_holding);
        btn_back = (Button) findViewById(R.id.back);
        btn_back.setOnClickListener((View v) -> {
            Intent intent = new Intent();
            intent.setClass(WithHoldingActivity.this, W2Activity.class);
            startActivity(intent);
        });
    }

}
