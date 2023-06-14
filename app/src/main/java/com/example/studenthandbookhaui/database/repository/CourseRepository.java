package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.CourseModel;

public class CourseRepository extends BaseRepository<CourseModel> {
    public CourseRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "course");
    }

    @Override
    protected CourseModel getItemFromCursor(Cursor cursor) {
        CourseModel courseModelClass = new CourseModel();

        courseModelClass.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        courseModelClass.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        courseModelClass.setCourseCode(cursor.getString(cursor.getColumnIndexOrThrow("course_code")));
        courseModelClass.setCourseLoadPractical(cursor.getInt(cursor.getColumnIndexOrThrow("course_load_practical")));
        courseModelClass.setCourseLoadTheoretical(cursor.getInt(cursor.getColumnIndexOrThrow("course_load_theoretical")));

        return courseModelClass;
    }

    @Override
    protected ContentValues getContentValues(CourseModel item) {
        return new ContentValues();
    }


}
