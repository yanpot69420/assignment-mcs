package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    static ArrayList<Users> userData = new ArrayList<>();
    static Users userLog = new Users();
    EditText userEmail, userPassword;
    String strEmail, strPassword;
    TextView tvRegister;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertView();
                Boolean check = validInput(strEmail, strPassword);
                if(!check){
                    Toast.makeText(LoginActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }

                else {
                    Integer checkLog = checkInput(userData);
                    if(checkLog==-1){
                        Toast.makeText(LoginActivity.this, "The email address or password is incorrect!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        userLog = new Users(userData.get(checkLog));
                        Intent next = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(next);
                        finish();
                    }
                }
            }
        });
    }

    void initView() {
        tvRegister = findViewById(R.id.tvRegister);
        btnLogin = findViewById(R.id.btnLogin);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
    }

    void convertView() {
        strEmail = userEmail.getText().toString();
        strPassword = userPassword.getText().toString();
    }

    Boolean validInput(String email, String password){
        boolean temp = true;
        if(email.length()==0){
            userEmail.requestFocus();
            userEmail.setError("Empty Field");
            temp = false;
        }
        if(password.length()==0){
            userPassword.requestFocus();
            userPassword.setError("Empty Field");
            temp = false;
        }
        return temp;
    }

    Integer checkInput(ArrayList<Users> userData) {
        if(userData!=null) {
            for (int i = 0; i < userData.size(); i++) {
                if (strEmail.equals(userData.get(i).userEmail) && strPassword.equals(userData.get(i).userPassword)) {
                    return i;
                }
            }
        }
        return -1;
    }
}