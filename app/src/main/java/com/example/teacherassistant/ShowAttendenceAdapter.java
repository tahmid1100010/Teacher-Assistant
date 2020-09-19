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

public class ShowAttendenceAdapter extends ArrayAdapter<AttendenceData> {
    private Activity context;
    private List<AttendenceData> attendenceDataList;

    public ShowAttendenceAdapter(Activity context,List<AttendenceData> attendenceDataList) {
        super(context, R.layout.show_attendence,attendenceDataList);
        this.context = context;
        this.attendenceDataList = attendenceDataList;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.show_attendence,null,true);

        AttendenceData attendenceData = attendenceDataList.get(position);

        TextView t1 = view.findViewById(R.id.idTextViewId);
        TextView t2 = view.findViewById(R.id.dateTextViewId);
        TextView t3 = view.findViewById(R.id.statusTextViewId);

        t1.setText("ID : "+attendenceData.getId());
        t2.setText("Date : "+attendenceData.getDate());
        t3.setText("Status: "+attendenceData.getStatus());

        return view;
    }
}
