package com.Ha.Anh.dto;

public class StudentGradeDto {

    private String studentID;
    private String studentName;
    private Double regularGrade1;
    private Double regularGrade2;
    private Double finalGrade;
    private Integer absentHours;
    private String examCondition;

    public StudentGradeDto(String studentID, String studentName, Double regularGrade1,
                           Double regularGrade2, Double finalGrade, Integer absentHours,
                           String examCondition) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.regularGrade1 = regularGrade1;
        this.regularGrade2 = regularGrade2;
        this.finalGrade = finalGrade;
        this.absentHours = absentHours;
        this.examCondition = examCondition;
    }

    // Getters and Setters

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getRegularGrade1() {
        return regularGrade1;
    }

    public void setRegularGrade1(Double regularGrade1) {
        this.regularGrade1 = regularGrade1;
    }

    public Double getRegularGrade2() {
        return regularGrade2;
    }

    public void setRegularGrade2(Double regularGrade2) {
        this.regularGrade2 = regularGrade2;
    }

    public Double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public Integer getAbsentHours() {
        return absentHours;
    }

    public void setAbsentHours(Integer absentHours) {
        this.absentHours = absentHours;
    }

    public String getExamCondition() {
        return examCondition;
    }

    public void setExamCondition(String examCondition) {
        this.examCondition = examCondition;
    }
}
