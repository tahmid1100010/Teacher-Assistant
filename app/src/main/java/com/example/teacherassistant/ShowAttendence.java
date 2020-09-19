package com.example.teacherassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowAttendence extends AppCompatActivity {
    private ListView listView;
    DatabaseReference databaseReference;
    private List<AttendenceData> attendenceDataList;
    private ShowAttendenceAdapter attendenceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_attendence);

        databaseReference = FirebaseDatabase.getInstance().getReference("Attendence");
        attendenceDataList = new ArrayList<>();
        attendenceAdapter = new ShowAttendenceAdapter(ShowAttendence.this,attendenceDataList);

        listView = findViewById(R.id.listViewId);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                attendenceDataList.clear();
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren()){
                    AttendenceData attendenceData = dataSnapshot1.getValue(AttendenceData.class);
                    attendenceDataList.add(attendenceData);
                }
                listView.setAdapter(attendenceAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}