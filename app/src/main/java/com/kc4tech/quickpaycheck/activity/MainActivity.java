package com.kc4tech.quickpaycheck.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kc4tech.quickpaycheck.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_contractor1099 = (Button) findViewById(R.id.contractor1099);
        Button bt_w2_employee = (Button) findViewById(R.id.w2_employee);
        bt_contractor1099.setOnClickListener(new PayTypeListener());
        bt_w2_employee.setOnClickListener(new PayTypeListener());
    }

    private class PayTypeListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
          Intent intent = null;
          if(v.getId() == R.id.contractor1099){
             intent = new Intent(MainActivity.this, Contractor1099Activity.class);
          }else if(v.getId() == R.id.w2_employee){
             intent = new Intent(MainActivity.this,W2Activity.class );
          }
          startActivity(intent);
        }
    }

}
