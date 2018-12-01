package com.bawei.www.day2lianxi1.Water;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bawei.www.day2lianxi1.R;

import java.util.ArrayList;
import java.util.List;

public class WaterActivity extends AppCompatActivity {

    List<String> strList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        final EditText editText = findViewById(R.id.input_add);
        final WaterView waterView = findViewById(R.id.waterView);
        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                strList.add(str);
                waterView.setData(strList);
            }
        });

    }
}
