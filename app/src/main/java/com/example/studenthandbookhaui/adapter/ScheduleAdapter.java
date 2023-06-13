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
import com.example.studenthandbookhaui.database.model.CourseModel;

import java.util.ArrayList;

public class ScheduleAdapter extends ArrayAdapter<CourseModel> {

    private LayoutInflater inflater;
    public ScheduleAdapter(@NonNull Context context, ArrayList<CourseModel> arrayList) {

        super(context, 0, arrayList);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.schedule_class_item, parent, false);

        CourseModel courseModelClass = getItem(position);

        TextView name = view.findViewById(R.id.schedule_name);
        TextView time = view.findViewById(R.id.schedule_time);
        TextView date = view.findViewById(R.id.schedule_date);
        TextView classInfo = view.findViewById(R.id.schedule_class_info);
        name.setText(getItem(position).getName());
        time.setText("1,2,3");
        date.setText("20/20/2022");
        classInfo.setText("Vu Thi Duong");

        return view;
    }
}
