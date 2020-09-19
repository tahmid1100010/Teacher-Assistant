package com.example.teacherassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Attendence extends AppCompatActivity {
    private Button saveAttendenenceButtonId;
    private EditText idEditText,dateEditText,statusEditText;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);

        databaseReference = FirebaseDatabase.getInstance().getReference("Attendence");

        saveAttendenenceButtonId = findViewById(R.id.saveAttendenceButtonId);
        idEditText = findViewById(R.id.idEditTextId);
        dateEditText = findViewById(R.id.dateEditTextId);
        statusEditText = findViewById(R.id.statusEditTextId);

        saveAttendenenceButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAttendence();
            }
        });
    }

    public void saveAttendence(){
        String id = idEditText.getText().toString().trim();
        String date = dateEditText.getText().toString().trim();
        String status = statusEditText.getText().toString().trim();

        String key = databaseReference.push().getKey();

        AttendenceData attendenceData = new AttendenceData(id,date,status);

        databaseReference.child(key).setValue(attendenceData);
        Toast.makeText(getApplicationContext(),"Attendence Data is added",Toast.LENGTH_LONG).show();
    }
}