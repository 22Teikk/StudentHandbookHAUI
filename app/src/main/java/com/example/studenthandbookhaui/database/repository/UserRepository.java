package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ClassModel;
import com.example.studenthandbookhaui.database.model.CourseModel;
import com.example.studenthandbookhaui.database.model.LectureModel;
import com.example.studenthandbookhaui.database.model.UserModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class UserRepository extends BaseRepository<UserModel> {
    public UserRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "users");
    }

    @Override
    protected UserModel getItemFromCursor(Cursor cursor) {
        UserModel userModel = new UserModel();

        userModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        userModel.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow("first_name")));
        userModel.setLastName(cursor.getString(cursor.getColumnIndexOrThrow("last_name")));
        userModel.setAvatar(cursor.getString(cursor.getColumnIndexOrThrow("avatar")));
        userModel.setAddress(cursor.getString(cursor.getColumnIndexOrThrow("address")));
        userModel.setDob(new Date(cursor.getString(cursor.getColumnIndexOrThrow("dob"))));
        userModel.setCitizenId(cursor.getString(cursor.getColumnIndexOrThrow("citizen_id")));
        userModel.setHomeTown(cursor.getString(cursor.getColumnIndexOrThrow("hometown")));
        userModel.setStudentCode(cursor.getString(cursor.getColumnIndexOrThrow("student_code")));
        userModel.setGender(cursor.getString(cursor.getColumnIndexOrThrow("gender")));
        userModel.setEthnicity(cursor.getString(cursor.getColumnIndexOrThrow("ethnicity")));

        return userModel;
    }

    @Override
    protected ContentValues getContentValues(UserModel item) {
        ContentValues contentValues = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);

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

    public UserModel getUserByStudentCode(String studentCode) {
        ArrayList<UserModel> userModels = this.find(String.format("student_code = '%s'", studentCode));
        if (userModels.size() > 0) {
            return userModels.get(0);
        } else {
            return null;
        }
    }

    public ArrayList<ClassModel> getClassByStudentCode(String studentCode, String dayOfWeek, String fromDate) {
        Log.d("fromDate", fromDate);
        ArrayList<ClassModel> list = new ArrayList<>();
        Cursor cursor = rawQuery("select day_in_week, time_in_day, room, class_code, cl.course_id from users inner join enrollments er on users.id = er.user_id\n" +
                "inner join classes cl on er.class_id = cl.id\n" +
                "where day_in_week like '%" + dayOfWeek + "%'\n" +
                "and users.student_code = 1 and er.enrolled_date < '" + fromDate + "' and er.end_date > CURRENT_DATE");

        while (cursor.moveToNext()) {
            ClassModel classModel = new ClassModel();
            classModel.setDayInWeek(cursor.getString(0));
            classModel.setTimeInDay(cursor.getString(1));
            classModel.setRoom(cursor.getString(2));
            classModel.setRoom(cursor.getString(3));
            classModel.setCourseId(cursor.getString(4));
            list.add(classModel);
        }

        cursor.close();

        return list;
    }

    public ArrayList<CourseModel> getLectureCourseByStudentCode(String studentCode) {
        ArrayList<CourseModel> list = new ArrayList<>();

        Cursor cursor = rawQuery("select cs.id, cs.name, cls.class_code from users u\n" +
                "inner join enrollments e on u.id = e.user_id\n" +
                "inner join classes cls on cls.id = e.class_id\n" +
                "inner join course cs on cls.course_id = cs.id\n" +
                "inner join lectures l on cs.id = l.course_id\n" +
                "where u.id = " + studentCode + "\n" +
                "group by cs.id");

        while(cursor.moveToNext()) {
            CourseModel courseModel = new CourseModel();
            ClassModel classModel = new ClassModel();

            Log.d("LectureRepository", cursor.getString(2));

            courseModel.setId(cursor.getLong(0));
            courseModel.setName(cursor.getString(1));
            classModel.setClassCode(cursor.getString(2));
            courseModel.setCourseClass(classModel);
            list.add(courseModel);
        }

        cursor.close();

        return list;
    }
}
