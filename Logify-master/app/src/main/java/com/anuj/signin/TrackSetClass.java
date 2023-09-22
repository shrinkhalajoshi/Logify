package com.anuj.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class TrackSetClass extends AppCompatActivity {

    TextView tvExerciseName;
    EditText etWeight, etReps;
    Button btnLog;
    String setStore;
    Spinner spinnerSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_set_class);

        tvExerciseName = (TextView) findViewById(R.id.textViewExerciseName);
        btnLog = (Button) findViewById(R.id.buttonLog);
        etWeight = (EditText) findViewById(R.id.editTextWeight);
        etReps = (EditText) findViewById(R.id.editTextReps);

        // FOR INTENT
        Intent intent= getIntent();
        String d = intent.getStringExtra("exercise name");

        tvExerciseName.setText(d);


        // FOR Set Selection
        spinnerSet = (Spinner) findViewById(R.id.spinnerSet);

        String[] set = getResources().getStringArray(R.array.set_array);

        ArrayAdapter<CharSequence> adapterSet = new ArrayAdapter(this, android.R.layout.simple_spinner_item, set);
        adapterSet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSet.setAdapter(adapterSet);

        spinnerSet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedSet = spinnerSet.getSelectedItem().toString();

                setStore = selectedSet;

                Toast.makeText(TrackSetClass.this, setStore, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // FOR DATE
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // GET DATA FORM EDITTEXT
                String weight = etWeight.getText().toString().trim();
                String reps = etReps.getText().toString().trim();

                //VALIDATION
                if(weight.isEmpty()){
                   etWeight.setError("invalid data");
                   etWeight.requestFocus();
                   return;
                }
                if(reps.isEmpty()){
                    etWeight.setError("invalid data");
                    etWeight.requestFocus();
                    return;
                }


                //FOR SUMODEADLIFT
                if(d.equals("Sumo Deadlift")){


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("sumoDeadlift").child(currentDate).child(setStore)
                            .child("weight").setValue(weight);


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("sumoDeadlift").child(currentDate).child(setStore)
                            .child("reps").setValue(reps).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(TrackSetClass.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                            });
                }

                // FOR BENCHPRESS

                if(d.equals("Bench Press")){


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("benchPress").child(currentDate).child(setStore).child("weight").setValue(weight);


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("benchPress").child(currentDate).child(setStore)
                            .child("reps").setValue(reps).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(TrackSetClass.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                            });;
                }


                if(d.equals("Squat")){

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("squat").child(currentDate).child(setStore).child("weight").setValue(weight);


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("squat").child(currentDate).child(setStore)
                            .child("reps").setValue(reps).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(TrackSetClass.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                            });
                }

                if(d.equals("Pull Up")){


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("pullup").child(currentDate).child(setStore).child("weight").setValue(weight);


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("pullup").child(currentDate).child(setStore)
                            .child("reps").setValue(reps).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(TrackSetClass.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                            });;
                }

                if(d.equals("Incline Press")){


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("inclinePress").child(currentDate).child(setStore).child("weight").setValue(weight);


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("inclinePress").child(currentDate).child(setStore)
                            .child("reps").setValue(reps).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(TrackSetClass.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                            });;
                }

                if(d.equals("Dumbbell Press")){


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("dumbbellPress").child(currentDate).child(setStore).child("weight").setValue(weight);


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("dumbbellPress").child(currentDate).child(setStore)
                            .child("reps").setValue(reps).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(TrackSetClass.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                            });;
                }

                if(d.equals("Lateral Raises")){


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("lateralRaises").child(currentDate).child(setStore).child("weight").setValue(weight);


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("exercise").child("lateralRaises").child(currentDate).child(setStore)
                            .child("reps").setValue(reps).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(TrackSetClass.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                            });;
                }

            }
        });
    }
}