package com.example.teacherassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudents extends AppCompatActivity implements View.OnClickListener {
    private Button saveDataButton,backButton;
    private EditText addFullName,addDepartment,addId,addSemester,addMobileNo,addYear;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students);
        this.setTitle("STORE STUDENT DATA");

        databaseReference = FirebaseDatabase.getInstance().getReference("Students");

        saveDataButton = findViewById(R.id.saveDataButtonId);
        backButton = findViewById(R.id.backButtonId);
        addFullName = findViewById(R.id.addFullNameEditTextId);
        addDepartment = findViewById(R.id.addDepartmentEditTextId);
        addId = findViewById(R.id.addIdEditTextId);
        addSemester = findViewById(R.id.addSemesterEditTextId);
        addYear = findViewById(R.id.addYearEditTextId);
        addMobileNo = findViewById(R.id.addMobileNoEditTextId);

        saveDataButton.setOnClickListener(this);
        backButton.setOnClickListener(this);

    }

    public void saveData(){
        String name = addFullName.getText().toString().trim();
        String department = addDepartment.getText().toString().trim();
        String id = addId.getText().toString().trim();
        String year = addYear.getText().toString().trim();
        String semester = addSemester.getText().toString().trim();
        String mobileNo = addMobileNo.getText().toString().trim();

        String key = databaseReference.push().getKey();

        Student student = new Student(name,department,id,year,semester,mobileNo);

        databaseReference.child(key).setValue(student);
        Toast.makeText(getApplicationContext(),"Student Info is Added",Toast.LENGTH_LONG).show();

        addFullName.setText("");
        addDepartment.setText("");
        addId.setText("");
        addYear.setText("");
        addSemester.setText("");
        addMobileNo.setText("");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.saveDataButtonId:
                saveData();
                break;
            case R.id.backButtonId:
                Intent intent2 = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent2);
                break;
        }
    }
}