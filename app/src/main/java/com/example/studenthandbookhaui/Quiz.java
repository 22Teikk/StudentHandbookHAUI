package com.example.studenthandbookhaui;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ArticleModel;
import com.example.studenthandbookhaui.database.model.QuizModel;
import com.example.studenthandbookhaui.database.repository.ArticleRepository;
import com.example.studenthandbookhaui.database.repository.QuizRepository;

import java.util.Locale;

public class Quiz extends AppCompatActivity {

    DatabaseHelper dbHelper;
    QuizRepository quizRepository;
    ImageView btnBack;
    TextView tvQuestion;
    EditText etAnswer;
    Button btnSubmit;

    TextView tvQuizName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        dbHelper = new DatabaseHelper(this);
        quizRepository = new QuizRepository(dbHelper);

        getWidgets();

        QuizModel quizModel = quizRepository.findById(getIntent().getLongExtra("quiz_id", 1));

        if (quizModel == null) {
            return;
        }

        tvQuizName.setText(quizModel.getName());
        tvQuestion.setText(quizModel.getQuestion());

        btnSubmit.setOnClickListener(v -> {
            String answer = etAnswer.getText().toString().trim().toLowerCase(Locale.US);
            if (answer.equals(quizModel.getAnswer().toLowerCase(Locale.US))) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Quiz.this);
                builder.setTitle("Correct!");
                builder.setMessage(" You've answered correctly");
                builder.setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                    finish();
                });
                builder.show();
            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(v -> onBackPressed());
    }

    private void getWidgets() {
        btnBack = findViewById(R.id.btnBack);
        tvQuizName = findViewById(R.id.tvQuizName);
        tvQuestion = findViewById(R.id.tvQuestion);
        etAnswer = findViewById(R.id.etAnswer);
        btnSubmit = findViewById(R.id.btnSubmit);
    }


}