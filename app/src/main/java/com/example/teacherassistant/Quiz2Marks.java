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

public class Quiz2Marks extends AppCompatActivity {
    private Button saveDataButton;
    private EditText studentsId,obtainedMarks,totalMarks;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2_marks);
        this.setTitle("STORE QUIZ 2 MARKS");

        databaseReference = FirebaseDatabase.getInstance().getReference("Quiz2Marks");

        saveDataButton = findViewById(R.id.saveQuiz2MarksDataButtonId);
        studentsId = findViewById(R.id.storeQuiz2MarksEditTextId);
        obtainedMarks = findViewById(R.id.obtainedQuiz2MarksEditTextId);
        totalMarks = findViewById(R.id.totalQuiz2MarksEditTextId);

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuiz2Marks();
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

    public void saveQuiz2Marks(){
        String id = studentsId.getText().toString().trim();
        String obMarks = obtainedMarks.getText().toString().trim();
        String totMarks = totalMarks.getText().toString().trim();

        String key = databaseReference.push().getKey();

        QuizMarks quiz2 = new QuizMarks(id,obMarks,totMarks);

        databaseReference.child(key).setValue(quiz2);
        Toast.makeText(getApplicationContext(),"Quiz 2 Marks is added",Toast.LENGTH_LONG).show();

        studentsId.setText("");
        obtainedMarks.setText("");
        totalMarks.setText("");
    }
}