package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ClassModel;
import com.example.studenthandbookhaui.database.model.ResultModel;

import java.util.ArrayList;

public class ResultRepository extends BaseRepository{


    public ResultRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "enrollments");
    }

    @Override
    protected Object getItemFromCursor(Cursor cursor) {
        return null;
    }

    @Override
    protected ContentValues getContentValues(Object item) {
        return null;
    }

    public ArrayList<ResultModel> getResultByStudentCode(String studentCode) {
        ArrayList<ResultModel> list = new ArrayList<>();
        Cursor cursor = rawQuery("SELECT course.name, course_code, regular_score, progress_score, exam_score, course_load_theoretical, course_load_practical \n" +
                "FROM enrollments \n" +
                "INNER JOIN classes ON enrollments.class_id = classes.id\n" +
                "INNER JOIN course on classes.course_id = course.id\n" +
                "WHERE user_id = " + studentCode);

        while (cursor.moveToNext()) {
            ResultModel resultModel = new ResultModel();
            resultModel.setNameCourse(cursor.getString(0));
            resultModel.setCourse_code(cursor.getString(1));
            resultModel.setRegularScore(cursor.getString(2));
            resultModel.setProgressScore(cursor.getString(3));
            resultModel.setExamScore(cursor.getString(4));
            resultModel.setCourse_load_theoretical(cursor.getInt(5));
            resultModel.setCourse_load_practical(cursor.getInt(6));
            list.add(resultModel);
        }

        return list;
    }
}
