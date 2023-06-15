package com.example.studenthandbookhaui.fragment;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.studenthandbookhaui.HomePage;
import com.example.studenthandbookhaui.R;
import com.example.studenthandbookhaui.adapter.ScheduleAdapter;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ClassModel;
import com.example.studenthandbookhaui.database.model.CourseModel;
import com.example.studenthandbookhaui.database.model.User;
import com.example.studenthandbookhaui.database.repository.CourseRepository;
import com.example.studenthandbookhaui.database.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {

    private DatabaseHelper databaseHelper;

    private UserRepository userRepository;
    private Button selectedButton;

    private ScheduleAdapter classAdapter;
    private ArrayList<ClassModel> classList;
    HomePage homePage;
    private ListView listView;

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
        int dayInWeek = 1;
        int[] ids = {R.id.mondayBtn, R.id.tuesdayBtn, R.id.wednesdayBtn, R.id.thursdayBtn, R.id.fridayBtn,R.id.saturdayBtn,R.id.sundayBtn};

        for(int id : ids) {
            int finalDayInWeek = dayInWeek;
            view.findViewById(id).setOnClickListener((v)->{onSelectDay(v, finalDayInWeek);});
            dayInWeek++;
        }
        listView = view.findViewById(R.id.lvSchedule);
        selectedButton = view.findViewById(R.id.mondayBtn);

        classList = new ArrayList<>();
        classAdapter = new ScheduleAdapter(getContext(), classList);
        listView.setAdapter(classAdapter);
    }

    public void onSelectDay(View v, int dayInWeek) {
        if (selectedButton != null) {
            selectedButton.setBackgroundResource(R.drawable.cus_button_secondary);
        }
        selectedButton = (Button) v;
        v.setBackgroundResource(R.drawable.cus_button);

        classList.clear();
        classList.addAll(userRepository.getClassByStudentCode(homePage.getStudentID() + "", ""+dayInWeek));
        classAdapter.notifyDataSetChanged();
    }
}