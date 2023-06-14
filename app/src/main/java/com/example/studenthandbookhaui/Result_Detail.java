package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studenthandbookhaui.database.model.ResultModel;

public class Result_Detail extends AppCompatActivity {
    TextView txtNameCourse, txtCourseCode, txtCourseLoadTheo, txtCourseLoadPrac, txtRegular, txtProgress, txtExam;
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_detail);
        getWidget();
        Intent intent = getIntent();
        ResultModel resultModel = (ResultModel) intent.getSerializableExtra("resultModel");
        setContent(resultModel);
        btnBack.setOnClickListener(v -> onBackPressed());
    }

    private void getWidget(){
        txtNameCourse = findViewById(R.id.txtNameCourse);
        txtCourseCode = findViewById(R.id.txtCourseCode);
        txtCourseLoadTheo = findViewById(R.id.txtCourseLoadTheo);
        txtCourseLoadPrac = findViewById(R.id.txtCourseLoadPrac);
        txtRegular = findViewById(R.id.txtRegular);
        txtProgress = findViewById(R.id.txtProgress);
        txtExam = findViewById(R.id.txtExam);
        btnBack = findViewById(R.id.btnBack);
    }

    private void setContent(ResultModel resultModel) {
        txtNameCourse.setText(resultModel.getNameCourse());
        txtCourseCode.setText(resultModel.getCourse_code());
        txtCourseLoadTheo.setText(resultModel.getCourse_load_theoretical() + "");
        txtCourseLoadPrac.setText(resultModel.getCourse_load_practical() + "");
        txtRegular.setText(resultModel.getRegularScore());
        txtProgress.setText(resultModel.getProgressScore());
        txtExam.setText(resultModel.getExamScore());
    }
}