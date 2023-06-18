package com.example.studenthandbookhaui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ArticleModel;
import com.example.studenthandbookhaui.database.repository.ArticleRepository;

public class Article extends AppCompatActivity {

    DatabaseHelper dbHelper;
    ArticleRepository articleRepository;
    WebView wv;
    ImageView btnBack;
    TextView tvArticleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        dbHelper = new DatabaseHelper(this);
        articleRepository = new ArticleRepository(dbHelper);

        getWidgets();

        ArticleModel articleModel = articleRepository.findById(getIntent().getLongExtra("article_id", -1));
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadData(articleModel.getContent(), "text/html; charset=utf-8", "utf-8");
        btnBack.setOnClickListener(v -> onBackPressed());
        tvArticleName.setText(articleModel.getName());
    }

    private void getWidgets() {
        wv = findViewById(R.id.wv);
        btnBack = findViewById(R.id.btnBack);
        tvArticleName = findViewById(R.id.tvArticleName);
    }


}