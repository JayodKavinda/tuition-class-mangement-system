package com.ruh.eie.grp01.clases;

import java.util.ArrayList;
import java.util.List;

public class InMemoryClassStore implements ClassStore {

    List<ClassRoom> classRooms = new ArrayList<>();

    @Override
    public void save(ClassRoom classRoom) {
        classRooms.add(classRoom);
    }

    @Override
    public ClassRoom getClass(String className) {
        for(ClassRoom classRoom: classRooms){
            if(classRoom.getClassName().equals(className))
                return classRoom;
        }
        throw new RuntimeException("ClassRoom not found: "+ className);
    }

    @Override
    public List<ClassRoom> getAllClasses() {
        return classRooms;
    }
}
