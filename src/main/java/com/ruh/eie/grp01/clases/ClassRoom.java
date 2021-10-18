package com.ruh.eie.grp01.clases;

public class ClassRoom {

    private int year;
    private String className;
    private String teacherName;

    public ClassRoom(int year, String className, String teacherName) {
        this.year = year;
        this.className = className;
        this.teacherName = teacherName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
