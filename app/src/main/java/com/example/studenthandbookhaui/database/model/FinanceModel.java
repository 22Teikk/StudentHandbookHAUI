package com.example.studenthandbookhaui.database.model;

public class FinanceModel extends BaseModel{
    private String nameCourse;
    private String debt_paid_date;
    private int debt;

    public FinanceModel(){}

    public FinanceModel(String nameCourse, String debt_paid_date, int debt) {
        this.nameCourse = nameCourse;
        this.debt_paid_date = debt_paid_date;
        this.debt = debt;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getDebt_paid_date() {
        return debt_paid_date;
    }

    public void setDebt_paid_date(String debt_paid_date) {
        this.debt_paid_date = debt_paid_date;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }
}
