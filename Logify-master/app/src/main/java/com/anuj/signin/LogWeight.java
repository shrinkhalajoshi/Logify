package com.anuj.signin;

import  androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class LogWeight extends AppCompatActivity {

    TextView recentWeight;
    Button btnLog;
    EditText editTextWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_weight);

        editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        btnLog = (Button) findViewById(R.id.btnSetWeight);
        recentWeight = (TextView) findViewById(R.id.textViewRecentWeight);


        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weight = editTextWeight.getText().toString().trim();

                if(weight.isEmpty()){
                    editTextWeight.setError("Invalid Data");
                    editTextWeight.requestFocus();
                    return;
                }


                Calendar calendar = Calendar.getInstance();
                String currentDate = DateFormat.getDateInstance().format(calendar.getTime());


                FirebaseDatabase.getInstance().getReference("Users")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("weight").child(currentDate)
                        .setValue(weight).addOnCompleteListener(new OnCompleteListener<Void>()

                        {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(LogWeight.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(LogWeight.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



            }
        });


    }

}