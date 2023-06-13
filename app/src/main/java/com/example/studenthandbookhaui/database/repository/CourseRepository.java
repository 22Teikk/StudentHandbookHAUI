package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.Course;

public class CourseRepository extends BaseRepository<Course> {
    public CourseRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "courses");
    }

    @Override
    protected Course getItemFromCursor(Cursor cursor) {
        Course courseClass = new Course();

        courseClass.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        courseClass.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        courseClass.setCourseCode(cursor.getString(cursor.getColumnIndexOrThrow("")));
        courseClass.setCourseLoadPractical(cursor.getInt(cursor.getColumnIndexOrThrow("course_load_practical")));
        courseClass.setCourseLoadTheoretical(cursor.getInt(cursor.getColumnIndexOrThrow("course_load_theoretical")));

        return courseClass;
    }

    @Override
    protected ContentValues getContentValues(Course item) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", item.getName());
        contentValues.put("course_code", item.getCourseCode());
        contentValues.put("course_load_practical", item.getCourseLoadPractical());
        contentValues.put("course_load_theoretical", item.getCourseLoadTheoretical());

        return contentValues;
    }
}
