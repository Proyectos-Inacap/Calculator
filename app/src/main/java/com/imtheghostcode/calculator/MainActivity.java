package com.imtheghostcode.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    String result = "";
    String operator = "";
    String num1 = "";
    String num2 = "";
    double operation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
    }

    public void clickBtn(View v){
        result = tvResult.getText().toString();
        if (v.getId() == R.id.btnSum || v.getId() == R.id.btnSubtraction || v.getId() == R.id.btnMultiplication || v.getId() == R.id.btnDivision){
            if (tvResult.getText().length() > 0){
                num1 = result;
                operator = ((Button)v).getText().toString();
                tvResult.setText(operator);
            }
        }else if (v.getId() == R.id.btnDelete){
            if (tvResult.getText().length() > 0){
                result = result.substring(0, result.length()-1);
                tvResult.setText(result);
            }
        }else if (v.getId() == R.id.btnEraseAll){
            result = "";
            tvResult.setText(result);
        }else if (v.getId() == R.id.btnDelete){
            if (tvResult.getText().length() > 0){
                result = result.substring(0, result.length()-1);
                tvResult.setText(result);
            }
        }else if (v.getId() == R.id.btnEqual){
            if (tvResult.getText().length() > 0){
                num2 = result;
                if (operator.equals("+")){
                    operation = Double.parseDouble(num1) + Double.parseDouble(num2);
                }else if(operator.equals("-")){
                    operation = Double.parseDouble(num1) - Double.parseDouble(num2);
                }else if(operator.equals("*")){
                    operation = Double.parseDouble(num1) * Double.parseDouble(num2);
                }else if(operator.equals("/")){
                    operation = Double.parseDouble(num1) / Double.parseDouble(num2);
                }
                Log.d("TAG_", operation + "");
                tvResult.setText((operation + "").replace(".0", ""));
            }
        }else{
            if (tvResult.getText().length() < 10){
                if (tvResult.getText().equals("+")|| tvResult.getText().equals("-")|| tvResult.getText().equals("*") || tvResult.getText().equals("/") || tvResult.getText().equals("0")){
                    result = ((Button)v).getText().toString();
                    tvResult.setText(result);
                }else{
                    result = result + ((Button)v).getText().toString();
                    tvResult.setText(result);
                }
            }
        }
    }
}