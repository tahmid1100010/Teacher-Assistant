package com.example.teacherassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StoreData extends AppCompatActivity implements View.OnClickListener {
    private Button quiz1Marks,quiz2Marks,quiz3Marks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_data);

        quiz1Marks = findViewById(R.id.quiz1MarksButtonId);
        quiz2Marks = findViewById(R.id.quiz2MarksButtonId);
        quiz3Marks = findViewById(R.id.quiz3MarksButtonId);

        quiz1Marks.setOnClickListener(this);
        quiz2Marks.setOnClickListener(this);
        quiz3Marks.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.quiz1MarksButtonId:
                Intent intent = new Intent(getApplicationContext(),Quiz1Marks.class);
                startActivity(intent);
                break;
            case R.id.quiz2MarksButtonId:
                Intent intent2 = new Intent(getApplicationContext(),Quiz2Marks.class);
                startActivity(intent2);
                break;
            case R.id.quiz3MarksButtonId:
                Intent intent3 = new Intent(getApplicationContext(),Quiz3Marks.class);
                startActivity(intent3);
                break;
        }
    }
}