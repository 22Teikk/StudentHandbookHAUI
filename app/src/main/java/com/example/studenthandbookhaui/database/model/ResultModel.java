package com.example.studenthandbookhaui.database.model;

import java.io.Serializable;

public class ResultModel extends BaseModel implements Serializable {
    private String nameCourse;
    private String course_code;
    private String regularScore;
    private String progressScore;
    private String examScore;
    private int course_load_theoretical;
    private int course_load_practical;

    public ResultModel(){}

    public ResultModel(String nameCourse, String course_code, String regularScore, String progressScore, String examScore, int course_load_theoretical, int course_load_practical) {
        this.nameCourse = nameCourse;
        this.course_code = course_code;
        this.regularScore = regularScore;
        this.progressScore = progressScore;
        this.examScore = examScore;
        this.course_load_theoretical = course_load_theoretical;
        this.course_load_practical = course_load_practical;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getRegularScore() {
        return regularScore;
    }

    public void setRegularScore(String regularScore) {
        this.regularScore = regularScore;
    }

    public String getProgressScore() {
        return progressScore;
    }

    public void setProgressScore(String progressScore) {
        this.progressScore = progressScore;
    }

    public String getExamScore() {
        return examScore;
    }

    public void setExamScore(String examScore) {
        this.examScore = examScore;
    }

    public int getCourse_load_theoretical() {
        return course_load_theoretical;
    }

    public void setCourse_load_theoretical(int course_load_theoretical) {
        this.course_load_theoretical = course_load_theoretical;
    }

    public int getCourse_load_practical() {
        return course_load_practical;
    }

    public void setCourse_load_practical(int course_load_practical) {
        this.course_load_practical = course_load_practical;
    }

    public String getResult(){
        int a = Integer.parseInt(getExamScore());
        int b = Integer.parseInt(getProgressScore());
        int c = Integer.parseInt(getRegularScore());
        double sum = (a + b + c) * 1.0 / 3;
        if(sum < 4)
            return "F";
        else if(sum >= 4 && sum <= 5.4)
            return "D";
        else if(sum >= 5.5 && sum <= 6.9)
            return "C";
        else if(sum >= 7 && sum <= 8.4)
            return "B";
        else return "A";
    }
}
