package com.anuj.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class login extends AppCompatActivity implements View.OnClickListener {

    private TextView register;
    private EditText etEmail, etPassword;
    private ProgressBar mainProgressBar;
    private Button btnSignin;
    private TextView forgotPassword;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnSignin.setOnClickListener(this);
        btnSignin.requestFocus();

        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this);


        mainProgressBar = (ProgressBar) findViewById(R.id.mainProgressBar);

        mAuth = FirebaseAuth.getInstance();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                startActivity(new Intent(login.this, user_register_activity.class));
                break;

            case R.id.btnSignin:
                userLogin();
                break;

            case R.id.forgotPassword:
                startActivity(new Intent(login.this, ForgotPassword.class));
                break;
        }

    }

    private void userLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();


        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Email Invalid ");
            etEmail.requestFocus();
            return;

        }

        if (password.isEmpty()) {
            etPassword.setError("Password is Required");
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etPassword.setError("Password length  invalid");
            etPassword.requestFocus();
            return;
        }
        mainProgressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if (user.isEmailVerified()) {

                        Toast.makeText(getBaseContext(), "Logged In Succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this, MainActivity.class));

                        mainProgressBar.setVisibility(View.GONE);
                        finish();
                    } else {
                        user.sendEmailVerification();
                        Toast.makeText(getBaseContext(), "Check your email to verify account", Toast.LENGTH_LONG).show();
                        mainProgressBar.setVisibility(View.GONE);

                    }


                } else {
                    Toast.makeText(login.this, "Wrong Credentials", Toast.LENGTH_LONG).show();
                    mainProgressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
