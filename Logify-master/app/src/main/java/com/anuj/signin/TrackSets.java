package com.anuj.signin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TrackSets extends AppCompatActivity {

    CardView sumoDeadlift,benchPress,squat,pullUp,inclinePress,dumbellPress,lateralRaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_sets);

        sumoDeadlift = findViewById(R.id.sumoDeadlift);
        benchPress = findViewById(R.id.benchPress);
        squat = findViewById(R.id.squat);
        pullUp = findViewById(R.id.pullup);
        inclinePress = findViewById(R.id.inclinedBenchPress);
        dumbellPress = findViewById(R.id.dumbellPress);
        lateralRaises = findViewById(R.id.lateralRaises);

        sumoDeadlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrackSets.this,TrackSetClass.class);
                intent.putExtra("exercise name","Sumo Deadlift");
                startActivity(intent);
            }
        });

        benchPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrackSets.this,TrackSetClass.class);
                intent.putExtra("exercise name","Bench Press");
                startActivity(intent);
            }
        });

        squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrackSets.this,TrackSetClass.class);
                intent.putExtra("exercise name","Squat");
                startActivity(intent);
            }
        });

        pullUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrackSets.this,TrackSetClass.class);
                intent.putExtra("exercise name","Pull Up");
                startActivity(intent);
            }
        });

        inclinePress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrackSets.this,TrackSetClass.class);
                intent.putExtra("exercise name","Incline Press");
                startActivity(intent);
            }
        });

        dumbellPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrackSets.this,TrackSetClass.class);
                intent.putExtra("exercise name","Dumbbell Press");
                startActivity(intent);
            }
        });

        lateralRaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrackSets.this,TrackSetClass.class);
                intent.putExtra("exercise name","Lateral Raises");
                startActivity(intent);
            }
        });


    }

}