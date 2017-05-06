package com.kc4tech.quickpaycheck.vo;

/**
 * Created by kaka on 11/12/2016.
 */
public class W2Employee extends GrossIncome {

    private Type type;
    private int allowance;
    private String maritalStatus;
    private State state;

    public W2Employee(String payrollPeriod, double hourRate, float regularHours, float overTimeHours, double tipInCheck, double bonus, Type type) {
        super(payrollPeriod, hourRate, regularHours, overTimeHours, tipInCheck, bonus);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
