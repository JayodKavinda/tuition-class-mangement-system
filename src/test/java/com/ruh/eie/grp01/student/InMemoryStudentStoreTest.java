package com.ruh.eie.grp01.student;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class InMemoryStudentStoreTest {

    @Test
    public void should_ReturnEmptyList_when_FirstTime(){
        InMemoryStudentStore store = new InMemoryStudentStore();
        assertThat(store.getAllStudents(), is(empty()));

    }

    @Test
    public void should_StoreStudent_when_StudentIsGiven(){
        InMemoryStudentStore store = new InMemoryStudentStore();
        Student student = new Student(1,"Kamal","1997-09-09", "2020-08-09");
        store.save(student);
        assertThat(store.getAllStudents(), hasSize(1));

    }

    @Test
    public void should_GetStudent_when_StudentIsAvailable(){
        InMemoryStudentStore store = new InMemoryStudentStore();
        Student student = new Student(1,"Kamal","1997-09-09", "2020-08-09");
        store.save(student);
        assertThat(store.getAllStudents(), contains(student));

    }

    @Test
    public void should_GetAllStudent_when_StoreHasManyNames(){
        InMemoryStudentStore store = new InMemoryStudentStore();
        Student student1 = new Student(1,"Kamal","1997-09-09", "2020-08-09");
        Student student2 = new Student(2,"Nimal","1998-09-09", "2021-08-09");

        store.save(student1);
        store.save(student2);
        assertThat(store.getAllStudents(), containsInAnyOrder(student1,student2));

    }

    @Test
    public void should_GetStudent_when_StudentIdGiven(){
        InMemoryStudentStore store = new InMemoryStudentStore();
        Student student1 = new Student(1,"Kamal","1997-09-09", "2020-08-09");
        Student student2 = new Student(2,"Nimal","1998-09-09", "2021-08-09");

        store.save(student1);
        store.save(student2);

        assertThat(store.getStudent(1), equalTo(student1));
        assertThat(store.getStudent(2), equalTo(student2));

    }
}
