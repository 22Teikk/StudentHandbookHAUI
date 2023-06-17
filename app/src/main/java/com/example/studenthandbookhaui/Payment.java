package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studenthandbookhaui.adapter.PaymentAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.FinanceModel;
import com.example.studenthandbookhaui.database.repository.FinanceRepository;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Payment extends AppCompatActivity {
    TextView txtTotalPayment;
    ImageView btnBack;
    ListView lvPayment;
    ImageView noDataPlaceholder;
    Button btnMakePayment;
    DatabaseHelper dbHelper;

    ArrayList<FinanceModel> financeList;
    PaymentAdapter paymentAdapter;

    FinanceRepository financeRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getWidget();
        dbHelper = new DatabaseHelper(this);
        financeRepository = new FinanceRepository(dbHelper);

        lvPayment.setOnItemClickListener((parent, view, position, id) -> {
            FinanceModel financeModel = financeList.get(position);
            financeModel.setSelected(!financeModel.isSelected());
            updateDebtSum();
            paymentAdapter.notifyDataSetChanged();
        });
        btnBack.setOnClickListener(v -> finish());
        btnMakePayment.setOnClickListener(v -> makePayment());
        setFinanceList();
    }

    private void getWidget() {
        txtTotalPayment = findViewById(R.id.txtTotalPayment);
        btnBack = findViewById(R.id.btnBack);
        lvPayment = findViewById(R.id.lvPayment);
        btnMakePayment = findViewById(R.id.btnMakePayment);
        noDataPlaceholder = findViewById(R.id.noDataPlaceholder);
    }

    private void setFinanceList() {
        String userId = (((UserID) getApplication()).userId) + "";
        financeList = new ArrayList<>();
        financeList.addAll(financeRepository.getDebtByStudentCode(userId));
        if (financeList.size() == 0) {
            noDataPlaceholder.setVisibility(View.VISIBLE);
        } else {
            noDataPlaceholder.setVisibility(View.GONE);
            paymentAdapter = new PaymentAdapter(this, financeList);
            lvPayment.setAdapter(paymentAdapter);
        }
        updateDebtSum();
    }

    private void updateDebtSum() {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###");
        int sum = 0;
        for (FinanceModel financeModel : financeList) {
            if (financeModel.isSelected())
                sum += financeModel.getDebt();
        }
        txtTotalPayment.setText(formatter.format(sum) + " đ");
    }

    private void makePayment() {
        for (int i = 0; i < financeList.size(); i++) {
            FinanceModel financeModel = financeList.get(i);
            if (financeModel.isSelected()) {
                financeRepository.makePayment(financeModel);
            }
        }
        finish();
    }
}