package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ArticleModel;

public class ArticleRepository extends BaseRepository<ArticleModel> {
    public ArticleRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "articles");
    }

    @Override
    protected ArticleModel getItemFromCursor(Cursor cursor) {
        ArticleModel model = new ArticleModel();
        model.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        model.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        model.setContent(cursor.getString(cursor.getColumnIndexOrThrow("content")));

        return model;
    }

    @Override
    protected ContentValues getContentValues(ArticleModel item) {
        return null;
    }
}
