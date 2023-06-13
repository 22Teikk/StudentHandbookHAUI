package com.example.studenthandbookhaui.adapter;

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
import com.example.studenthandbookhaui.database.model.ClassModel;
import com.example.studenthandbookhaui.database.model.CourseModel;
import com.example.studenthandbookhaui.database.repository.CourseRepository;

import java.util.ArrayList;

public class ScheduleAdapter extends ArrayAdapter<ClassModel> {

    DatabaseHelper dbHelper;
    CourseRepository courseRepository;
    private LayoutInflater inflater;

    public ScheduleAdapter(@NonNull Context context, ArrayList<ClassModel> arrayList) {

        super(context, 0, arrayList);
        inflater = LayoutInflater.from(context);
        dbHelper = new DatabaseHelper(context);
        courseRepository = new CourseRepository(dbHelper);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.schedule_class_item, parent, false);

        ClassModel classModel = getItem(position);

        CourseModel courseModel = courseRepository.findById(Long.valueOf(classModel.getCourseId()));

        TextView name = view.findViewById(R.id.schedule_name);
        TextView time = view.findViewById(R.id.schedule_time);
        TextView date = view.findViewById(R.id.schedule_date);
        TextView classInfo = view.findViewById(R.id.schedule_class_info);
        name.setText(courseModel.getName());
        time.setText("Lesson: " + classModel.getTimeInDay());
        date.setText("");
        classInfo.setText(classModel.getRoom());

        return view;
    }
}
