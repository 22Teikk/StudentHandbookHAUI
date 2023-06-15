package com.example.studenthandbookhaui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import com.example.studenthandbookhaui.E_Learning;
import com.example.studenthandbookhaui.Finance;
import com.example.studenthandbookhaui.MainActivity;
import com.example.studenthandbookhaui.R;
import com.example.studenthandbookhaui.Result;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.User;
import com.example.studenthandbookhaui.database.repository.UserRepository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

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
    TextView txtStudentId, txtCitizenID, txtGender,txtLocation, txtDob, txtName;
    DatabaseHelper helper;
    ImageView imgUser;
    UserRepository userRepository;
    User user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        getWidget(view);
        setContent(view);
        btnLogOut.setOnClickListener(new Excute());
        return view;
    }

    private class LoadImage extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmap = null;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgUser.setImageBitmap(bitmap);
        }
    }

    private void setContent(View view) {
        user = userRepository.getUserByStudentCode("2");
        txtName.setText(user.getFirstName() + " " + user.getLastName());
        txtStudentId.setText(user.getStudentCode());
        txtCitizenID.setText(user.getCitizenId());
        txtGender.setText(user.getGender());
        txtLocation.setText(user.getHomeTown());
        txtDob.setText(user.getDob().toString());
        new LoadImage().execute(user.getAvatar());
    }

    private void getWidget(View view){
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
        user = new User();
    }

    private class Excute implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.txtLogOut:
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    }
}