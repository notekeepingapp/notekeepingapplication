package com.notekeepingapp.NoteKeepingAppDemo.service;

import com.notekeepingapp.NoteKeepingAppDemo.DAO.UserRepository;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Test
    public void userRepositoryAutowired(){
        assertNotNull(userRepository);
    }

}
