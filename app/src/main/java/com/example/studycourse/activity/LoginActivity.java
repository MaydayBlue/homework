package com.example.studycourse.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studycourse.MainActivity;
import com.example.studycourse.R;
import com.example.studycourse.Util.Constants;
import com.example.studycourse.Util.RegexUtil;
import com.example.studycourse.Util.SharedPreferencesUtil;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et_username;
    private EditText et_password;
    private Button bt_login;
    private SharedPreferencesUtil spu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        bt_login=findViewById(R.id.bt_login);

        bt_login.setOnClickListener(this);

        spu=SharedPreferencesUtil.getInstance(getApplicationContext());
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_login:
                login();

                break;
        }
    }

    private void login(){
        String user=et_username.getText().toString().trim();
        //判断是否输入了邮箱
        if(TextUtils.isEmpty(user)){
            Toast.makeText(this,R.string.email_hint,Toast.LENGTH_SHORT).show();
            return;
        }
        //判断邮箱格式是否正确
        if(!RegexUtil.isEmail(user)){
            Toast.makeText(this,R.string.error_password_format,Toast.LENGTH_SHORT).show();
            return;
        }

        //判断是否输入了密码
        String pass=et_password.getText().toString().trim();
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,R.string.password_hint,Toast.LENGTH_SHORT).show();
            return;
        }
        //判断密码长度
        if(pass.length()<6||pass.length()>15){
            Toast.makeText(this,R.string.error_password_length,Toast.LENGTH_SHORT).show();
            return;
        }

        if(Constants.EMAIL.equals(user)&&Constants.PASSWORD.equals(pass)){
            spu.setLogin(true);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            finish();
        }else{
            Toast.makeText(this,R.string.error_email_password,Toast.LENGTH_SHORT).show();
        }
    }
}
