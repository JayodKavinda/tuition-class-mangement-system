package com.ruh.eie.grp01.clases;

import java.util.List;

public interface ClassStore {

    void save(ClassRoom classRoom);

    ClassRoom getClass(String className);

    List<ClassRoom> getAllClasses();
}
