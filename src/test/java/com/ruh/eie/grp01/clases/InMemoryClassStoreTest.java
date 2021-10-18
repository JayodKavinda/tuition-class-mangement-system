package com.ruh.eie.grp01.clases;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class InMemoryClassStoreTest {

    @Test
    public void should_ReturnEmptyList_when_FirstTime(){
        InMemoryClassStore store = new InMemoryClassStore();
        assertThat(store.getAllClasses(), is(empty()));

    }

    @Test
    public void should_StoreClass_when_ClassIsGiven(){
        InMemoryClassStore store = new InMemoryClassStore();
        ClassRoom classRoom = new ClassRoom(2020,"OODPP","Mr.Chamil");
        store.save(classRoom);
        assertThat(store.getAllClasses(), hasSize(1));

    }

    @Test
    public void should_GetClass_when_ClassIsAvailable(){
        InMemoryClassStore store = new InMemoryClassStore();
        ClassRoom classRoom = new ClassRoom(2020,"OODPP","Mr.Chamil");
        store.save(classRoom);
        assertThat(store.getAllClasses(), contains(classRoom));

    }



    @Test
    public void should_GetClass_when_ClassIdGiven(){
        InMemoryClassStore store = new InMemoryClassStore();
        ClassRoom classRoom = new ClassRoom(2021,"OODPP","Mr.Chamil");

        store.save(classRoom);
        assertThat(store.getClass("OODPP"), equalTo(classRoom));

    }

    @Test
    public void should_GetAllClasses_when_StoreHasManyClasses(){
        InMemoryClassStore store = new InMemoryClassStore();
        ClassRoom classRoom1 = new ClassRoom(2021,"OODPP","Mr.Chamil");
        ClassRoom classRoom2 = new ClassRoom(2023,"OOP","Mr.Nimal");

        store.save(classRoom1);
        store.save(classRoom2);
        assertThat(store.getAllClasses(), containsInAnyOrder(classRoom1,classRoom2));

    }


}
