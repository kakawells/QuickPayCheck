package com.kc4tech.quickpaycheck.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;


import com.kc4tech.quickpaycheck.Calculation.Calculate1099;
import com.kc4tech.quickpaycheck.R;
import com.kc4tech.quickpaycheck.constants.Constants;
import com.kc4tech.quickpaycheck.validation.BaseValidate;
import com.kc4tech.quickpaycheck.vo.Contractor1099;
import com.kc4tech.quickpaycheck.vo.Type;
import com.kc4tech.quickpaycheck.vo.Result;

import java.util.HashMap;
import java.util.Map;

public class BaseSalaryActivity extends AppCompatActivity {

    private final String TAB = "CONTRACTOR_1099_SALARY";
    private  EditText et_salary,et_pay_period;
    private  Button  btn_next, btn_hourly,btn_back;
    private BaseValidate baseValidate;
    private Map<String, String> contractor1099Map = new HashMap<>();
    private Calculate1099 calculate1099;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_salary);

        btn_next = (Button) findViewById(R.id.next);
        btn_hourly = (Button) findViewById(R.id.hourly);
        et_salary = (EditText) findViewById(R.id.annualSalary);
        et_pay_period = (EditText) findViewById(R.id.et_payroll_period);
        btn_back = (Button) findViewById(R.id.back);
        final Intent intent = new Intent();
        btn_next.setOnClickListener((View v) -> {
                baseValidate = new BaseValidate();
                calculate1099 = new Calculate1099();
                String payPeriod = et_pay_period.getText().toString().trim();
                String salaryText = et_salary.getText().toString().trim();
                String errorMessage = baseValidate.validateFieldsForSalary(contractor1099Map,payPeriod,salaryText);
                if(TextUtils.isEmpty(errorMessage)){
                    double salary = Double.parseDouble(salaryText);
                    Contractor1099 contractor1099 = new Contractor1099(payPeriod, salary, Type.SALARY);
                    double netPaycheck = calculate1099.calculate1099NetPayCheckBySalary(payPeriod,salary);
                    Log.i(TAB, "salary netPaycheck :" + netPaycheck);
                    Result contract1099Result = new Result(contractor1099,netPaycheck);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("contract1099Result", contract1099Result);
                    intent.setClass(BaseSalaryActivity.this, Contractor1099SalaryResultActivity.class);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, Constants.Contractor1099_REQUEST_DATA_CODE);
                }else{
                    Toast.makeText(BaseSalaryActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                }
        });

        btn_hourly.setOnClickListener((View v) -> {
            intent.setClass(BaseSalaryActivity.this, Contractor1099Activity.class);
            startActivity(intent);
        });

        btn_back.setOnClickListener((View v) ->{
            intent.setClass(BaseSalaryActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.Contractor1099_REQUEST_DATA_CODE && resultCode == RESULT_OK) {
            et_pay_period.setText(contractor1099Map.get("payroll_period"));
            et_salary.setText(contractor1099Map.get("salary"));
        }
    }
}
