package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public final EditText input1 = findViewById(R.id.input1);
    public EditText input2;
    public TextView result;
    public Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input2 = findViewById(R.id.input2);
        result = findViewById(R.id.result);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        btnAdd.setOnClickListener(v -> performOperation("+"));

        btnSubtract.setOnClickListener(v -> performOperation("-"));

        btnMultiply.setOnClickListener(v -> performOperation("*"));

        btnDivide.setOnClickListener(v -> performOperation("/"));
    }

    @SuppressLint("SetTextI18n")
    public void performOperation(String operation) {
        try {
            double num1 = Double.parseDouble(input1.getText().toString());
            double num2 = Double.parseDouble(input2.getText().toString());
            double resultValue = 0;

            switch (operation) {
                case "+":
                    resultValue = num1 + num2;
                    break;
                case "-":
                    resultValue = num1 - num2;
                    break;
                case "*":
                    resultValue = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultValue = num1 / num2;
                    } else {
                        result.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            result.setText("Result: " + resultValue);
        } catch (NumberFormatException e) {
            result.setText("Invalid input");
        }
    }
}
