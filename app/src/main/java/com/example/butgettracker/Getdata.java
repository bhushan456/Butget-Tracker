package com.example.butgettracker;

public class Getdata {
    private String string,ans1,ans2;
    public void givestring(String s){
        string = s;
        String[] words=string.split(":");
        ans1 = words[0];
        ans2 = words[1];
    }
    public String getname(){
        return ans1;
    }
    public String getprice(){
        return ans2;
    }
}
