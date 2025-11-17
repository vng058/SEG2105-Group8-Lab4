package com.example.seg2105_group8_lab1;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.Test;

public class EvaluatorTest {

    @Test
    public void doOperationLogic_add(){
        Evaluator eval = new Evaluator();
        double actual = eval.doOperationLogic(2,5,Operator.add);
        double expected = 7;
        assertEquals("Addition has failed.",expected, actual, 0.0001);
    }

    @Test
    public void doOperationLogic_minus(){
        Evaluator eval = new Evaluator();
        double actual = eval.doOperationLogic(5,10,Operator.minus);
        double expected = -5;
        assertEquals("Subtraction has failed.",expected, actual, 0.0001);
    }

    @Test
    public void doOperationLogic_multiply(){
        Evaluator eval = new Evaluator();
        double actual = eval.doOperationLogic(4,3,Operator.multiply);
        double expected = 12;
        assertEquals("Multiplication has failed.",expected, actual, 0.0001);
    }

    @Test
    public void doOperationLogic_divide(){
        Evaluator eval = new Evaluator();
        double actual = eval.doOperationLogic(7,2,Operator.divide);
        double expected = 3.5;
        assertEquals("Division has failed.",expected, actual, 0.0001);
    }


    @Test
    public void formatResult_test1(){
        Evaluator eval = new Evaluator();
        String actual = eval.formatResult(32.400);
        String expected = "32.4";
        assertEquals("Formatting failed.",expected, actual);
    }

    @Test
    public void formatResult_test2(){
        Evaluator eval = new Evaluator();
        String actual = eval.formatResult(12.0000);
        String expected = "12";
        assertEquals("Formatting failed", expected, actual);
    }

    @Test
    public void doOperationLogic_divideFail(){ //supposed to fail
        Evaluator eval = new Evaluator();
        double actual = eval.doOperationLogic(7,2,Operator.none);
        double expected = 3.5;
        assertEquals("Division failed.",expected, actual, 0.0001);
    }



}