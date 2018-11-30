package com.bawei.www.day2lianxi1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        ArrayList<Integer> list = intent.getIntegerArrayListExtra("num");

        int aa = list.get(0);
        int bb = list.get(1);
        int cc = list.get(2);


        int[] num = new int[]{aa,bb,cc};


        CustomView customView =findViewById(R.id.custom);

        customView.setData(num);

    }
}
