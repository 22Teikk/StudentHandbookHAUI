package com.example.studenthandbookhaui.database.model;

import java.util.Date;

public class FinanceModel extends BaseModel{
    private String classID;
    private String nameCourse;
    private Date debtPaidDate;
    private int debt;

    private boolean isSelected;

    public FinanceModel(){}

    public FinanceModel(String nameCourse, String classId, Date debtPaidDate, int debt) {
        this.nameCourse = nameCourse;
        this.classID = classId;
        this.debtPaidDate = debtPaidDate;
        this.debt = debt;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Date getDebtPaidDate() {
        return debtPaidDate;
    }

    public void setDebtPaidDate(Date debtPaidDate) {
        this.debtPaidDate = debtPaidDate;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
