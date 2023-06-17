package com.example.studenthandbookhaui.fragment;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.studenthandbookhaui.HomePage;
import com.example.studenthandbookhaui.MainActivity;
import com.example.studenthandbookhaui.R;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.UserModel;
import com.example.studenthandbookhaui.database.repository.UserRepository;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
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
    }

    TextView btnLogOut;
    TextView txtStudentId, txtCitizenID, txtGender, txtLocation, txtDob, txtName;
    DatabaseHelper helper;
    ImageView imgUser;
    UserRepository userRepository;
    UserModel userModel;
    HomePage homePage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        homePage = (HomePage) getActivity();
        getWidget(view);
        setContent(view);
        btnLogOut.setOnClickListener(new Execute());
        return view;
    }

    private void setContent(View view) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            userModel = userRepository.getUserByStudentCode(homePage.getStudentID());
            txtName.setText(String.format("%s %s", userModel.getFirstName(), userModel.getLastName()));
            txtStudentId.setText(userModel.getStudentCode());
            txtCitizenID.setText(userModel.getCitizenId());
            txtGender.setText(userModel.getGender());
            txtLocation.setText(userModel.getHomeTown());
            txtDob.setText(sdf.format(userModel.getDob()));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                AssetManager am = activity.getAssets();
                InputStream is = am.open(userModel.getAvatar());
                Bitmap bm = BitmapFactory.decodeStream(is);

                imgUser.setImageBitmap(bm);
            }
        } catch (Exception e) {
            imgUser.setImageResource(R.drawable.user);
            e.printStackTrace();
        }

    }

    private void getWidget(View view) {
        txtName = view.findViewById(R.id.txtName);
        imgUser = view.findViewById(R.id.imgUser);
        btnLogOut = view.findViewById(R.id.txtLogOut);
        txtStudentId = view.findViewById(R.id.txtStudentID);
        txtCitizenID = view.findViewById(R.id.txtCitizenID);
        txtGender = view.findViewById(R.id.txtGender);
        txtLocation = view.findViewById(R.id.txtLocation);
        txtDob = view.findViewById(R.id.txtDob);
        helper = new DatabaseHelper(getContext());
        userRepository = new UserRepository(helper);
        userModel = new UserModel();
    }

    private class Execute implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.txtLogOut) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        }
    }
}