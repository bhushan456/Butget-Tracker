package com.example.butgettracker;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MoneyInfo {
    public int getexpenses(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref",MODE_PRIVATE);
        int expense = Integer.parseInt( sharedPreferences.getString("essintial","") );

        ArrayList<Integer> pricelist = new ArrayList<Integer>();

        String s1 = sharedPreferences.getString("SmartPhone", null);
        String s2 = sharedPreferences.getString("Laptop", null);
        String s3 = sharedPreferences.getString("Mouse", null);
        String s4 = sharedPreferences.getString("Bag", null);
        String s5 = sharedPreferences.getString("Charger", null);
        String s6 = sharedPreferences.getString("Bottle", null);
        String s7 = sharedPreferences.getString("Shirt", null);

        if (s1 != null){
            pricelist.add(15000);
        }
        if (s2 != null){
            pricelist.add(60000);
        }
        if (s3 != null){
            pricelist.add(550);
        }
        if (s4 != null){
            pricelist.add(700);
        }
        if (s5 != null){
            pricelist.add(2200);
        }
        if (s6 != null){
            pricelist.add(200);
        }
        if (s7 != null){
            pricelist.add(450);
        }

        int otherexpense = 0;
        for (int i=0;i<pricelist.size();i++){
            otherexpense += pricelist.get(i);
        }

        int totalKharcha = otherexpense + expense;
        return totalKharcha;
    }
    public int getsal(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref",MODE_PRIVATE);
        int sal = Integer.parseInt( sharedPreferences.getString("salary", null) );
        return sal;
    }
}
