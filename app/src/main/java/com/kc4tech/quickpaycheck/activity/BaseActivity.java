package com.kc4tech.quickpaycheck.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.kc4tech.quickpaycheck.R;

/**
 * Created by kaka on 3/20/2017.
 */

public class BaseActivity extends AppCompatActivity {
    protected Button btn_next,btn_back,btn_hourly,btn_salary;

    protected EditText et_pay_period, et_hourly_rate,
            et_regular_hours, et_overtime,
            et_tip_in_check, et_bonus,et_salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_hourly);
        btn_next = (Button) findViewById(R.id.next);
        btn_back = (Button) findViewById(R.id.back);
        btn_hourly = (Button) findViewById(R.id.hourly);
        btn_salary = (Button) findViewById(R.id.salary);
        et_pay_period = (EditText) findViewById(R.id.et_payroll_period);
        et_hourly_rate = (EditText) findViewById(R.id.et_hourly_rate);
        et_regular_hours = (EditText) findViewById(R.id.et_regular_hours);
        et_overtime = (EditText) findViewById(R.id.et_overtime);
        et_tip_in_check = (EditText) findViewById(R.id.et_tip_in_check);
        et_bonus = (EditText) findViewById(R.id.et_bonus);
        et_salary = (EditText)findViewById(R.id.annualSalary);
    }
}
