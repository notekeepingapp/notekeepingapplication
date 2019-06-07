package com.notekeepingapp.NoteKeepingAppDemo.service.userservice;

import com.notekeepingapp.NoteKeepingAppDemo.model.User;

public interface UserService {

    public boolean isValidCredentials(User user);

    public String getUserPasswordFromDB(User user);

    public boolean isUserRegistered(User user);
}
