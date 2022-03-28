package com.example.butgettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
// SET BUTGET
public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        EditText nametxt = findViewById(R.id.editTextTextPersonName);
        EditText sal = findViewById(R.id.editTextTextPersonName2);
        EditText inn = findViewById(R.id.editTextTextPersonName3);
        EditText ess = findViewById(R.id.editTextTextPersonName4);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myEdit.putString("name", nametxt.getText().toString());
                myEdit.putString("salary", sal.getText().toString());
                int num = Integer.parseInt(inn.getText().toString()) + Integer.parseInt(ess.getText().toString());
                String put = String.valueOf(num);
                myEdit.putString("essintial", put);
                myEdit.commit();
                finish();
            }
        });
    }
}