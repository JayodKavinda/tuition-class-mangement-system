package com.ruh.eie.grp01.classservice;

import com.ruh.eie.grp01.clases.ClassRoom;
import com.ruh.eie.grp01.clases.ClassStore;
import com.ruh.eie.grp01.student.Student;
import com.ruh.eie.grp01.student.StudentNotFoundException;
import com.ruh.eie.grp01.student.StudentStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryClassStudentStore implements ClassStudentStore {

    private Map<ClassRoom, List<Student>> classStudents = new HashMap<>();
    private StudentStore studentStore;
    private ClassStore classStore;

    public InMemoryClassStudentStore(StudentStore studentStore, ClassStore classStore) {
        this.studentStore = studentStore;
        this.classStore = classStore;
    }


    @Override
    public void saveStudent(String classRoomName, int studentId) {
        ClassRoom classRoom = classStore.getClass(classRoomName);
        Student student = studentStore.getStudent(studentId);

        List<Student> studentList= classStudents.get(classRoom);
        if(studentList ==null){
            studentList = new ArrayList<>();
        }
        studentList.add(student);
        classStudents.put(classRoom,studentList);

        System.out.println("Student assigned to ClassRoom "+ classRoomName);
        for(Student stu: studentList){
            System.out.println(" ->students:"+ stu);
        }

    }

    @Override
    public void removeStudent(String classRoomName, int studentId) {
        ClassRoom classRoom = classStore.getClass(classRoomName);
        Student student = studentStore.getStudent(studentId);

        List<Student> studentList= classStudents.get(classRoom);
        if(!studentList.contains(student)){
            throw new StudentNotFoundException("Student not found: "+ studentId);
        }
        studentList.remove(student);
        classStudents.put(classRoom,studentList);

        System.out.println("ClassRoom: "+ classRoomName);
        for(Student stu: studentList){
            System.out.println(" students:"+ stu);
        }
    }

    @Override
    public List<Student> getStudents(String classRoomName) {
        ClassRoom classRoom = classStore.getClass(classRoomName);

        List<Student> studentList =  classStudents.get(classRoom);

        if(studentList ==null) {
           throw new StudentNotFoundException("Students not found");
        }
        return studentList;
    }
}
