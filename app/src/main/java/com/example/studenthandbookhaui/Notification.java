package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.studenthandbookhaui.adapter.NotificationAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.NotificationModel;
import com.example.studenthandbookhaui.database.repository.NotificationRepository;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {
    ImageView btnBack;
    ListView lvNotification;
    NotificationAdapter adapter;
    NotificationRepository notificationRepository;
    DatabaseHelper helper;
    ArrayList<NotificationModel> notifications;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        getWidget();
    }

    private void getWidget(){
        btnBack = findViewById(R.id.btnBack);
        notifications = new ArrayList<>();
        lvNotification = findViewById(R.id.lvNotification);
        helper = new DatabaseHelper(this);
        notificationRepository = new NotificationRepository(helper);
        notifications.addAll(notificationRepository.getNotificationByStudentCode((((UserID) getApplication()).userId) + ""));
        adapter = new NotificationAdapter(this, notifications);
        lvNotification.setAdapter(adapter);
        btnBack.setOnClickListener(v -> onBackPressed());
    }
}