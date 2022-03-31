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
import java.util.Random;

public class RegisterActivity extends AppCompatActivity {
    String strID,strEmail, strUsername, strPhone, strPassword;
    EditText etEmail, etUsername, etPhone, etPassword;
    Button btnRegister;
    TextView tvLogin;
    static Users dataReg = new Users();
    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertView();
                Boolean check = validInput(LoginActivity.userData,strEmail, strUsername, strPhone, strPassword);
                if(!check){
                    Toast.makeText(RegisterActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }
                else {
                    dataReg = new Users(strID, strEmail, strUsername, strPhone, strPassword);
                    LoginActivity.userData.add(dataReg);
                    Intent next = new Intent(RegisterActivity.this, LoginActivity.class);
                    Toast.makeText(RegisterActivity.this, "Create account success", Toast.LENGTH_SHORT).show();
                    startActivity(next);
                    finish();
                }
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(objIntent);
            }
        });
    }

    void convertView(){
        strEmail = etEmail.getText().toString();
        strUsername = etUsername.getText().toString();
        strPhone = etPhone.getText().toString();
        strPassword = etPassword.getText().toString();
        strID = "USER" + rand.nextInt(9) + "" + rand.nextInt(9)+ "" + rand.nextInt(9);
    }

    void initView(){
        tvLogin = findViewById(R.id.tvLogin);
        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
    }

    public Boolean validInput(ArrayList<Users> userData, String email, String username, String phone, String password){
        boolean temp = true;
        for (int i = 0; i < userData.size(); i++) {
            if(userData.get(i).userEmail.equals(email)){
                etEmail.requestFocus();
                etEmail.setError("Email already registered");
                temp = false;
                break;
            }
        }
        if(!email.endsWith(".com")){
            etEmail.requestFocus();
            etEmail.setError("Invalid email address");
            temp =  false;
        }
        if(email.length()==0){

            etEmail.setError("Empty Field");
            temp = false;
        }
        for (int i = 0; i < userData.size(); i++) {
            if(userData.get(i).userName.equals(username)){
                etUsername.requestFocus();
                etUsername.setError("Username already registered");
                temp = false;
                break;
            }
        }

        if((username.length()<3)||(username.length()>20)){
            etUsername.requestFocus();
            etUsername.setError("Username must be between 3 - 20 character");
            temp = false;
        }
        if(username.length()==0){
            etUsername.requestFocus();
            etUsername.setError("Empty Field");
            temp = false;
        }
        if(phone.length()==0){
            etPhone.requestFocus();
            etPhone.setError("Empty Field");
            temp = false;
        }
        if(password.length()==0){
            etPassword.requestFocus();
            etPassword.setError("Empty Field");
            temp = false;
        }
        return temp;
    }
}
