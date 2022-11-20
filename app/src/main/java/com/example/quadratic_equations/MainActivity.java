package com.example.quadratic_equations;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        private EditText editTextA;
        private EditText editTextB;
        private EditText editTextC;
        private TextView TextViewX1;
        private TextView TextViewX2;

        @Override
        protected void onCreate(Bundle savedInstanceState) { // ax + b = c // x = (c-b)/a
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                editTextA = findViewById(R.id.edit_text_a);
                editTextB = findViewById(R.id.edit_text_b);
                editTextC = findViewById(R.id.edit_text_c);
                TextViewX1 = findViewById(R.id.text_view_x1);
                TextViewX2 = findViewById(R.id.text_view_x2);
        }

        private double getDoubleValue(EditText editText) {
                return Double.parseDouble(editText.getText().toString());
        }

        public void check(double x1, double x2) {
                if (x1 == x2) {
                        TextViewX1.setText("Ваш x равен:");
                        TextViewX2.setText(String.format("%.2f", Math.abs(x1)));
                }
        }

        public void onMyButtonClick1(View view) {
                if (editTextA.getText().toString().isEmpty() || editTextB.getText().toString().isEmpty() || editTextC.getText().toString().isEmpty()) {
                        TextViewX1.setText("!");
                        TextViewX2.setText("Введите значения коэффициентов!");
                }
                else {
                        double a = getDoubleValue(editTextA);
                        double b = getDoubleValue(editTextB);
                        double c = getDoubleValue(editTextC);

                        if (a == 0 && b == 0 && c == 0) {
                                TextViewX1.setText("Корень уравнения - ");
                                TextViewX2.setText("любое число");
                        }

                        else {
                                double Discriminant = b * b - 4 * a * c;
                                if (Discriminant > 0) {
                                        double x1 = (Math.sqrt(Discriminant) - b) / 2 * a;
                                        double x2 = -(Math.sqrt(Discriminant) + b) / 2 * a;
                                        if (x1 == x2) {
                                                check(x1, x2);
                                        }
                                        else {
                                                TextViewX1.setText("x1 = " + String.format("%.2f", x1));
                                                TextViewX2.setText("x2 = " + String.format("%.2f", x2));
                                        }
                                } else if (Discriminant == 0) {
                                        double x = -b / 2 * a;
                                        TextViewX1.setText("Ваш x равен:");
                                        if (x == 0) TextViewX2.setText(String.format("%.2f", Math.abs(x)));
                                        else TextViewX2.setText(String.format("%.2f", x));
                                }
                                else {
                                        TextViewX1.setText("Нет");
                                        TextViewX2.setText("корней");
                                }
                        }
                }
        }
}