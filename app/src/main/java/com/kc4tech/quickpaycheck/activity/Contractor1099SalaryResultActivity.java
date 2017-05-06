package com.kc4tech.quickpaycheck.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kc4tech.quickpaycheck.R;
import com.kc4tech.quickpaycheck.constants.Constants;
import com.kc4tech.quickpaycheck.vo.Result;

public class Contractor1099SalaryResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor1099_salarly_result);
        TextView tv_payroll_period = (TextView)findViewById(R.id.tv_payroll_period_result);
        TextView tv_net_paycheck=(TextView) findViewById(R.id.tv_net_paycheck_result);
        Button btn_salary_startOver = (Button) findViewById(R.id.salary_startOver);
        Button btn_back = (Button) findViewById(R.id.btn_back);

        Bundle bundle = this.getIntent().getExtras();
        Result contract1099Result = (Result)bundle.get("contract1099Result");
        tv_payroll_period.setText(String.valueOf(contract1099Result.getContractor1099().getPayrollPeriod()));
        tv_net_paycheck.setText(Constants.DOLLAR_SIGN +
                String.valueOf(String.format("%.2f",contract1099Result.getNetPaycheck())));
        btn_salary_startOver.setOnClickListener((View v) ->{
            Intent intent = new Intent();
            intent.setClass(Contractor1099SalaryResultActivity.this, MainActivity.class);
            startActivity(intent);
        });

        btn_back.setOnClickListener((View v) ->{
            Intent intent = new Intent();
            intent.setClass(Contractor1099SalaryResultActivity.this, BaseSalaryActivity.class);
            Contractor1099SalaryResultActivity.this.setResult(RESULT_OK, intent);
            Contractor1099SalaryResultActivity.this.finish();
        });
    }
}
