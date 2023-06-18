package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.studenthandbookhaui.R;
import com.example.studenthandbookhaui.adapter.LectureAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.LectureModel;
import com.example.studenthandbookhaui.database.repository.LectureRepository;

import java.util.ArrayList;

public class Lecture extends AppCompatActivity {
    DatabaseHelper dbHelper;
    LectureRepository lectureRepository;
    long courseId;
    ImageView noDataPlaceholder;
    ListView lectureList;
    LectureAdapter adapter;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        dbHelper = new DatabaseHelper(this);
        lectureRepository = new LectureRepository(dbHelper);

        courseId = getIntent().getLongExtra("course_id", -1);

        lectureList = findViewById(R.id.lvLecture);
        noDataPlaceholder = findViewById(R.id.noDataPlaceholder);
        btnBack = findViewById(R.id.btnBack);

        ArrayList<LectureModel> arrayList = lectureRepository.getLectureByCourseId(courseId);

        if (arrayList.size() == 0) {
            noDataPlaceholder.setVisibility(View.VISIBLE);
        } else {
            noDataPlaceholder.setVisibility(View.GONE);
            adapter = new LectureAdapter(this, arrayList);
            lectureList.setAdapter(adapter);
            lectureList.setOnItemClickListener((parent, view, position, id) -> {
                Intent intent = new Intent(Lecture.this, Lesson.class);
                intent.putExtra("lecture_id", arrayList.get(position).getId());
                intent.putExtra("lecture_name", arrayList.get(position).getName());
                startActivity(intent);
            });
        }

        btnBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}