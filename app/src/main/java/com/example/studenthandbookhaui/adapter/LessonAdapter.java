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
import com.example.studenthandbookhaui.database.model.LessonModel;

import java.util.ArrayList;

public class LessonAdapter extends ArrayAdapter<LessonModel> {

    private final LayoutInflater inflater;

    public LessonAdapter(@NonNull Context context, ArrayList<LessonModel> arrayList) {

        super(context, 0, arrayList);
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.lv_lesson, parent, false);
        TextView lessonName = view.findViewById(R.id.lessonName);

        String type;
        String name;

        if (getItem(position).getLessonType() == LessonModel.LessonType.ARTICLE) {
            type = "Article";
            name = getItem(position).getLessonArticle().getName();
        } else {
            type = "Quiz";
            name = getItem(position).getLessonQuiz().getName();
        }

        lessonName.setText(String.format("%s - %s", type, name));

        return view;
    }
}
