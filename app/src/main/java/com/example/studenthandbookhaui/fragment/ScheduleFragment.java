package com.example.studenthandbookhaui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.studenthandbookhaui.R;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.CourseClass;
import com.example.studenthandbookhaui.database.repository.ClassRepository;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {

    private DatabaseHelper databaseHelper;

    private ClassRepository classRepository;
    private Button selectedButton;

    private ArrayAdapter<CourseClass> classAdapter;

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
        classRepository = new ClassRepository(databaseHelper);
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

        int[] ids = {R.id.mondayBtn, R.id.tuesdayBtn, R.id.wednesdayBtn, R.id.thursdayBtn, R.id.fridayBtn,R.id.saturdayBtn,R.id.sundayBtn};

        for(int id : ids) {
            view.findViewById(id).setOnClickListener((v)->{onSelectDay(v);});
        }


        classAdapter = new ArrayAdapter<>(getContext(), R.layout.schedule_class_item, classRepository.find());
    }

    public void onSelectDay(View v) {
        if (selectedButton != null) {
            selectedButton.setBackgroundResource(R.drawable.cus_button_secondary);
        }
        selectedButton = (Button) v;
        v.setBackgroundResource(R.drawable.cus_button);
    }
}