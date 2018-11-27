package com.bawei.www.dome2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText moblie, pwd;
    private Button login, updata;
    private String loginmobile;
    private String loginpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moblie = findViewById(R.id.moblie);
        pwd = findViewById(R.id.pwd);


        login = findViewById(R.id.login);
        updata = findViewById(R.id.updata);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginmobile = moblie.getText().toString();
                loginpassword = pwd.getText().toString();
                initLogin();
            }
        });

        updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main3Activity.class));
                finish();
            }
        });



    }

    private void initLogin() {
        HttpUtil.getRequest("http://120.27.23.105/user/login?mobile=" + loginmobile + "&password=" + loginpassword,
                MobileBean.class, new HttpUtil.CallBack<MobileBean>() {
                    @Override
                    public void getdata(MobileBean mobileBean) {
//                        String mobile = mobileBean.getData().getMobile();
//                        String password = mobileBean.getData().getPassword();
//                        mobile.equals(loginmobile) && password.equals(loginpassword)

                        if (mobileBean.getMsg().equals("登录成功")) {
                            Toast.makeText(MainActivity.this, mobileBean.getMsg(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,Main2Activity.class));
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this,"请重新验证登录信息！！", Toast.LENGTH_SHORT).show();
                        }

                    }

                });
    }
}
