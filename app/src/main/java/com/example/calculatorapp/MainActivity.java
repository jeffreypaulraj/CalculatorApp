package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonZero;
    Button buttonAddition;
    Button buttonSubtraction;
    Button buttonMultiplication;
    Button buttonDivision;
    Button buttonEqual;
    Button buttonClear;

    TextView answerField;

    String answerString;
    ArrayList<String> operationList;
    ArrayList<Double> numberList;
    ArrayList<String> totalList;
    ArrayList<Double> condensedNumberList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = findViewById(R.id.id_oneButton);
        buttonTwo = findViewById(R.id.id_twoButton);
        buttonThree = findViewById(R.id.id_threeButton);
        buttonFour = findViewById(R.id.id_fourButton);
        buttonFive = findViewById(R.id.id_fiveButton);
        buttonSix = findViewById(R.id.id_sixButton);
        buttonSeven = findViewById(R.id.id_sevenButton);
        buttonEight = findViewById(R.id.id_eightButton);
        buttonNine = findViewById(R.id.id_nineButton);
        buttonZero = findViewById(R.id.id_zeroButton);
        buttonAddition = findViewById(R.id.id_additionButton);
        buttonSubtraction = findViewById(R.id.id_subtractionButton);
        buttonMultiplication = findViewById(R.id.id_multiplicationButton);
        buttonDivision = findViewById(R.id.id_divisionButton);
        buttonEqual = findViewById(R.id.id_equalButton);
        buttonClear = findViewById(R.id.id_clearButton);

        answerField = findViewById(R.id.id_answerField);

        answerString = "";
        operationList = new ArrayList<>();
        numberList = new ArrayList<>();
        condensedNumberList = new ArrayList<>();
        totalList = new ArrayList<>();

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(1.0);
                operationList.add(null);
                answerString+="1";
                answerField.setText(answerString);
                totalList.add("Num");

            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(2.0);
                operationList.add(null);
                answerString+="2";
                answerField.setText(answerString);
                totalList.add("Num");

            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(3.0);
                operationList.add(null);
                answerString+="3";
                answerField.setText(answerString);
                totalList.add("Num");

            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(4.0);
                operationList.add(null);
                answerString+="4";
                answerField.setText(answerString);
                totalList.add("Num");

            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(5.0);
                operationList.add(null);
                answerString+="5";
                answerField.setText(answerString);
                totalList.add("Num");

            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(6.0);
                operationList.add(null);
                answerString+="6";
                answerField.setText(answerString);
                totalList.add("Num");

            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(7.0);
                operationList.add(null);
                answerString+="7";
                answerField.setText(answerString);
                totalList.add("Num");

            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(8.0);
                operationList.add(null);
                answerString+="8";
                answerField.setText(answerString);
                totalList.add("Num");

            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(9.0);
                operationList.add(null);
                answerString+="9";
                answerField.setText(answerString);
                totalList.add("Num");

            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(0.0);
                operationList.add(null);
                answerString+="0";
                answerField.setText(answerString);
                totalList.add("Num");

            }
        });
        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("+");
                numberList.add(null);
                answerString+="+";
                answerField.setText(answerString);
                totalList.add("Operation");

            }
        });
        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("-");
                numberList.add(null);
                answerString+="-";
                answerField.setText(answerString);
                totalList.add("Operation");

            }
        });
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("*");
                numberList.add(null);
                answerString+="*";
                answerField.setText(answerString);
                totalList.add("Operation");

            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("/");
                numberList.add(null);
                answerString+="/";
                answerField.setText(answerString);
                totalList.add("Operation");

            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerString = "";
                answerField.setText(answerString);
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double answer = getSolution();
                System.out.println(answer);
                answerField.setText("" + answer);
            }
        });
    }

    public double getSolution(){
       double Solution = 0;
        // if(operationList.size() == 0){
         //   return
        //}
        double currentNumber = 0.0;
        if(numberList.size() == 0){
            return 0;
        }
        for(int i = 1; i < numberList.size(); i++){
            if(numberList.get(i-1) != null && numberList.get(i) != null){
                currentNumber = 10*numberList.get(i-1) + numberList.get(i);
            }
            else if (numberList.get(i-1) != null && numberList.get(i) == null){
                condensedNumberList.add(currentNumber);
                    currentNumber = numberList.get(i+1);
            }
        }

        for(int i = 0; i < operationList.size(); i++){
            if(operationList.get(i) == null){
                operationList.remove(i);
            }
        }

        Solution = condensedNumberList.get(0);
        for(int i = 1; i < condensedNumberList.size(); i++){
            String operand = operationList.get(i-1);
            if(operand == "+"){
                Solution += condensedNumberList.get(i);
            }
            else if(operand == "-"){
                Solution -= condensedNumberList.get(i);
            }
            else if(operand == "*"){
                Solution *= condensedNumberList.get(i);
            }
            else{
                Solution /= condensedNumberList.get(i);
            }

        }
        return Solution;
    }
}
