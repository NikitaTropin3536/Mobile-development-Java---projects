package com.example.layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;
    private TextView textViewX;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // ax + b = c // x = (c-b)/a
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.edit_text_a);
        editTextB = findViewById(R.id.edit_text_b);
        editTextC = findViewById(R.id.edit_text_c);
        textViewX = findViewById(R.id.text_view_x);
    }

    private double getDoubleValue(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Поля не могут быть пустыми", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Double.parseDouble(editText.getText().toString());
    }

    public void onMyButtonClick(View view) {
        double a = getDoubleValue(editTextA);
        double b = getDoubleValue(editTextB);
        double c = getDoubleValue(editTextC);
        if(b == c && a == 0) {
            textViewX.setText("Any number");
            Toast.makeText(this, "Any number", Toast.LENGTH_SHORT).show();
        }
        else if(b != c && a == 0) {
            textViewX.setText("There is no solution");
            Toast.makeText(this, "There is no solution", Toast.LENGTH_SHORT).show();
        }
        else {
            double x = (c - b) / (double) a;
            textViewX.setText(String.format("%.2f", x));
            Toast.makeText(this, x + "", Toast.LENGTH_SHORT).show();
        }
    }
}