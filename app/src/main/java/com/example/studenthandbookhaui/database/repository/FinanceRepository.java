package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.FinanceModel;
import com.example.studenthandbookhaui.database.model.ResultModel;

import java.util.ArrayList;

public class FinanceRepository extends BaseRepository<FinanceModel>{
    public FinanceRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "enrollments");
    }

    @Override
    protected FinanceModel getItemFromCursor(Cursor cursor) {
        return null;
    }

    @Override
    protected ContentValues getContentValues(FinanceModel item) {
        return null;
    }

    public ArrayList<FinanceModel> getFinanceByStudentCode(String studentCode) {
        ArrayList<FinanceModel> list = new ArrayList<>();
        Cursor cursor = rawQuery("SELECT course.name, debt_paid_date, debt \n" +
                "FROM enrollments \n" +
                "INNER JOIN classes ON enrollments.class_id = classes.id\n" +
                "INNER JOIN course on classes.course_id = course.id\n" +
                "WHERE user_id = " + studentCode);

        while (cursor.moveToNext()) {
            FinanceModel financeModel = new FinanceModel();
            financeModel.setNameCourse(cursor.getString(0));
            financeModel.setDebt_paid_date(cursor.getString(1));
            financeModel.setDebt(cursor.getInt(2));
            list.add(financeModel);
        }

        return list;
    }

}
