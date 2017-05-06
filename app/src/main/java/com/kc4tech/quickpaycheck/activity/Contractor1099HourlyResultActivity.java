package com.kc4tech.quickpaycheck.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kc4tech.quickpaycheck.R;
import com.kc4tech.quickpaycheck.constants.Constants;
import com.kc4tech.quickpaycheck.vo.Result;

public class Contractor1099HourlyResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor1099_hourly_result);

        TextView tv_hour_rate = (TextView)findViewById(R.id.hourly_rate_result);
        TextView tv_reg_hr =(TextView) findViewById(R.id.reg_hr_result);
        TextView tv_overtime = (TextView)findViewById(R.id.overtime_result);
        TextView tv_reg_hour_pay = (TextView) findViewById(R.id.reg_hour_result);
        TextView tv_ovt_hour_pay = (TextView) findViewById(R.id.ovt_hour_result);
        TextView tv_tipsPay = (TextView) findViewById(R.id.tips_result);
        TextView tv_bonusPay = (TextView) findViewById(R.id.bonus_result);
        TextView tv_netPayCheck = (TextView) findViewById(R.id.netPayCheck_result);
        Button btn_arrow_back = (Button)findViewById(R.id.arrow_back);
        Button btn_startOver = (Button) findViewById(R.id.startOver);
        Bundle bundle = this.getIntent().getExtras();
        Result contract1099Result = (Result)bundle.get("contract1099Result");
        tv_hour_rate.setText(Constants.DOLLAR_SIGN + String.valueOf(contract1099Result.getContractor1099().getHourRate()));
        tv_reg_hr.setText(String.valueOf(contract1099Result.getContractor1099().getRegularHours()));
        tv_overtime.setText(String.valueOf(contract1099Result.getContractor1099().getOverTimeHours()));
        tv_reg_hour_pay.setText(Constants.DOLLAR_SIGN + String.valueOf(contract1099Result.getRegularHoursPay()));
        tv_ovt_hour_pay.setText(Constants.DOLLAR_SIGN + String.valueOf(contract1099Result.getOvertimePay()));
        tv_tipsPay.setText(Constants.DOLLAR_SIGN + String.valueOf(contract1099Result.getContractor1099().getTipInCheck()));
        tv_bonusPay.setText(Constants.DOLLAR_SIGN + String.valueOf(contract1099Result.getContractor1099().getBonus()));
        tv_netPayCheck.setText(Constants.DOLLAR_SIGN + String.valueOf(contract1099Result.getNetPaycheck()));
        btn_arrow_back.setOnClickListener(new BackArrowButtonOnClickListener());
        btn_startOver.setOnClickListener((View v) ->{
            Intent intent = new Intent();
            intent.setClass(Contractor1099HourlyResultActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    /**
     * click the back arrow button forward back to Contract 1099 Input View
     */
    private class BackArrowButtonOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(Contractor1099HourlyResultActivity.this, Contractor1099Activity.class);
            //startActivity(intent);
            Contractor1099HourlyResultActivity.this.setResult(RESULT_OK, intent);
            Contractor1099HourlyResultActivity.this.finish();
        }
    }
}
