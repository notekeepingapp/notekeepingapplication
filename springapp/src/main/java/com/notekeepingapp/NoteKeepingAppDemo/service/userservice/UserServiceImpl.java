package com.notekeepingapp.NoteKeepingAppDemo.service.userservice;

import com.notekeepingapp.NoteKeepingAppDemo.model.User;
import com.notekeepingapp.NoteKeepingAppDemo.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Qualifier("userRepository")
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValidCredentials(User user) {
        return user.getPassword().equals(getUserPasswordFromDB(user));
    }

    @Override
    public String getUserPasswordFromDB(User user) {
        User registeredUser = userRepository.findByUsername(user.getUsername());
        if (registeredUser != null)
            return registeredUser.getPassword();
        return null;
    }

    @Override
    public boolean isUserRegistered(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        return userFromDB != null;
    }
}
