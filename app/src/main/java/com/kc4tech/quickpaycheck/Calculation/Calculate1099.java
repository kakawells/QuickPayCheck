package com.kc4tech.quickpaycheck.Calculation;

import com.kc4tech.quickpaycheck.constants.Constants;
import com.kc4tech.quickpaycheck.vo.PayrollPeriod;

/**
 * Created by kaka on 11/27/2016.
 */
public class Calculate1099 {

    /**
     * Calculate 1099 Net Pay Check by Salary
     *
     * @param payrollPeriod
     * @param salary
     * @return
     */
    public double calculate1099NetPayCheckBySalary(String payrollPeriod, double salary) {
        double netPayCheck = 0.0d;
        if (PayrollPeriod.WEEKLY.toString().equalsIgnoreCase(payrollPeriod)) {
            netPayCheck = salary / Constants.WEEKLY_52;
        } else if (PayrollPeriod.BIWEEKLY.toString().equalsIgnoreCase(payrollPeriod)) {
            netPayCheck = salary / Constants.BIWEEKLY_26;
        } else if (PayrollPeriod.SEMIMONTHLY.toString().equalsIgnoreCase(payrollPeriod)) {
            netPayCheck = salary / Constants.SEMI_MONTHLY_24;
        } else if (PayrollPeriod.MONTHLY.toString().equalsIgnoreCase(payrollPeriod)) {
            netPayCheck = salary / Constants.MONTHLY_12;
        } else if (PayrollPeriod.QUARTERLY.toString().equalsIgnoreCase(payrollPeriod)) {
            netPayCheck = salary / Constants.QUARTERLY_4;
        } else if (PayrollPeriod.SEMIANNUALLY.toString().equalsIgnoreCase(payrollPeriod)) {
            netPayCheck = salary / Constants.SEMI_ANNUALLY_2;
        } else if (PayrollPeriod.ANNUALLY.toString().equalsIgnoreCase(payrollPeriod)) {
            netPayCheck = salary / Constants.ANNUALLY_1;
        } else if (PayrollPeriod.DAILY.toString().equalsIgnoreCase(payrollPeriod)) {
            netPayCheck = salary / Constants.DAILY_365;
        }
        return netPayCheck;
    }

    /**
     * Calculate 1099 Net Pay Check by hourly
     *
     * @param
     * @return
     */
    public double calculate1099NetPayCheckByHourly(double hour_rate, float regular_hours, float overtime, double bonus, double tips) {
        return calRegularHoursPay(hour_rate, regular_hours) + calOvertimesPay(hour_rate, overtime) + bonus + tips;
    }

    /**
     * calculate the regular hour pay
     *
     * @param hour_rate
     * @param regular_hours
     * @return
     */
    public double calRegularHoursPay(double hour_rate, float regular_hours) {
        return hour_rate * regular_hours;
    }

    /**
     * calculate the overtime hour pay
     *
     * @param hour_rate
     * @param overtime
     * @return
     */
    public double calOvertimesPay(double hour_rate, float overtime) {
        return hour_rate * overtime * Constants.OVERTIME_PAY_TIMES;
    }
}
