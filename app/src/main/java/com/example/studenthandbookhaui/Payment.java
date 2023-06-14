package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studenthandbookhaui.database.DatabaseHelper;

public class Payment extends AppCompatActivity {
    TextView txtTotalPayment;
    ImageView btnBack;
    ListView lvPayment;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getWidget();


    }

    private void getWidget(){

    }
}