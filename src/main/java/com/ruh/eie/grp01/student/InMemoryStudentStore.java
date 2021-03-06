package com.ruh.eie.grp01.student;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentStore implements StudentStore {

    private List<Student> studentList = new ArrayList<>();

    @Override
    public void save(Student student) {
        studentList.add(student);
        System.out.println("Successfully created student");
    }

    @Override
    public Student getStudent(int id) {
        for (Student student: studentList){
            if(student.getId()==id)
                return student;
        }

        throw new StudentNotFoundException("Student is not found id: "+ id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }
}
