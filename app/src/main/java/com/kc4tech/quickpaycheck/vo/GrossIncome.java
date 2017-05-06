package com.kc4tech.quickpaycheck.vo;

import java.io.Serializable;

/**
 * Created by kaka on 2/25/2017.
 */

public class GrossIncome implements Serializable {
    protected String payrollPeriod;
    protected double hourRate;
    protected float regularHours;
    protected float overTimeHours;
    protected double tipInCheck;
    protected double bonus;
    protected double salary;

    public GrossIncome(String payrollPeriod, double hourRate, float regularHours, float overTimeHours, double tipInCheck, double bonus) {
        this.payrollPeriod = payrollPeriod;
        this.hourRate = hourRate;
        this.regularHours = regularHours;
        this.overTimeHours = overTimeHours;
        this.tipInCheck = tipInCheck;
        this.bonus = bonus;
    }

    public GrossIncome(String payrollPeriod, double salary){
        this.payrollPeriod = payrollPeriod;
        this.salary = salary;
    }

    public double getHourRate() {
        return hourRate;
    }

    public String getPayrollPeriod() {
        return payrollPeriod;
    }

    public float getRegularHours() {
        return regularHours;
    }

    public float getOverTimeHours() {
        return overTimeHours;
    }

    public double getTipInCheck() {
        return tipInCheck;
    }

    public double getBonus() {
        return bonus;
    }

    public double getSalary() {
        return salary;
    }
}
