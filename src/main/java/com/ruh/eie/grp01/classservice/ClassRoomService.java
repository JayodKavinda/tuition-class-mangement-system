package com.ruh.eie.grp01.classservice;



public class ClassRoomService implements ClassConfigurable {

    private final ClassStudentStore classStudentStore;

    public ClassRoomService(ClassStudentStore classStudentStore) {
        this.classStudentStore = classStudentStore;
    }


    @Override
    public void assignStudent(String classRoomName, int studentId) {
        classStudentStore.saveStudent(classRoomName, studentId);
    }

    @Override
    public void removeStudent(String classRoomName, int studentId) {
        classStudentStore.removeStudent(classRoomName,studentId);
    }
}
