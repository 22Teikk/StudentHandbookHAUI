package com.example.studenthandbookhaui.fragment;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.studenthandbookhaui.HomePage;
import com.example.studenthandbookhaui.R;
import com.example.studenthandbookhaui.adapter.ScheduleAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ClassModel;
import com.example.studenthandbookhaui.database.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {

    private DatabaseHelper databaseHelper;

    private UserRepository userRepository;
    private Button btnSelected;
    private ImageView btnNextWeek;
    private ImageView btnPreviousWeek;

    private ScheduleAdapter classAdapter;
    private ArrayList<ClassModel> classList;
    HomePage homePage;
    private ListView listView;
    private ImageView noDataPlaceholder;

    private Calendar currentWeek;
    private TextView tvCurrentWeek;
    private final int[] btnIds = {R.id.mondayBtn, R.id.tuesdayBtn, R.id.wednesdayBtn, R.id.thursdayBtn, R.id.fridayBtn, R.id.saturdayBtn, R.id.sundayBtn};

    public ScheduleFragment() {
        // Required empty public constructor
    }

    public static ScheduleFragment newInstance() {
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(getContext());
        userRepository = new UserRepository(databaseHelper);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homePage = (HomePage) getActivity();
        if (homePage == null) {
            return;
        }

        for (int id : btnIds) {
            view.findViewById(id).setOnClickListener((v) -> {
                onSelectDay(v);
            });
        }
        listView = view.findViewById(R.id.lvSchedule);
        btnSelected = view.findViewById(R.id.mondayBtn);
        noDataPlaceholder = view.findViewById(R.id.noDataPlaceholder);
        tvCurrentWeek = view.findViewById(R.id.tvCurrentWeek);
        btnPreviousWeek = view.findViewById(R.id.btnPreviousWeek);
        btnNextWeek = view.findViewById(R.id.btnNextWeek);

        currentWeek = Calendar.getInstance();
        currentWeek.set(Calendar.HOUR_OF_DAY, 0);
        currentWeek.clear(Calendar.MINUTE);
        currentWeek.clear(Calendar.SECOND);
        currentWeek.clear(Calendar.MILLISECOND);
        currentWeek.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        classList = new ArrayList<>();

        classAdapter = new ScheduleAdapter(homePage, classList);
        listView.setAdapter(classAdapter);
        onSelectDay(btnSelected);

        tvCurrentWeek.setText(getWeekString(currentWeek));

        btnPreviousWeek.setOnClickListener((v) -> {
            currentWeek.add(Calendar.DAY_OF_MONTH, -7);
            onSelectDay(btnSelected);
            tvCurrentWeek.setText(getWeekString(currentWeek));
        });

        btnNextWeek.setOnClickListener((v) -> {
            currentWeek.add(Calendar.DAY_OF_MONTH, 7);
            onSelectDay(btnSelected);
            tvCurrentWeek.setText(getWeekString(currentWeek));
        });
    }

    private void onSelectDay(View v) {
        if (btnSelected != null) {
            btnSelected.setBackgroundResource(R.drawable.cus_button_secondary);
        }
        btnSelected = (Button) v;
        int dayInWeek = 1;
        for (int id : btnIds) {
            if (btnSelected.getId() == id) {
                break;
            }
            dayInWeek++;
        }

        v.setBackgroundResource(R.drawable.cus_button);

        setClassList(dayInWeek);
    }

    private void setClassList(int dayInWeek) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        classList.clear();
        classList.addAll(userRepository.getClassByStudentCode(homePage.getStudentID() + "", "" + dayInWeek, sdf.format(currentWeek.getTime())));
        if (classList.size() == 0) {
            noDataPlaceholder.setVisibility(View.VISIBLE);
        } else {
            noDataPlaceholder.setVisibility(View.GONE);
        }
        classAdapter.notifyDataSetChanged();
    }

    private String getWeekString(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        String startDate = sdf.format(calendar.getTime());
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(Calendar.DAY_OF_MONTH, 6);
        String endDate = sdf.format(calendar2.getTime());

        return String.format("%s - %s", startDate, endDate);
    }
}