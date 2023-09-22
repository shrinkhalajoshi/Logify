package com.anuj.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PullActivity extends AppCompatActivity {

    ListView listView;
    String[] pullExercise = {"Pull UP", " Lats PullDown", " Delts", "Biceps Curl", "Forearm"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);


        ListView listview = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,pullExercise);
        listview.setAdapter(adp);
    }
}