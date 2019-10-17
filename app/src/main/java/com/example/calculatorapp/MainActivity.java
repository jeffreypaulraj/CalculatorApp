package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
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

    Button buttonPi;
    Button buttonE;
    Button buttonRand;
    Button buttonDecimal;
    Button buttonSin;
    Button buttonCos;
    Button buttonTan;
    Button buttonPlusMinus;
    Button buttonSquare;
    Button buttonCube;
    Button buttonSquareRoot;
    Button buttonCubeRoot;
    Button buttonEPowerX;
    Button buttonTenPowerX;
    Button buttonLn;
    Button buttonLog;
    Button buttonSinH;
    Button buttonCosH;
    Button buttonTanH;
    Button buttonDegreeToggle;
    Button buttonClear;
    boolean degree;

    TextView answerField;

    String answerString;
    boolean error;
    ArrayList<String> operationList;
    ArrayList<Double> condensedNumberList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int orientation = getResources().getConfiguration().orientation;
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

        degree = false;
        if (orientation == 2) {
            buttonPi = findViewById(R.id.id_piButton);
            buttonE = findViewById(R.id.id_eButton);
            buttonRand = findViewById(R.id.id_randButton);
            buttonDecimal = findViewById(R.id.id_decimalButton);
            buttonSin = findViewById(R.id.id_sinButton);
            buttonCos = findViewById(R.id.id_cosButton);
            buttonTan = findViewById(R.id.id_tanButton);
            buttonPlusMinus = findViewById(R.id.id_plusMinusButton);
            buttonSquare = findViewById(R.id.id_squareButton);
            buttonCube = findViewById(R.id.id_cubeButton);
            buttonSquareRoot = findViewById(R.id.id_sqrtButton);
            buttonCubeRoot = findViewById(R.id.id_cubeRootButton);
            buttonEPowerX = findViewById(R.id.id_ePowerXButton);
            buttonTenPowerX = findViewById(R.id.id_tenPowerXButton);
            buttonLn = findViewById(R.id.id_lnButton);
            buttonLog = findViewById(R.id.id_logButton);
            buttonSinH = findViewById(R.id.id_sinhButton);
            buttonCosH = findViewById(R.id.id_coshButton);
            buttonTanH = findViewById(R.id.id_tanhButton);
            buttonDegreeToggle = findViewById(R.id.id_degreeButton);


            buttonDecimal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operationList.add(null);
                    answerString += ".";
                    answerField.setText(answerString);
                }
            });

            buttonRand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    operationList = new ArrayList<>();
                    answerString = "" + Math.random();
                    answerField.setText(answerString);
                }
            });
            buttonE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    operationList = new ArrayList<>();
                    answerString = "" + Math.E;
                    answerField.setText(answerString);
                }
            });

            buttonPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    operationList = new ArrayList<>();
                    answerString = "" + Math.PI;
                    answerField.setText(answerString);
                }
            });

            buttonPlusMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(answerString.length() == 0){
                        answerString = "";
                    }
                    if(answerString.length() == 1 && answerString.charAt(0) == '0'){
                        answerString = "0";
                    }
                    else if(answerString.charAt(0)=='-'){
                        answerString = answerString.substring(1);
                    }
                    else {
                        answerString = "-" + answerString;
                    }
                    answerField.setText(answerString);
                }
            });

            buttonSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!degree){
                        checkAnswerError(Math.sin(getSolution()));
                    }
                    else{
                        checkAnswerError(Math.sin(Math.toRadians(getSolution())));
                    }
                }
            });

            buttonCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!degree){
                        checkAnswerError(Math.cos(getSolution()));
                    }
                    else{
                        checkAnswerError(Math.cos(Math.toRadians(getSolution())));
                    }
                }
            });

            buttonTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!degree){
                        checkAnswerError(Math.tan(getSolution()));
                    }
                    else{
                        checkAnswerError(Math.tan(Math.toRadians(getSolution())));
                    }
                }
            });

            buttonSquare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double answer = getSolution();
                    checkAnswerError(answer);
                    if(!error){
                        checkAnswerError(answer*answer);
                    }
                }
            });

            buttonCube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double answer = getSolution();
                    checkAnswerError(answer);
                    if(!error){
                        checkAnswerError(answer*answer*answer);
                    }
                }
            });

            buttonSquareRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswerError(Math.sqrt(getSolution()));
                }
            });

            buttonCubeRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswerError(Math.cbrt(getSolution()));
                }
            });

            buttonLn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswerError(Math.log(getSolution()));
                }
            });

            buttonLog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswerError(Math.log10(getSolution()));
                }
            });

            buttonEPowerX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswerError(Math.exp(getSolution()));
                }
            });

            buttonTenPowerX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswerError(Math.pow(10,getSolution()));
                }
            });

            buttonSinH.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswerError(Math.sinh(getSolution()));
                }
            });

            buttonCosH.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswerError(Math.cosh(getSolution()));
                }
            });

            buttonTanH.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswerError(Math.tanh(getSolution()));
                }
            });

            buttonDegreeToggle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    degree = !degree;

                    if(degree){
                        buttonDegreeToggle.setText("DEG");
                    }
                    else{
                        buttonDegreeToggle.setText("RAD");
                    }
                }
            });
        }
        answerField = findViewById(R.id.id_answerField);
        answerField.setMovementMethod(new ScrollingMovementMethod());

        answerString = "";
        operationList = new ArrayList<>();
        condensedNumberList = new ArrayList<>();
        error = false;

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
                checkAnswerError(getSolution());
            }
        });
    }

    public double getSolution(){
        double Solution = 0;

        error = false;
        System.out.println("String: " + answerString);

        StringTokenizer answerTokenizer = new StringTokenizer(answerString, "+-*/");
        while(answerTokenizer.hasMoreTokens()){
            String currentNumString = answerTokenizer.nextToken();
            System.out.println(currentNumString);
            double currentNum = Double.parseDouble(currentNumString);
            condensedNumberList.add(currentNum);
        }
        if(condensedNumberList.size() == 0){
            return 0;
        }
        if(answerString.charAt(0) == '-'){
            condensedNumberList.set(0,condensedNumberList.get(0)*-1);
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

            if(operand == "/" && condensedNumberList.get(i) == 0){
                error = true;
            }
        }
        if(operationList.size() >= condensedNumberList.size()){
            error = true;
        }
        condensedNumberList = new ArrayList<>();
        operationList = new ArrayList<>();
        return Solution;
    }

    public void checkAnswerError(double answer){
        answerString = "" + answer;
        if(error){
            answerString = "" + 0;
            answerField.setText("Error");
        }
        else {
            answerField.setText("" + answer);
        }
    }
}