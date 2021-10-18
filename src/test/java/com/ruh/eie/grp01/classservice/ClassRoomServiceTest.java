package com.ruh.eie.grp01.classservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ClassRoomServiceTest {


    @Test
    @DisplayName("Should saveStudent in classStudentStore calls when assign new student to the class")
    public void should_SaveStudentCalls_when_AssignStudent(){

        ClassStudentStore classStudentStore = mock(ClassStudentStore.class);
        doNothing().when(classStudentStore).saveStudent("OODPP", 1);

        ClassRoomService service = new ClassRoomService(classStudentStore);
        service.assignStudent("OODPP",1);

        verify(classStudentStore).saveStudent("OODPP",1);


    }

    @Test
    @DisplayName("Should removeStudent in classStudentStore calls when removing student")
    public void should_RemoveStudentCalls_when_RemovingStudent(){

        ClassStudentStore classStudentStore = mock(ClassStudentStore.class);
        doNothing().when(classStudentStore).removeStudent("OODPP", 1);

        ClassRoomService service = new ClassRoomService(classStudentStore);
        service.removeStudent("OODPP",1);

        verify(classStudentStore).removeStudent("OODPP",1);


    }
}
