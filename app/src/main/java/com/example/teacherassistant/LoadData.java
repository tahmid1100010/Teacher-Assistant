package com.example.teacherassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoadData extends AppCompatActivity implements View.OnClickListener {
    private Button quiz1MarksButton,quiz2MarksButton,quiz3MarksButton,backButton,studentListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);

        studentListButton = findViewById(R.id.loadStudentsListButtonId);
        quiz1MarksButton = findViewById(R.id.loadQuiz1MarksButtonId);
        quiz2MarksButton = findViewById(R.id.loadQuiz2MarksButtonId);
        quiz3MarksButton = findViewById(R.id.loadQuiz3MarksButtonId);
        backButton = findViewById(R.id.backButtonId);

        studentListButton.setOnClickListener(this);
        quiz1MarksButton.setOnClickListener(this);
        quiz2MarksButton.setOnClickListener(this);
        quiz3MarksButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.loadQuiz1MarksButtonId:
                Intent intent = new Intent(getApplicationContext(),ShowQuiz1Marks.class);
                startActivity(intent);
                break;
            case R.id.loadQuiz2MarksButtonId:
                Intent intent2 = new Intent(getApplicationContext(),ShowQuiz2Marks.class);
                startActivity(intent2);
                break;
            case R.id.loadQuiz3MarksButtonId:
                Intent intent3 = new Intent(getApplicationContext(),ShowQuiz3Marks.class);
                startActivity(intent3);
                break;
            case R.id.loadStudentsListButtonId:
                Intent intent4 = new Intent(getApplicationContext(),ShowStudentsData.class);
                startActivity(intent4);
                break;

            case R.id.backButtonId:
                Intent intent5 = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent5);
                break;

        }
    }
}