package com.example.studenthandbookhaui.database.repository;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.studenthandbookhaui.Lesson;
import com.example.studenthandbookhaui.database.DatabaseHelper;
import com.example.studenthandbookhaui.database.model.ArticleModel;
import com.example.studenthandbookhaui.database.model.LectureModel;
import com.example.studenthandbookhaui.database.model.LessonModel;
import com.example.studenthandbookhaui.database.model.QuizModel;

import java.util.ArrayList;

public class LessonRepository extends BaseRepository<LessonModel> {

    public LessonRepository(DatabaseHelper dbHelper) {
        super(dbHelper, "lessons");
    }

    @Override
    protected LessonModel getItemFromCursor(Cursor cursor) {
        return null;
    }

    @Override
    protected ContentValues getContentValues(LessonModel item) {
        return null;
    }

    public ArrayList<LessonModel> getLessonsByLectureId(long lecture_id) {
        ArrayList<LessonModel> lessons = new ArrayList<>();
        Cursor cursor = this.rawQuery("select l.id, a.id, a.name, a.content, q.id, q.name, q.question, q.answers  from lessons l left join articles a on a.lesson_id = l.id left join quizzes q on q.lesson_id = l.id  where lecture_id = " + lecture_id);
        if (cursor.moveToFirst()) {
            do {
                LessonModel lesson = new LessonModel();
                ArticleModel article = new ArticleModel();
                QuizModel quiz = new QuizModel();
                lesson.setId(cursor.getLong(0));
                article.setId(cursor.getLong(1));
                article.setName(cursor.getString(2));
                article.setContent(cursor.getString(3));
                quiz.setId(cursor.getLong(4));
                quiz.setName(cursor.getString(5));
                quiz.setQuestion(cursor.getString(6));
                quiz.setAnswer(cursor.getString(7));
                if (quiz.getName() != null) {
                    lesson.setLessonQuiz(quiz);
                    lesson.setLessonType(LessonModel.LessonType.QUIZ);
                }
                if (article.getName() != null) {
                    lesson.setLessonArticle(article);
                    lesson.setLessonType(LessonModel.LessonType.ARTICLE);
                }
                if (lesson.getLessonType() != null) {
                    lessons.add(lesson);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lessons;
    }
}
