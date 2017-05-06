package com.kc4tech.quickpaycheck.vo;

import java.io.Serializable;

/**
 * Created by kaka on 3/4/2017.
 */

public class Result implements Serializable {
   public Contractor1099 contractor1099;
   public double regularHoursPay;
   public double overtimePay;
   public double netPaycheck;

    public Result(Contractor1099 contractor1099, double regularHoursPay, double overtimePay, double netPaycheck) {
        this.contractor1099 = contractor1099;
        this.regularHoursPay = regularHoursPay;
        this.overtimePay = overtimePay;
        this.netPaycheck = netPaycheck;
    }

    public Result(Contractor1099 contractor1099, double netPaycheck){
        this.contractor1099 = contractor1099;
        this.netPaycheck = netPaycheck;
    }

    public Contractor1099 getContractor1099() {
        return contractor1099;
    }

    public double getRegularHoursPay() {
        return regularHoursPay;
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public double getNetPaycheck() {
        return netPaycheck;
    }
}
