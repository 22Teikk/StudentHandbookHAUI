package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studenthandbookhaui.adapter.LessonAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.LessonModel;
import com.example.studenthandbookhaui.database.repository.LessonRepository;

import java.util.ArrayList;

public class Lesson extends AppCompatActivity {

    DatabaseHelper dbHelper;
    LessonRepository lessonRepository;
    ArrayList<LessonModel> lessonList;
    LessonAdapter adapter;
    ListView lessonListView;
    TextView lessonTitle;
    Long lectureId;

    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        dbHelper = new DatabaseHelper(this);
        lessonRepository = new LessonRepository(dbHelper);

        lessonListView = findViewById(R.id.lvLesson);
        lessonTitle = findViewById(R.id.tvLessonName);
        btnBack = findViewById(R.id.btnBack);

        lessonTitle.setText(getIntent().getStringExtra("lecture_name"));
        lectureId = getIntent().getLongExtra("lecture_id", 0);
        lessonList = lessonRepository.getLessonsByLectureId(lectureId);

        adapter = new LessonAdapter(this, lessonList);
        lessonListView.setAdapter(adapter);
        lessonListView.setOnItemClickListener((parent, view, position, id) -> {
            LessonModel lesson = lessonList.get(position);
            if (lesson.getLessonType() == LessonModel.LessonType.ARTICLE) {
                Intent intent = new Intent(this, Article.class);
                intent.putExtra("article_id", lessonList.get(position).getLessonArticle().getId());
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, Quiz.class);
                intent.putExtra("quiz_id", lessonList.get(position).getLessonQuiz().getId());
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}