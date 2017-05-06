package com.kc4tech.quickpaycheck.validation;

import android.text.TextUtils;
import com.kc4tech.quickpaycheck.constants.ErrorMessageConstants;


import java.util.Map;


public class BaseValidate {

    private String payrollPeriodErrorMsg(String payroll_period) {
        return TextUtils.isEmpty(payroll_period) ? ErrorMessageConstants.PAYROLL_PERIOD_NULL_ERROR_MESSAGE : null;
    }

    private String hourRateErrorMsg(String hour_rate) {
        return TextUtils.isEmpty(hour_rate) ? ErrorMessageConstants.HOUR_RATE_NULL_ERROR_MESSAGE :
                !TextUtils.isDigitsOnly(hour_rate) ? ErrorMessageConstants.HOUR_RATE_NOT_DIGIT_ERROR_MESSAGE : null;
    }

    private String overtimeErrorMsg(String overtime) {
        return TextUtils.isEmpty(overtime) ? ErrorMessageConstants.OVER_TIME_NULL_ERROR_MESSAGE :
                !TextUtils.isDigitsOnly(overtime) ? ErrorMessageConstants.OVER_TIME_NOT_DIGIT_ERROR_MESSAGE : null;
    }

    private String regularHourErrorMsg(String regular_hours) {
        return TextUtils.isEmpty(regular_hours) ? ErrorMessageConstants.REGULAR_HOURS_NULL_ERROR_MESSAGE :
                !TextUtils.isDigitsOnly(regular_hours) ? ErrorMessageConstants.REGULAR_HOURS_NOT_DIGIT_ERROR_MESSAGE : null;
    }

    private String tipsErrorMsg(String tips) {
        return TextUtils.isEmpty(tips) ? ErrorMessageConstants.TIP_IN_CHECK_NULL_ERROR_MESSAGE :
                !TextUtils.isDigitsOnly(tips) ? ErrorMessageConstants.TIP_IN_CHECK_NOT_DIGIT_ERROR_MESSAGE : null;
    }

    private String bonusErrorMsg(String bonus) {
        return TextUtils.isEmpty(bonus) ? ErrorMessageConstants.BONUS_NULL_ERROR_MESSAGE :
                !TextUtils.isDigitsOnly(bonus) ? ErrorMessageConstants.BONUS_NOT_DIGIT_ERROR_MESSAGE : null;
    }

    private String salaryErrorMsg(String salary){
        return TextUtils.isEmpty(salary)? ErrorMessageConstants.SALARY_NULL_ERROR_MESSAGE :
                !TextUtils.isDigitsOnly(salary)? ErrorMessageConstants.SALARY_NOT_DIGIT_ERROR_MESSAGE : null;
    }

    /**
     * Validate fields of payroll period and salary when choose the salary button.
     * if doesn't have the error message, save payroll period and salary data into hashMap
     * if have error message, save the error message into a string
     * @param map
     * @param payPeriodText
     * @param salaryText
     * @return
     */
    public String validateFieldsForSalary(Map<String, String> map, String payPeriodText, String salaryText){
        StringBuilder sb = new StringBuilder();
        String errorMsg = payrollPeriodErrorMsg(payPeriodText);
        if (errorMsg == null || errorMsg.isEmpty()) {
            map.put("payroll_period", payPeriodText);
        } else {
            sb.append(errorMsg).append("\n");
        }
        errorMsg = salaryErrorMsg(salaryText);
        if (errorMsg == null || errorMsg.isEmpty()) {
            map.put("salary", salaryText);
        } else {
            sb.append(errorMsg).append("\n");
        }
        return sb.toString();
    }

    /**
     * Validate fields of payroll period, hour rate, regular hour, overtime , tips and bonus when
     * choose hourly button, if doesn't have the error message, save payroll period , hour rate, regular hour
     * overtime, tips, and  bonus data in a hashMap. If have the error message, save the error message
     * into a string.
     * into hashMap
     * @param map
     * @param payPeriodText
     * @param hourRateText
     * @param regularHoursText
     * @param overtimeText
     * @param tipInCheckText
     * @param bonusText
     * @return
     */
    public String validateFields(Map<String, String> map, String payPeriodText, String hourRateText,
                                 String regularHoursText, String overtimeText, String tipInCheckText, String bonusText) {
        StringBuilder sb = new StringBuilder();
        String errorMsg = payrollPeriodErrorMsg(payPeriodText);
        if (errorMsg == null || errorMsg.isEmpty()) {
            map.put("payroll_period", payPeriodText);
        } else {
            sb.append(errorMsg).append("\n");
        }
        errorMsg = hourRateErrorMsg(hourRateText);
        if (errorMsg == null || errorMsg.isEmpty()) {
            double hour_rate = Double.parseDouble(hourRateText);
            map.put("hour_rate", String.valueOf(hour_rate));
        } else {
            sb.append(errorMsg).append("\n");
        }
        errorMsg = regularHourErrorMsg(regularHoursText);
        if (errorMsg == null || errorMsg.isEmpty()) {
            float regular_hours = Float.parseFloat(regularHoursText);
            map.put("regular_hours", String.valueOf(regular_hours));
        } else {
            sb.append(errorMsg).append("\n");
        }
        errorMsg = overtimeErrorMsg(overtimeText);
        if (errorMsg == null || errorMsg.isEmpty()) {
            float overtime = Float.parseFloat(overtimeText);
            map.put("overtime", String.valueOf(overtime));
        } else {
            sb.append(errorMsg).append("\n");
        }
        errorMsg = tipsErrorMsg(tipInCheckText);
        if (errorMsg == null || errorMsg.isEmpty()) {
            double tips = Double.parseDouble(tipInCheckText);
            map.put("tips", String.valueOf(tips));
        } else {
            sb.append(errorMsg).append("\n");
        }
        errorMsg = bonusErrorMsg(bonusText);
        if (errorMsg == null || errorMsg.isEmpty()) {
            double bonus = Double.parseDouble(bonusText);
            map.put("bonus", String.valueOf(bonus));
        } else {
            sb.append(errorMsg).append("\n");
        }
        return sb.toString();
    }

}
