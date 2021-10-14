package com.ruh.eie.grp01.student;

import java.util.List;

public interface StudentStore {
    void save(Student student);
    Student getStudent(int id);
    List<Student> getAllStudents();
}

