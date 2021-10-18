package com.ruh.eie.grp01;

import com.ruh.eie.grp01.clases.ClassRoom;
import com.ruh.eie.grp01.clases.ClassStore;
import com.ruh.eie.grp01.clases.InMemoryClassStore;
import com.ruh.eie.grp01.classservice.ClassConfigurable;
import com.ruh.eie.grp01.classservice.ClassRoomService;
import com.ruh.eie.grp01.classservice.ClassStudentStore;
import com.ruh.eie.grp01.classservice.InMemoryClassStudentStore;
import com.ruh.eie.grp01.sessionService.InMemorySessionStore;
import com.ruh.eie.grp01.sessionService.Session;
import com.ruh.eie.grp01.sessionService.SessionStore;
import com.ruh.eie.grp01.student.InMemoryStudentStore;
import com.ruh.eie.grp01.student.Student;
import com.ruh.eie.grp01.student.StudentStore;

import java.util.List;
import java.util.Scanner;

/**
 Online Tuition Class Management System
 This application is command line based application will be used by the system administrator to manage online tuition classes (Application documentation is shown as below)
 This application is align with object oriented best practices with SOLID principles and various design patterns. The unit testing for each test cases has been written for all the business classes using Junit, Mokito and Hamcrest. Some business logics has been written using Test Driven Development (TDD) approach.

 Application Documentation
 1.	Creating new Student: create student <id> <name> <dateOfBirth> <joinedDate>
 2.	Creating new Class : create class <year> <className> <teacherName>
 3.	Assign a student to class : assign <className> <studentId>
 4.	Create a new session: create session <date> <fromTime> <toTime> <className>

 Attendance report will automatically generate after creating session
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        StudentStore studentStore = new InMemoryStudentStore();
        ClassStore classStore = new InMemoryClassStore();

        ClassStudentStore classStudentStore = new InMemoryClassStudentStore(studentStore, classStore);

        ClassConfigurable classConfigurable = new ClassRoomService(classStudentStore);

        SessionStore sessionStore = new InMemorySessionStore(classStudentStore);

        System.out.println("Enter your command: ");

        while (true){
            String cmd =scanner.nextLine();

            if(cmd.equals("exit"))
                return;

            String[] input = cmd.split(" ");

            switch (input[0]) {
                case "create":
                    switch (input[1]) {
                        case "student":
                            Student newStudent = new Student(Integer.parseInt(input[2]), input[3], input[4], input[5]);
                            studentStore.save(newStudent);
                            break;
                        case "class": {
                            ClassRoom classRoom = new ClassRoom(Integer.parseInt(input[2]), input[3], input[4]);
                            classStore.save(classRoom);
                            break;
                        }
                        case "session": {
                            ClassRoom classRoom = classStore.getClass(input[5]);
                            Session session = new Session(input[2], input[3], input[4], classRoom);
                            sessionStore.saveSession(session);
                            break;
                        }
                    }

                    break;
                case "assign":
                    classConfigurable.assignStudent(input[1], Integer.parseInt(input[2]));
                    break;
                case "show":
                    List<Student> studentList = studentStore.getAllStudents();
                    for (Student student : studentList) {
                        System.out.println(student);
                    }
                    break;
            }

        }
    }
}
