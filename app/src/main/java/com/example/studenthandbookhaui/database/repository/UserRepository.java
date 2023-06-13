package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.Course;
import com.example.studenthandbookhaui.database.model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserRepository extends BaseRepository<User> {
    public UserRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "users");
    }

    @Override
    protected User getItemFromCursor(Cursor cursor) {
        User user = new User();

        user.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        user.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow("first_name")));
        user.setLastName(cursor.getString(cursor.getColumnIndexOrThrow("last_name")));
        user.setAvatar(cursor.getString(cursor.getColumnIndexOrThrow("avatar")));
        user.setAddress(cursor.getString(cursor.getColumnIndexOrThrow("address")));
        user.setDob(new Date(cursor.getString(cursor.getColumnIndexOrThrow("dob"))));
        user.setCitizenId(cursor.getString(cursor.getColumnIndexOrThrow("citizen_id")));
        user.setHomeTown(cursor.getString(cursor.getColumnIndexOrThrow("hometown")));
        user.setStudentCode(cursor.getString(cursor.getColumnIndexOrThrow("student_code")));
        user.setGender(cursor.getString(cursor.getColumnIndexOrThrow("gender")));
        user.setEthnicity(cursor.getString(cursor.getColumnIndexOrThrow("ethnicity")));

        return user;
    }

    @Override
    protected ContentValues getContentValues(User item) {
        ContentValues contentValues = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        contentValues.put("first_name", item.getFirstName());
        contentValues.put("last_name", item.getLastName());
        contentValues.put("avatar", item.getAvatar());
        contentValues.put("address", item.getAddress());
        contentValues.put("dob", sdf.format(item.getDob()));
        contentValues.put("citizen_id", item.getCitizenId());
        contentValues.put("home_town", item.getHomeTown());
        contentValues.put("student_code", item.getStudentCode());
        contentValues.put("gender", item.getGender());
        contentValues.put("ethnicity", item.getEthnicity());

        return contentValues;
    }

    public User getUserByStudentCode(String studentCode) {
        ArrayList<User> users = this.find(String.format("student_code = '%s'", studentCode));
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
