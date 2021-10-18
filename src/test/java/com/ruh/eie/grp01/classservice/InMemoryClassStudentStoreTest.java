package com.ruh.eie.grp01.classservice;

import com.ruh.eie.grp01.clases.ClassRoom;
import com.ruh.eie.grp01.clases.ClassStore;
import com.ruh.eie.grp01.student.Student;
import com.ruh.eie.grp01.student.StudentStore;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.*;

public class InMemoryClassStudentStoreTest {


    @Test
    public void should_GetStudent_when_TryToSaveStudent(){

        StudentStore studentStore = mock(StudentStore.class);
        ClassStore classStore = mock(ClassStore.class);

        Student student= new Student(1,"Kamal","1997","2021");
        doReturn(student).when(studentStore).getStudent(1);


        InMemoryClassStudentStore store = new InMemoryClassStudentStore(studentStore, classStore);
        store.saveStudent("OODPP",1);

        verify(studentStore).getStudent(1);

    }

    @Test
    public void should_GetClass_when_TryToSaveStudent(){

        StudentStore studentStore = mock(StudentStore.class);
        ClassStore classStore = mock(ClassStore.class);

        Student student= new Student(1,"Kamal","1997","2021");
        doReturn(student).when(studentStore).getStudent(1);

        ClassRoom classRoom = new ClassRoom(2020,"OODPP","Mr.Chamil");
        doReturn(classRoom).when(classStore).getClass("OODPP");


        InMemoryClassStudentStore store = new InMemoryClassStudentStore(studentStore, classStore);
        store.saveStudent("OODPP",1);

        verify(studentStore).getStudent(1);
        verify(classStore).getClass("OODPP");

    }


    @Test
    public void should_GetAllStudents_when_GivenClassName(){

        StudentStore studentStore = mock(StudentStore.class);
        ClassStore classStore = mock(ClassStore.class);

        Student student1= new Student(1,"Kamal","1997","2021");
        Student student2= new Student(2,"Nimal","1998","2022");

        doReturn(student1).when(studentStore).getStudent(1);
        doReturn(student2).when(studentStore).getStudent(2);

        ClassRoom classRoom = new ClassRoom(2020,"OODPP","Mr.Chamil");
        doReturn(classRoom).when(classStore).getClass("OODPP");


        InMemoryClassStudentStore store = new InMemoryClassStudentStore(studentStore, classStore);
        store.saveStudent("OODPP",1);
        store.saveStudent("OODPP",2);

        assertThat(store.getStudents("OODPP"), containsInAnyOrder(student1,student2));

    }
}
