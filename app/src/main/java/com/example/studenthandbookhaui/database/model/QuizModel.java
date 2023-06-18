package com.example.studenthandbookhaui.database.model;

public class QuizModel extends BaseModel {
    private int id;
    private String name;
    private String question;

    private String answer;

    public QuizModel() {
    }

    public QuizModel(int id, String name, String question, String answer) {
        this.id = id;
        this.name = name;
        this.question = question;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
