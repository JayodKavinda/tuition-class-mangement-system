package com.ruh.eie.grp01.sessionService;

import com.ruh.eie.grp01.classservice.ClassStudentStore;
import com.ruh.eie.grp01.student.Student;

import java.util.ArrayList;
import java.util.List;

public class InMemorySessionStore implements SessionStore {

    private List<Session> sessionList = new ArrayList<>();

    private ClassStudentStore classStudentStore;

    public InMemorySessionStore(ClassStudentStore classStudentStore) {
        this.classStudentStore = classStudentStore;
    }


    @Override
    public void saveSession(Session session) {
        sessionList.add(session);
        System.out.println("Session created!: "+ session);

        //Automatically get attendace when session is created.
        getAttendance(session.getClassRoom().getClassName());
    }

    public List<Student> getAttendance(String className){
        List<Student> students = classStudentStore.getStudents(className);
        System.out.println("Students attendance Report: (No of students = " + students.size() + ")");
        System.out.println("Attend Students >>");
        System.out.println(students);

        return students;
    }

    @Override
    public List<Session> getAllSession() {
        return sessionList;
    }
}
