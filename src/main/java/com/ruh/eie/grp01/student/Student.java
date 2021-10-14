package com.ruh.eie.grp01.student;


public class Student {
    private int id;
    private String name;
    private String dateOfBirth;
    private String joinedDate;

    public Student(int id, String name, String dateOfBirth, String joinedDate) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.joinedDate = joinedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", joinedDate='" + joinedDate + '\'' +
                '}';
    }
}
