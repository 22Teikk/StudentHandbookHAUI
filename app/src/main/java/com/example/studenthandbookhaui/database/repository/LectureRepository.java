package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import android.widget.ListView;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.LectureModel;

import java.util.ArrayList;

public class LectureRepository extends BaseRepository<LectureModel> {

    public LectureRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "lectures");
    }

    @Override
    protected LectureModel getItemFromCursor(Cursor cursor) {
        LectureModel model = new LectureModel();

        model.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        model.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));

        return model;
    }

    @Override
    protected ContentValues getContentValues(LectureModel item) {
        return null;
    }

    public ArrayList<LectureModel> getLectureByCourseId(long courseId) {
        return this.find("course_id = " + courseId);
    }
}
