package com.example.studenthandbookhaui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.example.studenthandbookhaui.database.model.ResultModel;
import com.example.studenthandbookhaui.database.repository.CourseRepository;
import com.example.studenthandbookhaui.database.repository.ResultRepository;

import java.util.ArrayList;

public class CourseAdapter extends ArrayAdapter<CourseModel> {
    DatabaseHelper dbHelper;
    CourseRepository courseRepository;
    private LayoutInflater inflater;

    public CourseAdapter(@NonNull Context context, ArrayList<CourseModel> arrayList) {

        super(context, 0, arrayList);
        inflater = LayoutInflater.from(context);
        dbHelper = new DatabaseHelper(context);
        courseRepository = new CourseRepository(dbHelper);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.lv_courses, parent, false);

        CourseModel courseModel = getItem(position);

        TextView name = view.findViewById(R.id.txtCourseName);
        TextView code = view.findViewById(R.id.txtCourseCode);
        TextView load = view.findViewById(R.id.txtCourseLoad);

        name.setText(courseModel.getName());
        code.setText(courseModel.getCourseCode());
        load.setText(String.format("%d.00\t%d.00", courseModel.getCourseLoadTheoretical(), courseModel.getCourseLoadPractical()));
        return view;
    }
}
