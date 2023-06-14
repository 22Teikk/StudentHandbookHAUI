package com.example.studenthandbookhaui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.studenthandbookhaui.R;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ClassModel;
import com.example.studenthandbookhaui.database.model.CourseModel;
import com.example.studenthandbookhaui.database.model.ResultModel;
import com.example.studenthandbookhaui.database.repository.CourseRepository;
import com.example.studenthandbookhaui.database.repository.ResultRepository;

import java.util.ArrayList;

public class ResultAdapter extends ArrayAdapter<ResultModel> {
    DatabaseHelper dbHelper;
    ResultRepository resultRepository;
    private LayoutInflater inflater;

    public ResultAdapter(@NonNull Context context, ArrayList<ResultModel> arrayList) {

        super(context, 0, arrayList);
        inflater = LayoutInflater.from(context);
        dbHelper = new DatabaseHelper(context);
        resultRepository = new ResultRepository(dbHelper);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.lv_result, parent, false);

        ResultModel resultModel = getItem(position);

        TextView name = view.findViewById(R.id.txtResultName);
        TextView result = view.findViewById(R.id.txtResult);

        name.setText(resultModel.getNameCourse());
        result.setText(resultModel.getResult());
        return view;
    }
}
