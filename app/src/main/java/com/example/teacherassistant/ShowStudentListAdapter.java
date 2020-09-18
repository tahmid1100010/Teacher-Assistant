package com.example.teacherassistant;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ShowStudentListAdapter extends ArrayAdapter<Student> {
    private Activity context;
    private List<Student> studentList;

    public ShowStudentListAdapter(Activity context,List<Student> studentList) {
        super(context,R.layout.show_student_list,studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.show_student_list,null,true);

        Student student = studentList.get(position);

        TextView t1 = view.findViewById(R.id.nameTextViewId);
        TextView t2 = view.findViewById(R.id.deptTextViewId);
        TextView t3 = view.findViewById(R.id.idTextViewId);
        TextView t4 = view.findViewById(R.id.yearTextViewId);
        TextView t5 = view.findViewById(R.id.semesterTextViewId);

        t1.setText("Name : "+student.getName());
        t2.setText("Department : "+student.getDepartment());
        t3.setText("ID : "+student.getId());
        t4.setText("Year : "+student.getYear());
        t5.setText("Semester : "+student.getSemester());

        return view;
    }
}
