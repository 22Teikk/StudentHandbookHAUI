package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studenthandbookhaui.adapter.FinanceAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.FinanceModel;
import com.example.studenthandbookhaui.database.repository.FinanceRepository;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Finance extends AppCompatActivity {
    Button btnPayment;
    TextView txtDebt;
    ImageView btnBack;
    ListView lvFinance;
    ArrayList<FinanceModel> listFinance;
    DatabaseHelper helper;
    FinanceRepository financeRepository;
    FinanceAdapter adapter;
    int sumDebt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        getWidget();
        btnBack.setOnClickListener(new Execute());
        btnPayment.setOnClickListener(new Execute());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setFinanceList();
        updateSumDebt();
        adapter.notifyDataSetChanged();
    }

    private void getWidget() {
        txtDebt = findViewById(R.id.txtDebt);
        btnBack = findViewById(R.id.btnBack);
        btnPayment = findViewById(R.id.btnPayment);
        lvFinance = findViewById(R.id.lvFinance);
        helper = new DatabaseHelper(this);
        financeRepository = new FinanceRepository(helper);
        listFinance = new ArrayList<>();
        adapter = new FinanceAdapter(this, listFinance);
        setFinanceList();
        updateSumDebt();
        lvFinance.setAdapter(adapter);
    }

    private void setFinanceList(){
        listFinance.clear();
        listFinance.addAll(financeRepository.getTransactionHistoryByStudentCode((((UserID) getApplication()).userId) + ""));
    }

    private void updateSumDebt(){
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###");
        ArrayList<FinanceModel> listDebt = financeRepository.getDebtByStudentCode((((UserID) getApplication()).userId));
        for (FinanceModel temp :
                listDebt) {

            sumDebt += temp.getDebt();
        }
        txtDebt.setText(formatter.format(sumDebt)+" đ");
    }

    private class Execute implements View.OnClickListener {
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