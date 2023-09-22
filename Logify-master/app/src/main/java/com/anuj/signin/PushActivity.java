package com.anuj.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PushActivity extends AppCompatActivity {

    ListView listview;

    String[] exercise = {"Bench Press", "Dumbbell Shoulder Press", " Cable Fly ", " lateral Raises" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);


            ListView listview = (ListView) findViewById(R.id.lv);
            ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,exercise);
            listview.setAdapter(adp);

    }

}