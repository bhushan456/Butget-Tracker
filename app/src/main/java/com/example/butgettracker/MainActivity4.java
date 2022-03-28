package com.example.butgettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        MoneyInfo moneyInfo = new MoneyInfo();
        int sal = moneyInfo.getsal(this);
        TextView textView = findViewById(R.id.textView13);
        textView.setText(String.valueOf(sal));
        int exp = moneyInfo.getexpenses(this);
        TextView textView1 = findViewById(R.id.textView15);
        textView1.setText(String.valueOf(exp));
        int bal = sal - exp;
        TextView textView2 = findViewById(R.id.textView17);
        textView2.setText(String.valueOf(bal));
    }
}