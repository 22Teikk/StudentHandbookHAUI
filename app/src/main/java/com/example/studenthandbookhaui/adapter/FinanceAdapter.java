package com.example.studenthandbookhaui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.studenthandbookhaui.R;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.FinanceModel;
import com.example.studenthandbookhaui.database.repository.FinanceRepository;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FinanceAdapter extends ArrayAdapter<FinanceModel> {
    DatabaseHelper dbHelper;
    FinanceRepository financeRepository;
    private LayoutInflater inflater;

    public FinanceAdapter(@NonNull Context context, ArrayList<FinanceModel> arrayList) {

        super(context, 0, arrayList);
        inflater = LayoutInflater.from(context);
        dbHelper = new DatabaseHelper(context);
        financeRepository = new FinanceRepository(dbHelper);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.lv_finance, parent, false);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###");
        FinanceModel financeModel = getItem(position);

        TextView name = view.findViewById(R.id.financeName);
        TextView date = view.findViewById(R.id.financeDate);
        TextView debt = view.findViewById(R.id.financeMoney);
        try {
            if (financeModel.getDebt() > 0) {
                name.setText(financeModel.getNameCourse());
                date.setText(sdf.format(financeModel.getDebtPaidDate()));
                debt.setText(String.format("-%s đ", formatter.format(financeModel.getDebt())));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
}