package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.studenthandbookhaui.adapter.CourseAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.CourseModel;
import com.example.studenthandbookhaui.database.repository.CourseRepository;

import java.util.ArrayList;

public class Course extends AppCompatActivity {
    ArrayList<CourseModel> courseList, listRequired, listOptional;
    DatabaseHelper dbHelper;
    CourseRepository courseRepository;
    ImageView btnBack;
    ListView lvRequiredCourse, lvOptionalCourse;
    CourseAdapter requiredAdapter, optionalAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        getWidget();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void getWidget(){
        btnBack = findViewById(R.id.btnBack);
        lvRequiredCourse = findViewById(R.id.lvRequiredCourse);
        lvOptionalCourse = findViewById(R.id.lvOptionalCourse);
        listRequired = new ArrayList<>();
        listOptional = new ArrayList<>();
        dbHelper = new DatabaseHelper(this);
        courseRepository = new CourseRepository(dbHelper);
        courseList = new ArrayList<>();
        courseList = courseRepository.find();
        for (int i = 0; i < courseList.size(); i++) {
            if (i % 2 == 0) {
                listRequired.add(courseList.get(i));
            }else
                listOptional.add(courseList.get(i));
        }
        requiredAdapter = new CourseAdapter(this,listRequired);
        optionalAdapter = new CourseAdapter(this,listOptional);
        lvRequiredCourse.setAdapter(requiredAdapter);
        lvOptionalCourse.setAdapter(optionalAdapter);
    }
}