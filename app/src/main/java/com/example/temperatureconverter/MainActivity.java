package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2;
    Button b1,b2;
    EditText e1;
    ImageView img,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.op);
        b1=findViewById(R.id.CF);
        b2=findViewById(R.id.FC);
        e1=findViewById(R.id.value);
        img=findViewById(R.id.imageView);
        img2=findViewById(R.id.imageView2);

        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onClick(View view) {
                String inputText = e1.getText().toString().trim();
                if (inputText.isEmpty()) {
                    t1.setText("Please enter the value");
                    return;
                }
                try {
                    float C = Float.parseFloat(inputText);
                    float result = (C * 9 / 5) + 32;
                    t1.setText(String.format("%.2f\u00B0 C", result));
                } catch (NumberFormatException e) {
                    t1.setText("Invalid input. Please enter a valid number.");
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View view) {
                String inputText = e1.getText().toString().trim();
                if (inputText.isEmpty()) {
                    t1.setText("Please enter the value");
                    return;
                }

                try {
                    Float F = Float.parseFloat(inputText);
                    Float result = (F - 32) * 5 / 9;
                    t1.setText(String.format("%.2f\u00B0 F", result));
                } catch (NumberFormatException e) {
                    t1.setText("Invalid input. Please enter a valid number.");
                }

            }
        });

    }
}