package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.FinanceModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FinanceRepository extends BaseRepository<FinanceModel> {
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

    public ArrayList<FinanceModel> getTransactionHistoryByStudentCode(String studentCode) {
        ArrayList<FinanceModel> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        Cursor cursor = rawQuery("SELECT course.name, debt_paid_date, debt \n" +
                "FROM enrollments \n" +
                "INNER JOIN classes ON enrollments.class_id = classes.id\n" +
                "INNER JOIN course on classes.course_id = course.id\n" +
                "WHERE debt_paid_date NOT NULL AND user_id = " + studentCode + " \n" +
                "ORDER BY debt_paid_date DESC");

        while (cursor.moveToNext()) {
            FinanceModel financeModel = new FinanceModel();
            financeModel.setNameCourse(cursor.getString(0));
            try {
                financeModel.setDebtPaidDate(sdf.parse(cursor.getString(1)));
            } catch (Exception e) {
                e.printStackTrace();
                financeModel.setDebtPaidDate(new Date());
            }
            financeModel.setDebt(cursor.getInt(2));
            list.add(financeModel);
        }

        return list;
    }

    public ArrayList<FinanceModel> getDebtByStudentCode(String studentCode) {
        ArrayList<FinanceModel> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);

        Cursor cursor = rawQuery("SELECT enrollments.id, course.name, classes.class_code, debt \n" +
                "FROM enrollments \n" +
                "INNER JOIN classes ON enrollments.class_id = classes.id\n" +
                "INNER JOIN course on classes.course_id = course.id\n" +
                "WHERE debt_paid_date is NULL AND user_id = " + studentCode);

        while (cursor.moveToNext()) {
            FinanceModel financeModel = new FinanceModel();
            financeModel.setId(cursor.getInt(0));
            financeModel.setNameCourse(cursor.getString(1));
            financeModel.setClassID(cursor.getString(2));
            financeModel.setDebt(cursor.getInt(3));
            list.add(financeModel);
        }

        return list;
    }

    public int makePayment(FinanceModel financeModel) {
        ContentValues contentValues = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        contentValues.put("debt_paid_date", sdf.format(new Date()));

        return this.update(contentValues, financeModel.getId());
    }

}
