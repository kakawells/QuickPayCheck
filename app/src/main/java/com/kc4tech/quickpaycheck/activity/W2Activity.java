package com.kc4tech.quickpaycheck.activity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class W2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn_next.setOnClickListener((View v) -> {
            Intent intent = new Intent();
            intent.setClass(W2Activity.this, WithHoldingActivity.class);
            startActivity(intent);
        });




    }
}
