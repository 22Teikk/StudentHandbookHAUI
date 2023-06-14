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
import com.example.studenthandbookhaui.database.model.NotificationModel;
import com.example.studenthandbookhaui.database.repository.CourseRepository;

import java.util.ArrayList;

public class NotificationAdapter extends ArrayAdapter<NotificationModel> {
    DatabaseHelper dbHelper;
    CourseRepository courseRepository;
    private LayoutInflater inflater;

    public NotificationAdapter(@NonNull Context context, ArrayList<NotificationModel> arrayList) {
        super(context, 0, arrayList);
        inflater = LayoutInflater.from(context);
        dbHelper = new DatabaseHelper(context);
        courseRepository = new CourseRepository(dbHelper);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.lv_notification, parent, false);

        NotificationModel notificationModel = getItem(position);

        TextView type = view.findViewById(R.id.txtType);
        TextView time = view.findViewById(R.id.txtTime);
        TextView content = view.findViewById(R.id.txtContent);
        type.setText(notificationModel.getType());
        time.setText(notificationModel.getTime());
        content.setText(notificationModel.getContent());

        return view;
    }
}
