package com.anuj.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.badge.BadgeUtils;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private EditText etForgotPassword;
    private Button btnReset;
    private ProgressBar progressBar;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etForgotPassword = (EditText) findViewById(R.id.etForgotPassword);
        btnReset = (Button) findViewById(R.id.btnReset);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }
    private void resetPassword(){
        String email = etForgotPassword.getText().toString().trim();

        if(email.isEmpty()){
            etForgotPassword.setError("Email is required");
            etForgotPassword.requestFocus();
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etForgotPassword.setError("Please provide valid email");
            etForgotPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {


                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "Check You email to reset password", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }

                else{
                    Toast.makeText(ForgotPassword.this, "Sorry! Try again", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}