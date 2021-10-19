package com.ruh.eie.grp01.clases;

import java.util.ArrayList;
import java.util.List;

public class InMemoryClassStore implements ClassStore {

    private List<ClassRoom> classRooms = new ArrayList<>();

    @Override
    public void save(ClassRoom classRoom) {
        classRooms.add(classRoom);
        System.out.println("Successfully created class");
    }

    @Override
    public ClassRoom getClass(String className) {
        for(ClassRoom classRoom: classRooms){
            if(classRoom.getClassName().equals(className))
                return classRoom;
        }
        throw new ClassRoomNotFoundException("ClassRoom not found: "+ className);
    }

    @Override
    public List<ClassRoom> getAllClasses() {
        return classRooms;
    }
}
