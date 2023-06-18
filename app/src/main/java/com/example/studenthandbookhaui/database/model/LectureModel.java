package com.example.studenthandbookhaui.database.model;

public class LectureModel extends BaseModel {
    String name;
    ClassModel lectureClass;
    CourseModel course;

    public LectureModel(String name, ClassModel cls, CourseModel course) {
        this.name = name;
        this.lectureClass = cls;
        this.course = course;
    }

    public LectureModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassModel getLectureClass() {
        return lectureClass;
    }

    public void setLectureClass(ClassModel lectureClass) {
        this.lectureClass = lectureClass;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }
}
