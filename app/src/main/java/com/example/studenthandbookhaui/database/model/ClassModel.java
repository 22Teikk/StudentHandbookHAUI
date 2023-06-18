package com.example.studenthandbookhaui.database.model;

public class ClassModel extends BaseModel {
    private String courseId;
    private String classCourse;
    private String dayInWeek;
    private String timeInDay;
    private String room;

    private String classCode;

    public ClassModel(String courseId, String classCourse, String dayInWeek, String timeInDay, String room, String classCode){
        this.courseId = courseId;
        this.classCourse = classCourse;
        this.dayInWeek = dayInWeek;
        this.timeInDay = timeInDay;
        this.room = room;
        this.classCode = classCode;
    }

    public ClassModel(){}

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getClassCourse() {
        return classCourse;
    }

    public void setClassCourse(String classCourse) {
        this.classCourse = classCourse;
    }

    public String getDayInWeek() {
        return dayInWeek;
    }

    public void setDayInWeek(String dayInWeek) {
        this.dayInWeek = dayInWeek;
    }

    public String getTimeInDay() {
        return timeInDay;
    }

    public void setTimeInDay(String timeInDay) {
        this.timeInDay = timeInDay;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
}
