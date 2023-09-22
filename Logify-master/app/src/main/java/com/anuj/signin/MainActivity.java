package com.anuj.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    private CardView trackSet, logWeight, progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trackSet = (CardView) findViewById(R.id.trackSet);
        logWeight =(CardView)  findViewById(R.id.logWeight);
        progress = (CardView) findViewById(R.id.progress);

        trackSet.setOnClickListener(this);
        logWeight.setOnClickListener(this);
        progress.setOnClickListener(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID =user.getUid();

        final TextView welcomeHeading = (TextView) findViewById(R.id.welcomeHeading);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile != null){
                    String firstName = userProfile.firstName;

                    welcomeHeading.setText(firstName + "'s" + " Board");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.logWeight:
                startActivity(new Intent(MainActivity.this, LogWeight.class));
                break;

            case R.id.trackSet:
                startActivity(new Intent(MainActivity.this,TrackSets.class));
                break;

            case R.id.progress:
                startActivity(new Intent(MainActivity.this,Progress.class));

        }
    }
}