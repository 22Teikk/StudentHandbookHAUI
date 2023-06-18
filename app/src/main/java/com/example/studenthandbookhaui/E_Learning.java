package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.studenthandbookhaui.adapter.LectureCourseAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.CourseModel;
import com.example.studenthandbookhaui.database.repository.UserRepository;

import java.util.ArrayList;

public class E_Learning extends AppCompatActivity {
    DatabaseHelper dbHelper;
    UserRepository userRepository;
    ImageView btnBack;
    ImageView noDataPlaceholder;
    ArrayList<CourseModel> courseList;
    ListView lectureCourseListView;
    LectureCourseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elearning);
        dbHelper = new DatabaseHelper(this);
        userRepository = new UserRepository(dbHelper);
        String userId = ((UserID) getApplication()).userId;

        btnBack = findViewById(R.id.btnBack);
        lectureCourseListView = findViewById(R.id.lvLectureCourses);
        noDataPlaceholder = findViewById(R.id.noDataPlaceholder);

        courseList = userRepository.getLectureCourseByStudentCode(userId);
        if (courseList.size() == 0) {
            noDataPlaceholder.setVisibility(View.VISIBLE);
        } else {
            noDataPlaceholder.setVisibility(View.GONE);
            adapter = new LectureCourseAdapter(this, courseList);
            lectureCourseListView.setAdapter(adapter);
            lectureCourseListView.setOnItemClickListener((parent, view, position, id)->{
                CourseModel courseModel = courseList.get(position);
                Intent intent = new Intent(E_Learning.this, Lecture.class);
                intent.putExtra("course_id", courseModel.getId());
                startActivity(intent);
            });
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}