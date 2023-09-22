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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class user_register_activity extends AppCompatActivity implements View.OnClickListener {

    private TextView textHeading,registerUser;
    private EditText etFirstName, etLastName, etEmailAddress, etPassword;
    private ProgressBar progressBar;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        mAuth = FirebaseAuth.getInstance();

        registerUser = (Button) findViewById(R.id.btnRegisterUser);
        registerUser.setOnClickListener(this);

        textHeading = (TextView) findViewById(R.id.textHeading);
        textHeading.setOnClickListener(this);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etEmailAddress = (EditText) findViewById(R.id.etEmailAddress);
        etPassword = (EditText) findViewById(R.id.etPassword);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textHeading:
                startActivity(new Intent(user_register_activity.this,MainActivity.class));
                break;

            case R.id.btnRegisterUser:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String emailAddress = etEmailAddress.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (firstName.isEmpty()) {
            etFirstName.setError("First Name is required");
            etFirstName.requestFocus();
            return;
        }
        if (lastName.isEmpty()) {
            etLastName.setError("Last Name is required");
            etLastName.requestFocus();
            return;
        }
        if (emailAddress.isEmpty()) {
            etEmailAddress.setError("Email is required");
            etEmailAddress.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            etEmailAddress.setError("Please use valid email!");
            etEmailAddress.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            etPassword.setError("Minimum character should be 6");
            etPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(emailAddress, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            User user = new User(firstName, lastName, emailAddress);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast toast = Toast.makeText(getApplicationContext(),
                                                "Account successfully created",
                                                Toast.LENGTH_SHORT);

                                        toast.show();
                                        progressBar.setVisibility(View.GONE);

                                    } else {
                                        Toast.makeText(user_register_activity.this, "Failed to register! Try Again", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(user_register_activity.this, "Failed to register! Try Again!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}