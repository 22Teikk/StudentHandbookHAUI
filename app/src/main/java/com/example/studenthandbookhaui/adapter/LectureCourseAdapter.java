package com.example.studenthandbookhaui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.studenthandbookhaui.R;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.CourseModel;
import com.example.studenthandbookhaui.database.model.FinanceModel;
import com.example.studenthandbookhaui.database.repository.FinanceRepository;

import java.util.ArrayList;

public class LectureCourseAdapter extends ArrayAdapter<CourseModel> {
    private final LayoutInflater inflater;

    public LectureCourseAdapter(@NonNull Context context, ArrayList<CourseModel> arrayList) {

        super(context, 0, arrayList);
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.lv_lecture_course, parent, false);
        TextView courseName = view.findViewById(R.id.courseName);
        TextView classCode = view.findViewById(R.id.classCode);

        courseName.setText(getItem(position).getName());
        classCode.setText(getItem(position).getCourseClass().getClassCode());

        return view;
    }
}
