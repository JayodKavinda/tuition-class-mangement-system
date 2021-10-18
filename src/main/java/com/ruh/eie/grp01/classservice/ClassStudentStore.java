package com.ruh.eie.grp01.classservice;

import com.ruh.eie.grp01.student.Student;

import java.util.List;

public interface ClassStudentStore {

    void saveStudent(String classRoomName, int studentId);
    void removeStudent(String classRoomName, int studentId);
    List<Student> getStudents(String classRoomName);
}
