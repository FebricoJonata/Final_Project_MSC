package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email_edt, password_edt;
    Button btn_login;
    FirebaseAuth mAuth;
    TextView to_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        to_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(email_edt.getText());
                password = String.valueOf(password_edt.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(LoginActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Authentication Success!",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(LoginActivity.this, "Authentication Failed!",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    void init(){
        mAuth = FirebaseAuth.getInstance();
        email_edt = findViewById(R.id.email);
        password_edt = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        to_regis = findViewById(R.id.to_regis);
    }
}