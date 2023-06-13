package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.CourseModel;
import com.example.studenthandbookhaui.database.repository.CourseRepository;

import java.util.ArrayList;

public class Course extends AppCompatActivity {

    DatabaseHelper dbHelper;
    CourseRepository courseRepository;
    ArrayList<CourseModel> courses = new ArrayList<CourseModel>();
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        dbHelper = new DatabaseHelper(this);
        courseRepository = new CourseRepository(dbHelper);

        courses = courseRepository.find();

        Toast.makeText(Course.this, courses.get(0).getName(), Toast.LENGTH_SHORT).show();

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
    }
}