package com.notekeepingapp.NoteKeepingAppDemo.service;

import com.notekeepingapp.NoteKeepingAppDemo.DAO.UserRepository;
import com.notekeepingapp.NoteKeepingAppDemo.model.User;
import com.notekeepingapp.NoteKeepingAppDemo.service.userservice.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    User mockUser = new User("admin","admin");
    User invalidUser = new User("admin1","password");

    @Test
    public void shouldReturnTrue_For_ValidCredentials(){
        when(userRepository.findByUsername("admin")).thenReturn(mockUser);
        assertEquals(true, userService.isValidCredentials(mockUser));
    }

    @Test
    public void shouldReturnFalse_For_InvalidCredentials(){
        when(userRepository.findByUsername("admin")).thenReturn(mockUser);
        assertEquals(false, userService.isValidCredentials(invalidUser));
    }

    @Test
    public void shouldReturnPassword_For_GivenUser(){
        when(userRepository.findByUsername("admin")).thenReturn(mockUser);
        assertEquals("admin", userService.getUserPasswordFromDB(mockUser));
    }

    @Test
    public void shouldReturnTrue_For_RegisteredUser(){
        when(userRepository.findByUsername("admin")).thenReturn(mockUser);
        assertEquals(true, userService.isUserRegistered(mockUser));
    }

    @Test
    public void shouldReturnTrue_For_UnregisteredUser(){
        when(userRepository.findByUsername("admin")).thenReturn(mockUser);
        assertEquals(false, userService.isUserRegistered(invalidUser));
    }

}