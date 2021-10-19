# Online Tuition Class Management System

This application is a command-line based application that will be used by the system administrator to manage online tuition classes (Application documentation is shown below)
This application is aligned with object-oriented best practices with SOLID principles and various design patterns. The unit testing for each test case has been written for all the business classes using Junit, Mokito, and Hamcrest. Some business logic has been written using Test Driven Development (TDD) approach. The code analysis was done using SonarQube analyzer, and critical changes were appropriately made to enhance overall code quality ensuring robust, reusable, and clean code. 

## Group Members
1. Weraniyagoda W.A.S.A - EG/2017/3079
2. Duwaraga S. - EG/2017/3201
3. Kavinda J.K.A.J - EG/2017/3214
4. Ariyadasa J.G.M - EG/2017/3249

## Application Documentation
1.	Creating new Student: 
    `create student <id> <name> <dateOfBirth> <joinedDate>`
2.	Creating new Class : 
    `create class <year> <className> <teacherName>`
3.	Assign a student to class :
    `assign <className> <studentId>`
4.	Create a new session: 
    `create session <date> <fromTime> <toTime> <className>`
5.  Attendance report will automatically generate after creating session

![sample](https://drive.google.com/file/d/15qUnL2vPBc8iUbOV3MCXOor7pjgtiFzF/view?usp=sharing)
