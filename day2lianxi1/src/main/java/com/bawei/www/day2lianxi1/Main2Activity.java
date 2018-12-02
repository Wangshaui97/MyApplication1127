package com.bawei.www.day2lianxi1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.www.day2lianxi1.LuckPan.LuckPanActivity;
import com.bawei.www.day2lianxi1.Rundom.RundomActivity;
import com.bawei.www.day2lianxi1.Water.WaterActivity;
import com.bawei.www.day2lianxi1.weektest.WeekTestActivity;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private Button chart_button;
    private EditText chart_one, chart_two, chart_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        chart_button = findViewById(R.id.chart_button);

        chart_one = findViewById(R.id.chart_one);
        chart_two = findViewById(R.id.chart_two);
        chart_three = findViewById(R.id.chart_three);

        chart_button.setOnClickListener(new View.OnClickListener() {

            private int inputchart_three;
            private int inputchart_two;
            private int inputchart_one;

            @Override
            public void onClick(View v) {


                ArrayList<Integer> num = new ArrayList<>();

                String topone = chart_one.getText().toString();
                boolean topo = TextUtils.isEmpty(topone);
                String toptwo = chart_two.getText().toString();
                boolean topt = TextUtils.isEmpty(toptwo);
                String topthree = chart_three.getText().toString();
                boolean toptr = TextUtils.isEmpty(topthree);

                if(topo==true){
                    inputchart_one=0;
                }else if(topt==true){
                    inputchart_two=0;
                }else if(toptr==true){
                    inputchart_three=0;
                }else if(topo==false&&topt==false&&toptr==false){
                    inputchart_one = Integer.parseInt(chart_one.getText().toString());
                    inputchart_two = Integer.parseInt(chart_two.getText().toString());
                    inputchart_three = Integer.parseInt(chart_three.getText().toString());

                }


                    num.add(inputchart_one);
                    num.add(inputchart_two);
                    num.add(inputchart_three);


                Intent intent = new Intent(Main2Activity.this, MainActivity.class);

                intent.putIntegerArrayListExtra("num", num);

                startActivity(intent);
            }
        });

        findViewById(R.id.Luckpan_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, LuckPanActivity.class));
            }
        });

        findViewById(R.id.rundom_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, RundomActivity.class));
            }
        });
        findViewById(R.id.water_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, WaterActivity.class));
            }
        });
        findViewById(R.id.week_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, WeekTestActivity.class));
            }
        });


    }
}
