package com.example.studenthandbookhaui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtStudentID;
    CheckBox chkSave;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        edtStudentID.setText(sharedPreferences.getString("studentID", ""));
        chkSave.setChecked(sharedPreferences.getBoolean("checked", false));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkSave.isChecked()){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("studentID", edtStudentID.getText().toString());
                    editor.putBoolean("checked", true);
                    editor.commit();
                }else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("studentID");
                    editor.remove("checked");
                    editor.commit();
                }
                Intent intent = new Intent(MainActivity.this, Onboarding.class);
                startActivity(intent);
            }
        });
    }

    private void getWidget(){
        btnLogin = findViewById(R.id.btnLogin);
        edtStudentID = findViewById(R.id.edtStudentID);
        chkSave = findViewById(R.id.chkSave);
        sharedPreferences = getSharedPreferences("saveID", MODE_PRIVATE);
    }
}