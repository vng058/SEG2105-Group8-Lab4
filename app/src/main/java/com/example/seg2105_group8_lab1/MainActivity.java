package com.example.seg2105_group8_lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnAdd, btnSub, btnMul, btnDiv, btnClr, btnEql, btnDec;

    TextView display;

    double val1, val2, result;

   // enum Operator {none, add, minus, multiply, divide};
    //String [] symbols = {"+","-","*","/"};
    String symbol;
    Operator optr = Operator.none;
    Evaluator evaluator = new Evaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.textViewValue);

        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnAdd = findViewById(R.id.buttonAdd);
        btnSub = findViewById(R.id.buttonSub);
        btnMul = findViewById(R.id.buttonMult);
        btnDiv = findViewById(R.id.buttonDiv);
        btnDec = findViewById(R.id.buttonDot);
        btnClr = findViewById(R.id.buttonClr);
        btnEql = findViewById(R.id.buttonEquals);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("0");
            }
        }
        );
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("1");
            }
        }
        );
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("2");
            }
        }
        );
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("3");
            }
        }
        );
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("4");
            }
        }
        );
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("5");
            }
        }
        );
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("6");
            }
        }
        );
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("7");
            }
        }
        );
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("8");
            }
        }
        );
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber("9");
            }
        }
        );

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearDisplay();
            }
        }
        );
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                optr = Operator.add;
                symbol = "+";
                inputOperator(symbol);
            }
        }
        );
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                optr = Operator.minus;
                symbol = "-";
                inputOperator(symbol);
            }
        }
        );
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                optr = Operator.multiply;
                symbol = "*";
                inputOperator(symbol);
            }
        }
        );
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                optr = Operator.divide;
                symbol = "/";
                inputOperator(symbol);
            }
        }
        );
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDecimal();
            }
        }
        );
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(optr != Operator.none && symbol != ""){
                    String numStr = " " + (String)display.getText();
                    int symbolIndex = numStr.indexOf(symbol);
                    String valStr1 = numStr.substring(0,symbolIndex).trim();
                    String valStr2 = numStr.substring(symbolIndex+1).trim();
                    System.out.println(valStr1 + "," + valStr2);
                    if(checkIfDouble(valStr1,valStr2)){
                        val1 = Double.parseDouble(valStr1);
                        val2 = Double.parseDouble(valStr2);
                        doOperation(val1, val2);
                    }
                    else{
                        display.setText(display.getText());
                    }

                }
                else{
                    display.setText(display.getText()); // this makes it so the calculator doesn't change if optr == Operator.none
                }
            }
        }
        );
    }
    private boolean checkIfDouble(String valueStr1, String valueStr2){
        if(valueStr1.equals("") || valueStr2.equals("")){
            return false;
        }
        return true;
    }


    private void doOperation(double value1, double value2){
        result = evaluator.doOperationLogic(value1, value2, optr);
        display.setText(evaluator.formatResult(result));

    }
    private void inputNumber(String num){
        display.setText(display.getText() + num);
    }
    private void inputOperator(String operator){
        display.setText(display.getText() + operator);
    }
    private void clearDisplay(){
        display.setText("");
        symbol = "";
        val1 = 0;
        val2 = 0;
        result = 0;
    }
    private void insertDecimal() {
        String text = display.getText().toString();
        String current = getCurrentToken(text);

        if (current.isEmpty()) {
            // Starting a new number with a decimal -> "0."
            display.setText(text + "0.");
        } else if (!current.contains(".")) {
            // Add a decimal only if the current token doesn't already have one
            display.setText(text + ".");
        }
    }

    private String getCurrentToken(String s) {
        int lastPlus = s.lastIndexOf('+');
        int lastMinus = s.lastIndexOf('-');
        int lastMul = s.lastIndexOf('*');
        int lastDiv = s.lastIndexOf('/');

        int idx = Math.max(Math.max(lastPlus, lastMinus), Math.max(lastMul, lastDiv));
        return idx == -1 ? s : s.substring(idx + 1);
    }


}


