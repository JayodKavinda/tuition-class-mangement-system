package com.ruh.eie.grp01.sessionService;

import com.ruh.eie.grp01.clases.ClassRoom;
import com.ruh.eie.grp01.classservice.ClassStudentStore;
import com.ruh.eie.grp01.student.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class InMemorySessionStoreTest {


    @Test
    public void should_SaveSession_when_SessionIsCreated(){

        ClassStudentStore classStudentStore = mock(ClassStudentStore.class);
        doNothing().when(classStudentStore).saveStudent("OODPP", 1);

        ClassRoom classRoom= new ClassRoom(2020,"OOP","Janaka");
        Session session = new Session("2020","10.00am","12.00am",classRoom);
        InMemorySessionStore store = new InMemorySessionStore(classStudentStore);
        store.saveSession(session);

        assertThat(store.getAllSession(), hasSize(1));


    }

    @Test
    public void should_ContainSession_when_SessionSaved(){

        ClassStudentStore classStudentStore = mock(ClassStudentStore.class);
        doNothing().when(classStudentStore).saveStudent("OODPP", 1);

        ClassRoom classRoom= new ClassRoom(2020,"OOP","Janaka");
        Session session = new Session("2020","10.00am","12.00am",classRoom);
        InMemorySessionStore store = new InMemorySessionStore(classStudentStore);
        store.saveSession(session);


        assertThat(store.getAllSession(), contains(session));

    }

    @Test
    public void should_GetAllSessions_when_RetriveAll(){
        ClassStudentStore classStudentStore = mock(ClassStudentStore.class);
        doNothing().when(classStudentStore).saveStudent("OODPP", 1);

        ClassRoom classRoom= new ClassRoom(2020,"OOP","Janaka");
        Session session1 = new Session("2020","10.00am","12.00am",classRoom);
        Session session2 = new Session("2021","11.00am","02.00am",classRoom);
        InMemorySessionStore store = new InMemorySessionStore(classStudentStore);
        store.saveSession(session1);
        store.saveSession(session2);

        assertThat(store.getAllSession(), containsInAnyOrder(session1,session2));

    }


    @Test
    public void should_GetAttendace_when_SessionCreated(){
        ClassStudentStore classStudentStore = mock(ClassStudentStore.class);

        Student student1 = new Student(1,"Nimal","1997","2020");
        Student student2 = new Student(2,"Kamal","1998","2021");

        //doNothing().when(classStudentStore).saveStudent("OODPP", 1);
        //doNothing().when(classStudentStore).saveStudent("OODPP", 2);
        doReturn(List.of(student1,student2)).when(classStudentStore).getStudents("OODPP");

        ClassRoom classRoom= new ClassRoom(2020,"OODPP","Janaka");
        Session session1 = new Session("2020","10.00am","12.00am",classRoom);

        InMemorySessionStore store = new InMemorySessionStore(classStudentStore);
        store.saveSession(session1);


        assertThat(store.getAttendance("OODPP"), hasSize(2));

    }


}
