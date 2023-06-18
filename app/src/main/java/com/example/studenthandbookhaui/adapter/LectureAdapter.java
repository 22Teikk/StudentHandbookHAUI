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
import com.example.studenthandbookhaui.database.model.LectureModel;

import java.util.ArrayList;

public class LectureAdapter extends ArrayAdapter<LectureModel> {

    private final LayoutInflater inflater;

    public LectureAdapter(@NonNull Context context, ArrayList<LectureModel> arrayList) {

        super(context, 0, arrayList);
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.lv_lecture, parent, false);
        TextView lectureName = view.findViewById(R.id.lectureName);

        lectureName.setText(getItem(position).getName());

        return view;
    }
}
