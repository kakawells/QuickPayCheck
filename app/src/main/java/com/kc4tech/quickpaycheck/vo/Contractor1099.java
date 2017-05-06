package com.kc4tech.quickpaycheck.vo;

import java.io.Serializable;

/**
 * Created by kaka on 11/12/2016.
 */
public class Contractor1099 extends GrossIncome implements Serializable{

    private Type type;

    public Contractor1099(String payrollPeriod, double hourRate, float regularHours, float overTimeHours, double tipInCheck, double bonus, Type type) {
        super(payrollPeriod, hourRate, regularHours, overTimeHours, tipInCheck, bonus);
        this.type = type;
    }

    public  Contractor1099(String payrollPeriod, double salary, Type type){
        super(payrollPeriod, salary);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
