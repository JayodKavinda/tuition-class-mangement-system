# Online Tuition Class Management System

This application is command line based application will be used by the system administrator to manage online tuition classes (Application documentation is shown as below)
This application is align with object oriented best practices with SOLID principles and various design patterns. The unit testing for each test cases has been written for all the business classes using Junit, Mokito and Hamcrest. Some business logics has been written using Test Driven Development (TDD) approach.

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

![alt text](https://drive.google.com/file/d/15qUnL2vPBc8iUbOV3MCXOor7pjgtiFzF/view?usp=sharing)
