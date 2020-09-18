package com.example.teacherassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Quiz1Marks extends AppCompatActivity {
    private Button saveDataButton;
    private EditText studentsId,obtainedMarks,totalMarks;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1_marks);
        this.setTitle("STORE QUIZ 1 MARKS");

        databaseReference = FirebaseDatabase.getInstance().getReference("Quiz1Marks");

        saveDataButton = findViewById(R.id.saveQuiz1MarksDataButtonId);
        studentsId = findViewById(R.id.storeQuiz1MarksEditTextId);
        obtainedMarks = findViewById(R.id.obtainedQuiz1MarksEditTextId);
        totalMarks = findViewById(R.id.totalQuiz1MarksEditTextId);

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuiz1Marks();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveQuiz1Marks(){
        String id = studentsId.getText().toString().trim();
        String obMarks = obtainedMarks.getText().toString().trim();
        String totMarks = totalMarks.getText().toString().trim();

        String key = databaseReference.push().getKey();

        QuizMarks quiz1 = new QuizMarks(id,obMarks,totMarks);

        databaseReference.child(key).setValue(quiz1);
        Toast.makeText(getApplicationContext(),"Quiz 1 Marks is added",Toast.LENGTH_LONG).show();

        studentsId.setText("");
        obtainedMarks.setText("");
        totalMarks.setText("");
    }
}