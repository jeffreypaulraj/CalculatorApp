package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;


import java.util.ArrayList;
import java.util.StringTokenizer;

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
        answerField.setMovementMethod(new ScrollingMovementMethod());

        answerString = "";
        operationList = new ArrayList<>();
        condensedNumberList = new ArrayList<>();

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add(null);
                answerString+="1";
                answerField.setText(answerString);
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add(null);
                answerString += "2";
                answerField.setText(answerString);
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add(null);
                answerString+="3";
                answerField.setText(answerString);
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add(null);
                answerString+="4";
                answerField.setText(answerString);
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add(null);
                answerString+="5";
                answerField.setText(answerString);
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add(null);
                answerString+="6";
                answerField.setText(answerString);
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add(null);
                answerString+="7";
                answerField.setText(answerString);
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add(null);
                answerString+="8";
                answerField.setText(answerString);
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add(null);
                answerString+="9";
                answerField.setText(answerString);
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add(null);
                answerString+="0";
                answerField.setText(answerString);
            }
        });
        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("+");
                answerString+="+";
                answerField.setText(answerString);
            }
        });
        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("-");
                answerString+="-";
                answerField.setText(answerString);
            }
        });
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("*");
                answerString+="*";
                answerField.setText(answerString);
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("/");
                answerString+="/";
                answerField.setText(answerString);
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerString = "";
                answerField.setText("0");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double answer = getSolution();
                answerString = "" + answer;
                answerField.setText("" + answer);
            }
        });
    }

    public double getSolution(){
        double Solution = 0;

        if(condensedNumberList.size() == 0){
            return 0;
        }
        System.out.println("String: " + answerString);

        StringTokenizer answerTokenizer = new StringTokenizer(answerString, "+-*/");
        while(answerTokenizer.hasMoreTokens()){
            String currentNumString = answerTokenizer.nextToken();
            System.out.println(currentNumString);
            double currentNum = Double.parseDouble(currentNumString);
            condensedNumberList.add(currentNum);
        }

        for(int i = operationList.size() - 1; i >= 0; i--){
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
        condensedNumberList = new ArrayList<>();
        operationList = new ArrayList<>();
        return Solution;
    }
}