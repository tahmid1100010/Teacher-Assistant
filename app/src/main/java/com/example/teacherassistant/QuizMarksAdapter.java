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

public class QuizMarksAdapter extends ArrayAdapter<QuizMarks> {
    private Activity context;
    private List<QuizMarks> quizMarksList;

    public QuizMarksAdapter(Activity context, List<QuizMarks> quizMarksList) {
        super(context, R.layout.show_marks, quizMarksList);
        this.context = context;
        this.quizMarksList = quizMarksList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.show_marks,null,true);

        QuizMarks quizMarks = quizMarksList.get(position);

        TextView t1 = view.findViewById(R.id.idTextViewId);
        TextView t2 = view.findViewById(R.id.obtainedMarksTextViewId);
        TextView t3 = view.findViewById(R.id.totalMarksTextViewId);

        t1.setText("ID : "+quizMarks.getId());
        t2.setText("Obt. Marks : "+quizMarks.getObMarks());
        t3.setText("Total Marks : "+quizMarks.getTotMarks());

        return view;
    }
}
