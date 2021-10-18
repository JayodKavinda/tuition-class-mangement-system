package com.ruh.eie.grp01.sessionService;

import com.ruh.eie.grp01.clases.ClassRoom;

public class Session {

    private String date;
    private String fromTime;
    private String toTime;
    private ClassRoom classRoom;

    public Session(String date, String fromTime, String toTime, ClassRoom classRoom) {
        this.date = date;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.classRoom = classRoom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Session{" +
                "date='" + date + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", classRoom=" + classRoom.getClassName() +
                '}';
    }
}
