package com.example.teacherassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addStudents,takeAttendence,storeData,loadData,logOut;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setTitle("HOME");

        mAuth = FirebaseAuth.getInstance();

        addStudents = findViewById(R.id.addStudentsButtonId);
        takeAttendence = findViewById(R.id.takeAttendenceButtonId);
        storeData = findViewById(R.id.storeDataButtonId);
        loadData = findViewById(R.id.loadDataButtonId);
        logOut = findViewById(R.id.logOutButtonId);

        addStudents.setOnClickListener(this);
        takeAttendence.setOnClickListener(this);
        storeData.setOnClickListener(this);
        loadData.setOnClickListener(this);
        logOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addStudentsButtonId:
                Intent intent = new Intent(getApplicationContext(),AddStudents.class);
                startActivity(intent);
                break;
            case R.id.storeDataButtonId:
                Intent intent2 = new Intent(getApplicationContext(),StoreData.class);
                startActivity(intent2);
                break;
            case R.id.loadDataButtonId:
                Intent intent3 = new Intent(getApplicationContext(),LoadData.class);
                startActivity(intent3);
                break;
            case R.id.logOutButtonId:
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent4 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent4);
                Toast.makeText(getApplicationContext(),"Log Out Successful",Toast.LENGTH_LONG).show();
                break;
        }
    }
}