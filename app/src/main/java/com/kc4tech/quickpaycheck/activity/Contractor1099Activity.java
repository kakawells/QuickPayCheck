package com.kc4tech.quickpaycheck.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kc4tech.quickpaycheck.Calculation.Calculate1099;
import com.kc4tech.quickpaycheck.constants.Constants;
import com.kc4tech.quickpaycheck.validation.BaseValidate;
import com.kc4tech.quickpaycheck.vo.Contractor1099;
import com.kc4tech.quickpaycheck.vo.Result;
import com.kc4tech.quickpaycheck.vo.Type;

import java.util.HashMap;
import java.util.Map;

public class Contractor1099Activity extends BaseActivity{

    private final String TAB = "CONTRACTOR_1099";
    private Calculate1099 calculate1099;
    private String optionType;
    private BaseValidate baseValidate;
    private Map<String, String> contractor1099Map =  new HashMap<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = new Intent() ;
        btn_next.setOnClickListener((View v) ->{
            baseValidate = new BaseValidate();
            String payPeriod = et_pay_period.getText().toString().trim();
            calculate1099 = new Calculate1099();
            Bundle bundle = new Bundle();
            if(TextUtils.isEmpty(optionType)){
                optionType = Type.HOURLY.toString();
            }
            String hourRateText = et_hourly_rate.getText().toString().trim();
            String regularHoursText = et_regular_hours.getText().toString().trim();
            String overtimeText = et_overtime.getText().toString().trim();
            String tipInCheckText = et_tip_in_check.getText().toString().trim();
            String bonusText = et_bonus.getText().toString().trim();
            String errorMessage = baseValidate.validateFields(contractor1099Map, payPeriod, hourRateText,
                    regularHoursText, overtimeText, tipInCheckText, bonusText);
            if (TextUtils.isEmpty(errorMessage)) {
                double hourRate = Double.parseDouble(hourRateText);
                float regularHours = Float.parseFloat(regularHoursText);
                double tips = Double.parseDouble(tipInCheckText);
                float overtimes = Float.parseFloat(overtimeText);
                double bonus = Double.parseDouble(bonusText);
                Log.i(TAB, payPeriod + "," + hourRate + "," + regularHours + "," + overtimes + "," + bonus + "," + tips);
                double regularHoursPay = calculate1099.calRegularHoursPay(hourRate, regularHours);
                double overtimePay = calculate1099.calOvertimesPay(hourRate, overtimes);
                double netPaycheck = calculate1099.calculate1099NetPayCheckByHourly(hourRate, regularHours, overtimes, bonus, tips);
                Contractor1099 contractor1099 = new Contractor1099(payPeriod, hourRate, regularHours, overtimes, tips, bonus, Type.HOURLY);
                Result contract1099Result = new Result(contractor1099, regularHoursPay, overtimePay, netPaycheck);
                bundle.putSerializable("contract1099Result", contract1099Result);
                intent.setClass(Contractor1099Activity.this, Contractor1099HourlyResultActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, Constants.Contractor1099_REQUEST_DATA_CODE);
            } else {
                Toast.makeText(Contractor1099Activity.this, errorMessage, Toast.LENGTH_LONG).show();
            }
        });

        btn_back.setOnClickListener((View v) ->{
            intent.setClass(Contractor1099Activity.this, MainActivity.class);
            startActivity(intent);
        });
        btn_salary.setOnClickListener((View v) ->{
            optionType = Type.SALARY.toString();
            intent.setClass(Contractor1099Activity.this, BaseSalaryActivity.class);
            startActivity(intent);
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.Contractor1099_REQUEST_DATA_CODE && resultCode == RESULT_OK) {
            et_pay_period.setText(contractor1099Map.get("payroll_period"));
            et_hourly_rate.setText(contractor1099Map.get("hour_rate"));
            et_regular_hours.setText(contractor1099Map.get("regular_hours"));
            et_overtime.setText(contractor1099Map.get("overtime"));
            et_tip_in_check.setText(contractor1099Map.get("tips"));
            et_bonus.setText(contractor1099Map.get("bonus"));
        }
    }
}
