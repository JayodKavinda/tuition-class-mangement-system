package com.ruh.eie.grp01.sessionService;

import java.util.List;

public interface SessionStore {


    void saveSession(Session session);

    List<Session> getAllSession();
}
