package com.example.studenthandbookhaui.database.model;


public class LessonModel extends BaseModel {

    ArticleModel lessonArticle;
    QuizModel lessonQuiz;

public enum LessonType {
        ARTICLE,
        QUIZ,
    };

    LessonType lessonType;


    public LessonModel(ArticleModel lessonArticle, QuizModel lessonQuiz) {
        this.lessonArticle = lessonArticle;
        this.lessonQuiz = lessonQuiz;
    }

    public LessonModel() {
    }

    public ArticleModel getLessonArticle() {
        return lessonArticle;
    }

    public void setLessonArticle(ArticleModel lessonArticle) {
        this.lessonArticle = lessonArticle;
    }

    public QuizModel getLessonQuiz() {
        return lessonQuiz;
    }

    public void setLessonQuiz(QuizModel lessonQuiz) {
        this.lessonQuiz = lessonQuiz;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }
}
