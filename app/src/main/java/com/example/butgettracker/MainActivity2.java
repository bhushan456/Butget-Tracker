package com.example.butgettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
// TODAY LIST
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<String> namelist = new ArrayList<String>();
        ArrayList<String> pricelist = new ArrayList<String>();

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1 = sharedPreferences.getString("SmartPhone", null);
        String s2 = sharedPreferences.getString("Laptop", null);
        String s3 = sharedPreferences.getString("Mouse", null);
        String s4 = sharedPreferences.getString("Bag", null);
        String s5 = sharedPreferences.getString("Charger", null);
        String s6 = sharedPreferences.getString("Bottle", null);
        String s7 = sharedPreferences.getString("Shirt", null);

        if (s1 != null){
            namelist.add("SmartPhone");
            pricelist.add("15000");
        }
        if (s2 != null){
            namelist.add("Laptop");
            pricelist.add("60000");
        }
        if (s3 != null){
            namelist.add("Mouse");
            pricelist.add("550");
        }
        if (s4 != null){
            namelist.add("Bag");
            pricelist.add("700");
        }
        if (s5 != null){
            namelist.add("Charger");
            pricelist.add("2200");
        }
        if (s6 != null){
            namelist.add("Bottle");
            pricelist.add("200");
        }
        if (s7 != null){
            namelist.add("Shirt");
            pricelist.add("450");
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, namelist);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pricelist);
        ListView listView2 = (ListView) findViewById(R.id.l2);
        listView2.setAdapter(adapter2);

    }
}