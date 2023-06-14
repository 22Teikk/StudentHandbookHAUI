package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.FinanceModel;
import com.example.studenthandbookhaui.database.model.NotificationModel;

import java.util.ArrayList;

public class NotificationRepository extends BaseRepository<NotificationModel>{

    public NotificationRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "enrollments");
    }

    @Override
    protected NotificationModel getItemFromCursor(Cursor cursor) {
        return null;
    }

    @Override
    protected ContentValues getContentValues(NotificationModel item) {
        return null;
    }

    public ArrayList<NotificationModel> getNotificationByStudentCode(String studentCode) {
        ArrayList<NotificationModel> list = new ArrayList<>();
        Cursor cursor = rawQuery("SELECT notifications.type, notifications.content, user_notifications.created_at FROM user_notifications\n" +
                "INNER JOIN notifications ON user_notifications.notification_id = notifications.id\n" +
                "WHERE user_notifications.user_id = " + studentCode);

        while (cursor.moveToNext()) {
            NotificationModel notificationModel = new NotificationModel();
            notificationModel.setType(cursor.getString(0));
            notificationModel.setContent(cursor.getString(1));
            notificationModel.setTime(cursor.getString(2));
            list.add(notificationModel);
        }

        return list;
    }
}
