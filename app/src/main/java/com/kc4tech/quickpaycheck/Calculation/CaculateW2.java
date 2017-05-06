package com.kc4tech.quickpaycheck.Calculation;

import com.kc4tech.quickpaycheck.constants.Constants;
import com.kc4tech.quickpaycheck.vo.PayrollPeriod;
import com.kc4tech.quickpaycheck.vo.State;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaka on 4/23/2017.
 */

public class CaculateW2 {

    public double calculateW2ByHourly(){
        return 11;
    }


    private double calculateAdjustTax(double preTax, String payrollPeriod){
        double adjustedTax = 0.0d;
        if (PayrollPeriod.WEEKLY.toString().equalsIgnoreCase(payrollPeriod)) {
            adjustedTax = preTax * Constants.WEEKLY_52;
        } else if (PayrollPeriod.BIWEEKLY.toString().equalsIgnoreCase(payrollPeriod)) {
            adjustedTax = preTax * Constants.BIWEEKLY_26;
        } else if (PayrollPeriod.SEMIMONTHLY.toString().equalsIgnoreCase(payrollPeriod)) {
            adjustedTax = preTax * Constants.SEMI_MONTHLY_24;
        } else if (PayrollPeriod.MONTHLY.toString().equalsIgnoreCase(payrollPeriod)) {
            adjustedTax = preTax * Constants.MONTHLY_12;
        } else if (PayrollPeriod.QUARTERLY.toString().equalsIgnoreCase(payrollPeriod)) {
            adjustedTax = preTax * Constants.QUARTERLY_4;
        } else if (PayrollPeriod.SEMIANNUALLY.toString().equalsIgnoreCase(payrollPeriod)) {
            adjustedTax = preTax * Constants.SEMI_ANNUALLY_2;
        } else if (PayrollPeriod.ANNUALLY.toString().equalsIgnoreCase(payrollPeriod)) {
            adjustedTax = preTax * Constants.ANNUALLY_1;
        } else if (PayrollPeriod.DAILY.toString().equalsIgnoreCase(payrollPeriod)) {
            adjustedTax = preTax * Constants.DAILY_365;
        }
        return adjustedTax;
    }

    private Map<String, String> readStateTaxData(){
        Map<String, String> stateTaxData = new HashMap<>();
        File file = new File("taxRate.txt");
        if (!file.exists() || file.isDirectory()){
            try {
                throw new FileNotFoundException("file not exist");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        BufferedReader br ;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                String []stateTax = line.split("|");
                String rate = stateTax[1].substring(1, stateTax[1].length() - 1);
                stateTaxData.put(stateTax[0], rate);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stateTaxData;
    }

   // [526443:12.3,315866:11.3,263222:10.3,51530:9.3,40773:8,29372:6,18610:4,7850:2,0:1]

    private double calculateAnnualStateTax(double preTax, String payrollPeriod, String maritalStatus, State state){
        double adjustedTax, stateTax = 0 ;
        Map<String, String> stateTaxData = readStateTaxData();
        adjustedTax = calculateAdjustTax(preTax, payrollPeriod);
        if(Constants.SINGLE.equals(maritalStatus)){
            if(stateTaxData.containsKey(state.toString())){
                String rateText = stateTaxData.get(state.toString());
                String rates[] = rateText.split(",");
                for(int i = 0 , len = rates.length; i < len ; i++){
                    String str[]  = rates[i].split(":");
                    double salary = Double.parseDouble(str[0]);
                    double rate = Double.parseDouble(str[1]);
                    if(adjustedTax > salary){
                        stateTax += (adjustedTax - salary) * rate / 100 ;
                        adjustedTax = salary;
                    }
                }
            }
        }else if(Constants.MARRIED.equals(maritalStatus)){
        }
        return  stateTax;
    }

    private double calculateResult(double preTax, double fix1, double fix2, double fix3, double fix4, double fix5, double fix6){
        double result = 0.0d;
        /*  if(preTax <= level1){
              result = 0;
          }else if(level1 < preTax && preTax <= level2){
              result = (preTax - level1) * 10 / 100 ;
          }else if(level2 < preTax && preTax <= level3){
              result = fix1 + (preTax - level2) * 15 / 100;
          }else if(level3 < preTax && preTax <= level4){
              result = fix2 + (preTax - level3) * 25 / 100;
          }else if(level4 < preTax && preTax <= level5){
              result = fix3 + (preTax - level4) * 28 / 100;
          }else if(level5 < preTax && preTax <= level6){
              result =  fix4 + (preTax - level5) * 33 / 100;
          }else if(level6 < preTax && preTax <= level7){
              result =  fix5 + (preTax - level6) * 35 / 100;
          }else{
              result =  fix6 + (preTax - level7) * 39.6 / 100;
          }*/
        return result;
    }

    private double calculateFederalTaxWithholding(String payrollPeriod){
        double federalTaxWithholding = 0.0d ;
        if(PayrollPeriod.WEEKLY.toString().equalsIgnoreCase(payrollPeriod)){
            //federalTaxWithholding = calculateResult()
        }else if(PayrollPeriod.BIWEEKLY.toString().equalsIgnoreCase(payrollPeriod)){

        }else if(PayrollPeriod.SEMIMONTHLY.toString().equalsIgnoreCase(payrollPeriod)){

        }else if(PayrollPeriod.MONTHLY.toString().equalsIgnoreCase(payrollPeriod)){

        }else if(PayrollPeriod.QUARTERLY.toString().equalsIgnoreCase(payrollPeriod)){

        }else if(PayrollPeriod.SEMIANNUALLY.toString().equalsIgnoreCase(payrollPeriod)){

        }else if(PayrollPeriod.ANNUALLY.toString().equalsIgnoreCase(payrollPeriod)){

        }else if(PayrollPeriod.DAILY.toString().equalsIgnoreCase(payrollPeriod)){

        }
        return federalTaxWithholding;
    }

    private double calculateSecurityByHourly(double w2Hourly){
       return  w2Hourly * 6.2 / 100;
    }

    private double calculateMedicareByHourly(double w2Hourly){
        return w2Hourly * 1.45 / 100 ;
    }

    private double calculateNetPayCheckByHourly(double w2Hourly, double federalTaxWithholding, double stateTaxWithholding){
       return  w2Hourly - (federalTaxWithholding + stateTaxWithholding +
               calculateSecurityByHourly(w2Hourly) + calculateMedicareByHourly(w2Hourly));
    }


}
