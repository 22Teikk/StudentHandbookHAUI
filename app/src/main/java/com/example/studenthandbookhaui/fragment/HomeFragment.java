package com.example.studenthandbookhaui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.studenthandbookhaui.Course;
import com.example.studenthandbookhaui.E_Learning;
import com.example.studenthandbookhaui.Finance;
import com.example.studenthandbookhaui.HomePage;
import com.example.studenthandbookhaui.Notification;
import com.example.studenthandbookhaui.R;
import com.example.studenthandbookhaui.Result;
import com.example.studenthandbookhaui.UserID;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.UserModel;
import com.example.studenthandbookhaui.database.repository.UserRepository;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    DatabaseHelper dbHelper;
    UserRepository userRepository;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        dbHelper = new DatabaseHelper(getContext());
        userRepository = new UserRepository(dbHelper);
    }

    Intent intent;
    ImageView btnNotification;
    LinearLayout btnCourses, btnResult, btnFinance, btnLearning;
    EditText edtNotes;
    TextView txtUser;
    SharedPreferences sharedPreferences;
    HomePage homePage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getWidget(view);
        btnNotification.setOnClickListener(new Excute());
        btnLearning.setOnClickListener(new Excute());
        btnFinance.setOnClickListener(new Excute());
        btnResult.setOnClickListener(new Excute());
        btnCourses.setOnClickListener(new Excute());
        sharedPreferences = this.getActivity().getSharedPreferences("saveNotes", Context.MODE_PRIVATE);
        if (sharedPreferences.getString("id", "").compareTo(homePage.getStudentID()) == 0) {
            edtNotes.setText(sharedPreferences.getString("notes", ""));
        }

        String userId = ((UserID) getActivity().getApplication()).userId;
        UserModel userModel = userRepository.getUserByStudentCode(userId);
        txtUser.setText(userModel.getLastName());
        return view;
    }

    @Override
    public void onPause() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("notes", edtNotes.getText().toString());
        editor.putString("id", homePage.getStudentID());
        editor.commit();
        super.onPause();
    }

    private void getWidget(View view) {
        homePage = (HomePage) getActivity();
        txtUser = view.findViewById(R.id.txtUser);
        btnNotification = view.findViewById(R.id.btnNotification);
        btnCourses = view.findViewById(R.id.layoutCourse);
        btnResult = view.findViewById(R.id.layoutResult);
        btnFinance = view.findViewById(R.id.layoutFinance);
        btnLearning = view.findViewById(R.id.layoutELearning);
        edtNotes = view.findViewById(R.id.edtNotes);
    }

    private class Excute implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnNotification:
                    intent = new Intent(getActivity(), Notification.class);
                    startActivity(intent);
                    break;
                case R.id.layoutCourse:
                    intent = new Intent(getActivity(), Course.class);
                    startActivity(intent);
                    break;
                case R.id.layoutResult:
                    intent = new Intent(getActivity(), Result.class);
                    startActivity(intent);
                    break;
                case R.id.layoutFinance:
                    intent = new Intent(getActivity(), Finance.class);
                    startActivity(intent);
                    break;
                case R.id.layoutELearning:
                    intent = new Intent(getActivity(), E_Learning.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}