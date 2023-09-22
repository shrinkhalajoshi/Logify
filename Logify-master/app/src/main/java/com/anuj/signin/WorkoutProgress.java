package com.anuj.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WorkoutProgress extends AppCompatActivity {

    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_progress);

        listView = findViewById(R.id.listView);


        String exerciseTitle,exercise;
        // TOGET DATA FROM OTHER ACTIVITY
        Intent intent  = getIntent();
        exerciseTitle = intent.getStringExtra("exercise name");
        exercise = intent.getStringExtra("exercise");

        TextView text = findViewById(R.id.text);

        text.setText(exerciseTitle);




        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item,list);
        listView.setAdapter(adapter);




        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getUid()).child("exercise").child(exercise);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for (DataSnapshot dataSnapshotsnapshot : snapshot.getChildren()){



                    list.add( dataSnapshotsnapshot.getKey());


                    String name = dataSnapshotsnapshot.getKey();

                    //dataSnapshotsnapshot.getValue().toString()




                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}