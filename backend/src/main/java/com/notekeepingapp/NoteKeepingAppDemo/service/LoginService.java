package com.notekeepingapp.NoteKeepingAppDemo.service;

import com.notekeepingapp.NoteKeepingAppDemo.model.User;
import com.notekeepingapp.NoteKeepingAppDemo.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public boolean isValidCredentials(User user) {
        return user.getPassword().equals(getUserPasswordFromDB(user));
    }

    public String getUserPasswordFromDB(User user) {
        List<User> registeredUser = userRepository.findByUsername(user.getUsername());
        if (registeredUser != null)
            return registeredUser.get(0).getPassword();
        return null;
    }

    public boolean isUserRegistered(User user) {
        List<User> users = userRepository.findByUsername(user.getUsername());
        return users.size() != 0;
    }
}
