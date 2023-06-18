package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ArticleModel;
import com.example.studenthandbookhaui.database.model.QuizModel;

public class QuizRepository extends BaseRepository<QuizModel> {
    public QuizRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "quizzes");
    }

    @Override
    protected QuizModel getItemFromCursor(Cursor cursor) {
        QuizModel model = new QuizModel();
        model.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        model.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        model.setQuestion(cursor.getString(cursor.getColumnIndexOrThrow("question")));
        model.setAnswer(cursor.getString(cursor.getColumnIndexOrThrow("answers")));

        return model;
    }

    @Override
    protected ContentValues getContentValues(QuizModel item) {
        return null;
    }
}
