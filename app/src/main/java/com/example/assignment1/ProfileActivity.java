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

public class ProfileActivity extends AppCompatActivity {
    TextView tvEmail, tvUser, tvPhone;
    Button btnEdit, btnDelete, btnLogout;
    EditText etUsername, etTest;
    String updateUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initView();
        initValue();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvUser.setVisibility(View.INVISIBLE);
                etTest.requestFocus();
                btnEdit.setText("SAVE");
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateUser = etTest.getText().toString();
                        boolean check = updUsername(updateUser);
                        if(check){
                            LoginActivity.userLog.userName = updateUser;
                            for (int i = 0; i < LoginActivity.userData.size(); i++) {
                                if(LoginActivity.userLog.userEmail.equals(LoginActivity.userData.get(i).userEmail)){
                                    LoginActivity.userData.get(i).userName = updateUser;
                                    break;
                                }
                            }
                            etTest.setVisibility(View.INVISIBLE);
                            Toast.makeText(ProfileActivity.this, "Username changed", Toast.LENGTH_SHORT).show();
                            Intent refresh = new Intent(ProfileActivity.this, ProfileActivity.class);
                            startActivity(refresh);
                            finish();
                        }

                    }
                });

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delAccount(LoginActivity.userData, LoginActivity.userLog.userEmail);
                Toast.makeText(ProfileActivity.this, "Account deleted", Toast.LENGTH_SHORT).show();
                Intent logout = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(logout);
                finish();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(logout);
                finish();
            }
        });

    }

    void initView() {
        tvEmail = findViewById(R.id.tvEmail);
        tvUser = findViewById(R.id.tvUser);
        tvPhone = findViewById(R.id.tvPhone);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        btnLogout = findViewById(R.id.btnLogout);
        etUsername = findViewById(R.id.etUsername);
        etTest = findViewById(R.id.etTest);
    }

    void initValue() {
        tvEmail.setText(LoginActivity.userLog.userEmail);
        tvUser.setText(LoginActivity.userLog.userName);
        tvPhone.setText(LoginActivity.userLog.phoneNumber);
    }

    Boolean updUsername(String userName){
        if(userName.length()==0){
            Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show();
            return false;
        }
        if((userName.length()<3)||(userName.length()>20)){
            Toast.makeText(this, "Username must be between 3 - 20 character", Toast.LENGTH_SHORT).show();

            return false;
        }
        for (int i = 0; i < LoginActivity.userData.size(); i++) {
            if(LoginActivity.userData.get(i).userName.equals(userName)){
                Toast.makeText(this, "Username already registered", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    void delAccount(ArrayList<Users> userData, String email){
        for (int i = 0; i < userData.size(); i++) {
            if(userData.get(i).userEmail.equals(email)){
                userData.remove(i);
                break;
            }
        }
    }
}