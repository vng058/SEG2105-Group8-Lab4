package com.example.seg2105_group8_lab1;

import java.math.BigDecimal;

public class Evaluator {

    public double doOperationLogic(double value1, double value2, Operator optr){
        double resultNum = 0;
        if(optr == Operator.add){
            resultNum = value1 + value2;
        }
        if(optr == Operator.minus){
            resultNum = value1 - value2;
        }
        if(optr == Operator.multiply){
            resultNum = value1*value2;
        }
        if(optr == Operator.divide){
            resultNum = value1/value2;
        }
        return resultNum;

    }

    public String formatResult(double value) {
        BigDecimal bd = BigDecimal.valueOf(value).stripTrailingZeros();
        return bd.toPlainString(); // "12" instead of "12.0"
    }
}
