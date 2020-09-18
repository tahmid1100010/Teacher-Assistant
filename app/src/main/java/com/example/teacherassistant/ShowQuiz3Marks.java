package com.example.teacherassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowQuiz3Marks extends AppCompatActivity {
    private ListView listView;
    DatabaseReference databaseReference;
    private List<QuizMarks> quizMarksList;
    private QuizMarksAdapter quizMarksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_quiz3_marks);

        databaseReference = FirebaseDatabase.getInstance().getReference("Quiz3Marks");

        quizMarksList = new ArrayList<>();
        quizMarksAdapter = new QuizMarksAdapter(ShowQuiz3Marks.this,quizMarksList);

        listView = findViewById(R.id.listViewId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot1 : snapshot.getChildren()){
                    QuizMarks quizMarks = dataSnapshot1.getValue(QuizMarks.class);
                    quizMarksList.add(quizMarks);
                }

                listView.setAdapter(quizMarksAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}