package com.example.butgettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Textview
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button (ADD ITEM)
        ImageButton button = findViewById(R.id.imageButton3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tosast
                Toast.makeText(MainActivity.this, "SCAN BARCODE", Toast.LENGTH_SHORT).show();
                // Instance of IntentIntegrator
                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
                intentIntegrator.initiateScan();
            }
        });
        //Button (TODAY)
        ImageButton button2 = findViewById(R.id.imageButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        //Button (SET BUTGET)
        ImageButton button3 = findViewById(R.id.imageButton4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });
        //Button (MY BUTGET)
        ImageButton button4 = findViewById(R.id.imageButton);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        //DISPLAY NAME
        TextView textView2 = findViewById(R.id.textView2);
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String txt = sharedPreferences.getString("name", "");
        textView2.setText("Hello ,"+txt);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //Textview object
        textView = findViewById(R.id.textView8);
        super.onActivityResult(requestCode, resultCode, intent);
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult == null){
            Toast.makeText(this, "scanResult == null", Toast.LENGTH_SHORT).show();
        }
        else {
            textView.setText(scanResult.getContents());
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();

            Getdata getdata = new Getdata();
            getdata.givestring(scanResult.getContents());

            myEdit.putString(getdata.getname(), getdata.getprice());
            myEdit.commit();

        }
    }

}