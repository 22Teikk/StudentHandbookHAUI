package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.studenthandbookhaui.adapter.ResultAdapter;
import com.example.studenthandbookhaui.adapter.ScheduleAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ClassModel;
import com.example.studenthandbookhaui.database.model.ResultModel;
import com.example.studenthandbookhaui.database.repository.ResultRepository;
import com.example.studenthandbookhaui.database.repository.UserRepository;

import java.io.Serializable;
import java.util.ArrayList;

public class Result extends AppCompatActivity {
    ImageView btnBack;
    ListView lvResult;
    DatabaseHelper databaseHelper;

    ResultRepository resultRepository;
    private ResultAdapter resultAdapter;
    private ArrayList<ResultModel> resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getWidget();
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ResultModel resultModel = resultList.get(i);
                Intent intent = new Intent(Result.this, Result_Detail.class);
                intent.putExtra("resultModel",  resultModel);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void getWidget(){
        btnBack = findViewById(R.id.btnBack);
        lvResult = findViewById(R.id.lvResult);
        databaseHelper = new DatabaseHelper(this);
        resultRepository = new ResultRepository(databaseHelper);
        resultList = new ArrayList<>();
        resultList.clear();
        resultList.addAll(resultRepository.getResultByStudentCode("1"));
        resultAdapter = new ResultAdapter(this, resultList);
        lvResult.setAdapter(resultAdapter);
    }
}