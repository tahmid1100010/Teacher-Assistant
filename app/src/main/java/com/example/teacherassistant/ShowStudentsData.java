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

public class ShowStudentsData extends AppCompatActivity {
    private ListView listView;
    DatabaseReference databaseReference;
    private List<Student> studentList;
    private ShowStudentListAdapter showStudentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students_data);

        databaseReference = FirebaseDatabase.getInstance().getReference("Students");

        studentList = new ArrayList<>();
        showStudentListAdapter = new ShowStudentListAdapter(ShowStudentsData.this,studentList);

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
                studentList.clear();
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren()){
                    Student student = dataSnapshot1.getValue(Student.class);
                    studentList.add(student);
                }

                listView.setAdapter(showStudentListAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}