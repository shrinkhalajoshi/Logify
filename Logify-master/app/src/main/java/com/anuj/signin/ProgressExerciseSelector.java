package com.anuj.signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProgressExerciseSelector extends AppCompatActivity {

    CardView sumoDeadlift, benchPress,squat,pullUp,inclinePress,dumbbellPress,lateralRaises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_exercise_selector);

        sumoDeadlift = (CardView) findViewById(R.id.sumoDeadlift);
        benchPress = (CardView) findViewById(R.id.benchPress);
        squat = (CardView) findViewById(R.id.squat);
        pullUp = (CardView) findViewById(R.id.pullup);
        inclinePress = (CardView) findViewById(R.id.inclinedBenchPress);
        dumbbellPress = (CardView) findViewById(R.id.dumbellPress);
        lateralRaises = (CardView) findViewById(R.id.lateralRaises);

        sumoDeadlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgressExerciseSelector.this,WorkoutProgress.class);
                intent.putExtra("exercise name","Sumo Deadlift");
                intent.putExtra("exercise","sumoDeadlift");
                startActivity(intent);
            }
        });

        benchPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgressExerciseSelector.this,WorkoutProgress.class);
                intent.putExtra("exercise name","Bench Press");
                intent.putExtra("exercise","benchPress");
                startActivity(intent);
            }
        });

        squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgressExerciseSelector.this,WorkoutProgress.class);
                intent.putExtra("exercise name","Squat");
                intent.putExtra("exercise", "squat");
                startActivity(intent);
            }
        });

        pullUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgressExerciseSelector.this,WorkoutProgress.class);
                intent.putExtra("exercise name","Pull Up");
                intent.putExtra("exercise","pullup");
                startActivity(intent);
            }
        });

        inclinePress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgressExerciseSelector.this,WorkoutProgress.class);
                intent.putExtra("exercise name","Incline Press");
                intent.putExtra("exercise","inclinePress");
                startActivity(intent);
            }
        });

        dumbbellPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgressExerciseSelector.this,WorkoutProgress.class);
                intent.putExtra("exercise name","Dumbbell Press");
                intent.putExtra("exercise","dumbbellPress");
                startActivity(intent);
            }
        });

        lateralRaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgressExerciseSelector.this,WorkoutProgress.class);
                intent.putExtra("exercise name","Lateral Raises");
                intent.putExtra("exercise","lateralRaises");
                startActivity(intent);
            }
        });


    }
}