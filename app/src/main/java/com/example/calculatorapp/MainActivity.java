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
    ArrayList operationList;
    ArrayList numberList;
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

        answerString = "0";
        operationList = new ArrayList<String>();
        numberList = new ArrayList<Double>();

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(1.0);
                answerString+="1";
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(2.0);
                answerString+="2";
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(3.0);
                answerString+="3";
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(4.0);
                answerString+="4";
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(5.0);
                answerString+="5";
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(6.0);
                answerString+="6";
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(7.0);
                answerString+="7";
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(8.0);
                answerString+="8";
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(9.0);
                answerString+="9";
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(0.0);
                answerString+="0";
            }
        });
        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("+");
                answerString+="+";
            }
        });
        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("-");
                answerString+="-";
            }
        });
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("*");
                answerString+="*";
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationList.add("/");
                answerString+="/";
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerString ="0";
            }
        });
        answerField.setText(answerString);
    }
}
