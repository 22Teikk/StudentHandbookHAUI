package com.example.studenthandbookhaui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studenthandbookhaui.adapter.FinanceAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.FinanceModel;
import com.example.studenthandbookhaui.database.repository.FinanceRepository;

import java.util.ArrayList;

public class Finance extends AppCompatActivity {
    Button btnPayment;
    TextView txtDebt;
    ImageView btnBack;
    ListView lvFinance;
    ArrayList<FinanceModel> listFinance;
    DatabaseHelper helper;
    FinanceRepository financeRepository;
    int sumDebt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        getWidget();
        btnBack.setOnClickListener(new Excute());
        btnPayment.setOnClickListener(new Excute());

    }

    private void getWidget(){
        txtDebt = findViewById(R.id.txtDebt);
        btnBack = findViewById(R.id.btnBack);
        btnPayment = findViewById(R.id.btnPayment);
        lvFinance = findViewById(R.id.lvFinance);
        helper = new DatabaseHelper(this);
        financeRepository = new FinanceRepository(helper);
        listFinance = new ArrayList<>();
        listFinance.clear();
        listFinance.addAll(financeRepository.getFinanceByStudentCode("1"));
        for (FinanceModel temp :
                listFinance) {
            sumDebt += temp.getDebt();
        }
        txtDebt.setText(String.valueOf(sumDebt));
        FinanceAdapter adapter = new FinanceAdapter(this, listFinance);
        lvFinance.setAdapter(adapter);
    }

    private class Excute implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnBack:
                    onBackPressed();
                    break;
                case R.id.btnPayment:
                    Intent intent = new Intent(Finance.this, Payment.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}